package gov.nist.hla.ii;

import gov.nist.hla.ii.exception.FileFormatException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class SOMReader {
  private static final Logger log = LogManager.getLogger();
  
  private class Sharing {
    private static final String PUBLISHED = "publish";
    private static final String SUBSCRIBED = "subscribe";
    
    private String text;
    
    // accepts malformed strings
    public Sharing(String text) {
      this.text = text.toLowerCase();
    }
    
    public Sharing(Sharing sharing) {
      this.text = sharing.text;
    }
    
    public void union(Sharing sharing) {
      String newText = "";
      
      if (this.isPublished() || sharing.isPublished()) {
        newText += PUBLISHED;
      }
      if (this.isSubscribed() || sharing.isSubscribed()) {
        newText += SUBSCRIBED;
      }
      this.text = newText;
    }
    
    public boolean isPublished() {
      return text.contains(PUBLISHED);
    }
    
    public boolean isSubscribed() {
      return text.contains(SUBSCRIBED);
    }
    
    public String getText() {
      return text;
    }
  }
  
  private DocumentBuilder builder;
  
  // map from interaction.parameter or object.attribute to dataType
  private HashMap<String, HashMap<String, String>> dataTypes = new HashMap<String, HashMap<String, String>>();
  
  // map from an interaction class name to its Sharing state
  private HashMap<String, Sharing> interactionSharing = new HashMap<String, Sharing>();
  
  // map from an object class name to its Sharing state (the union of the Sharing state of its attributes)
  private HashMap<String, Sharing> objectSharing = new HashMap<String, Sharing>();
  
  // map from object.attribute to that attribute's Sharing state
  private HashMap<String, HashMap<String, Sharing>> attributeSharing = new HashMap<String, HashMap<String, Sharing>>();
  
  public SOMReader()
      throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    this.builder = factory.newDocumentBuilder();
  }
  
  // returns null if not found
  public String getDataType(String className, String parameter) {
    if (dataTypes.containsKey(className) == false) {
      return null;
    }
    return dataTypes.get(className).get(parameter);
  }
  
  public LinkedList<String> getPublishedInteractions() {
    return filterSharingMap(interactionSharing, 'p');
  }
  
  public LinkedList<String> getSubscribedInteractions() {
    return filterSharingMap(interactionSharing, 's');
  }
  
  public LinkedList<String> getParameterNames(String interactionClass) {
    LinkedList<String> result = new LinkedList<String>();
    
    if (dataTypes.containsKey(interactionClass)) {
      for (String nextName : dataTypes.get(interactionClass).keySet()) {
        result.add(nextName);
      }
    }
    return result;
  }
  
  public LinkedList<String> getPublishedObjects() {
    return filterSharingMap(objectSharing, 'p');
  }
  
  public LinkedList<String> getSubscribedObjects() {
    return filterSharingMap(objectSharing, 's');
  }
  
  public LinkedList<String> getPublishedAttributes(String objectName) {
    LinkedList<String> result = new LinkedList<String>();
    
    if (attributeSharing.containsKey(objectName)) {
      result = filterSharingMap(attributeSharing.get(objectName), 'p');
    }
    return result;
  }
  
  public LinkedList<String> getSubscribedAttributes(String objectName) {
    LinkedList<String> result = new LinkedList<String>();
    
    if (attributeSharing.containsKey(objectName)) {
      result = filterSharingMap(attributeSharing.get(objectName), 's');
    }
    return result;
  }
  
  // filterType can equal 's' to get subscriptions or 'p' to get publications
  private LinkedList<String> filterSharingMap(final HashMap<String, Sharing> map, char filterType) {
    char type = Character.toLowerCase(filterType);
    LinkedList<String> result = new LinkedList<String>();
    for (Map.Entry<String, Sharing> entry : map.entrySet()) {
      if ((type == 's' && entry.getValue().isSubscribed()) || (type == 'p' && entry.getValue().isPublished())) {
        result.add(entry.getKey());
      }
    }
    return result;
  }
  
  private void reinitialize() {
    dataTypes = new HashMap<String, HashMap<String, String>>();
    interactionSharing = new HashMap<String, Sharing>();
    objectSharing = new HashMap<String, Sharing>();
    attributeSharing = new HashMap<String, HashMap<String, Sharing>>();
  }
  
  private LinkedList<Element> getChildrenByTagName(Element parent, String tagName) {
    LinkedList<Element> children = new LinkedList<Element>();
    
    Node childNode = parent.getFirstChild();
    while (childNode.getNextSibling() != null) {
      if (childNode.getNodeType() == Node.ELEMENT_NODE) {
        Element childElement = (Element)childNode;
        if (childElement.getTagName().equals(tagName)) {
          children.add(childElement);
        }
      }
      childNode = childNode.getNextSibling();
    }
    
    return children;
  }
  
  public void readXML(String filepath)
      throws IOException,
             FileFormatException {
    InputStream input = null;
    
    reinitialize();

    try {
      log.info("reading the SOM file " + filepath);
      File file = new File(filepath);
      URI uri = file.toURI();
      input = uri.toURL().openStream();
      Document document = builder.parse(input);
      Element root = document.getDocumentElement();
      
      log.debug("on interactions...");
      LinkedList<Element> interactions = getChildrenByTagName(root, "interactions");
      if (interactions.size() > 1) {
        throw new FileFormatException("SOM contains multiple interaction tables");
      } else if (interactions.isEmpty()) {
        log.info("SOM does not contain an interaction table");
      } else {
        LinkedList<Element> interactionClass = getChildrenByTagName(interactions.getFirst(), "interactionClass");
        if (interactionClass.size() > 1) {
          throw new FileFormatException("SOM contains multiple top-level interaction classes");
        } else if (interactionClass.isEmpty()) {
          log.info("SOM does not contain any interaction classes");
        } else {
          parseInteraction(interactionClass.getFirst(), "");
        }
      }
      
      log.debug("on objects...");
      LinkedList<Element> objects = getChildrenByTagName(root, "objects");
      if (objects.size() > 1) {
        throw new FileFormatException("SOM contains multiple object tables");
      } else if (objects.isEmpty()) {
        log.info("SOM does not contain an object table");
      } else {
        LinkedList<Element> objectClass = getChildrenByTagName(objects.getFirst(), "objectClass");
        if (objectClass.size() > 1) {
          throw new FileFormatException("SOM contains multiple top-level object classes");
        } else if (objectClass.isEmpty()) {
          log.info("SOM does not contain any object classes");
        } else {
          parseObject(objectClass.getFirst(), "");
        }
      }
    } catch (SAXException e) {
      log.error("format error in SOM file " + filepath);
      throw new FileFormatException(e);
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          log.warn("exception when closing resource", e);
        }
      }
    }
  }
  
  private void parseInteraction(Element interaction, String parent)
      throws FileFormatException {
    String myName = null;
    Sharing mySharing = null;
    HashMap<String, String> myParameters;
    LinkedList<Element> derivedClasses = new LinkedList<Element>();
    
    log.debug("on new interaction...");
    
    if (parent.isEmpty()) { // interaction root
      myParameters = new HashMap<String, String>();
    } else if (dataTypes.containsKey(parent) == false) {
      throw new IllegalArgumentException("parseInteraction called with unknown parent string");
    } else {
      myParameters = new HashMap<String, String>(dataTypes.get(parent));
    }
    
    Node child = interaction.getFirstChild();
    while (child != null) {
      if (child.getNodeType() == Node.ELEMENT_NODE) {
        switch (child.getNodeName()) {
          case "name":
            if (myName != null) {
              throw new FileFormatException("interaction class defines multiple name tags");
            }
            myName = parent.isEmpty() ? child.getTextContent() : parent + "." + child.getTextContent();
            log.debug("\tname = " + myName);
            break;
          case "sharing":
            if (mySharing != null) {
              throw new FileFormatException("interaction class defines multiple sharing tags");
            }
            mySharing = new Sharing(child.getTextContent());
            log.debug("\tsharing = " + mySharing.getText());
            break;
          case "parameter":
            Element element = (Element)child;
            
            LinkedList<Element> nameList = getChildrenByTagName(element, "name");
            LinkedList<Element> dataTypeList = getChildrenByTagName(element, "dataType");
            if (nameList.size() != 1 || dataTypeList.size() != 1) {
              throw new FileFormatException("interaction class has incorrect parameter structure");
            }
            
            String name = nameList.getFirst().getTextContent();
            if (name.isEmpty()) {
              throw new FileFormatException("interaction class defines parameter with empty name");
            }
            
            String dataType = dataTypeList.getFirst().getTextContent();            
            if (myParameters.put(name, dataType) != null) {
              throw new FileFormatException("interaction class defines multiple parameters with name " + name);
            }
            log.debug("\tparameter = " + name + " (" + dataType + ")");
            break;
          case "interactionClass":
            derivedClasses.add((Element)child);
            break;
          default:
            log.debug("skipping element " + child.getNodeName());
        }
      }
      child = child.getNextSibling();
    }
    
    if (myName == null) {
      throw new FileFormatException("interaction class defined without a name");
    }
    if (mySharing == null) {
      throw new FileFormatException("interaction class defined without a sharing type");
    }
    
    dataTypes.put(myName, myParameters);
    interactionSharing.put(myName, mySharing);
    for (Element derived : derivedClasses) {
      parseInteraction(derived, myName);
    }
  }
  
  private void parseObject(Element object, String parent)
      throws FileFormatException {
    String myName = null;
    Sharing mySharing = null;
    HashMap<String, String> myAttributesType;
    HashMap<String, Sharing> myAttributesSharing;
    LinkedList<Element> derivedClasses = new LinkedList<Element>();
    
    log.debug("on new object...");
    
    if (parent.isEmpty()) { // object root
      mySharing = new Sharing("");
      myAttributesType = new HashMap<String, String>();
      myAttributesSharing = new HashMap<String, Sharing>();
    } else if (dataTypes.containsKey(parent) == false) {
      throw new IllegalArgumentException("parseObject called with unknown parent string");
    } else {
      mySharing = new Sharing(objectSharing.get(parent));
      myAttributesType = new HashMap<String, String>(dataTypes.get(parent));
      myAttributesSharing = new HashMap<String, Sharing>(attributeSharing.get(parent));
    }
    
    Node child = object.getFirstChild();
    while (child != null) {
      if (child.getNodeType() == Node.ELEMENT_NODE) {
        switch (child.getNodeName()) {
          case "name":
            if (myName != null) {
              throw new FileFormatException("object class defines multiple name tags");
            }
            myName = parent.isEmpty() ? child.getTextContent() : parent + "." + child.getTextContent();
            log.debug("\tname = " + myName);
            break;
          case "attribute":
            Element element = (Element)child;
            
            LinkedList<Element> nameList = getChildrenByTagName(element, "name");
            LinkedList<Element> dataTypeList = getChildrenByTagName(element, "dataType");
            LinkedList<Element> sharingList = getChildrenByTagName(element, "sharing");
            if (nameList.size() != 1 || dataTypeList.size() != 1 || sharingList.size() != 1) {
              throw new FileFormatException("object class has incorrect attribute structure");
            }
            
            String name = nameList.getFirst().getTextContent();
            if (name.isEmpty()) {
              throw new FileFormatException("object class defines attribute with empty name");
            }
            if (myAttributesType.containsKey(name)) {
              throw new FileFormatException("object class defines multiple attributes with name " + name);
            }
            
            String dataType = dataTypeList.getFirst().getTextContent();
            String sharingText = sharingList.getFirst().getTextContent();
            Sharing sharing = new Sharing(sharingText);
            
            mySharing.union(sharing);
            myAttributesType.put(name, dataType);
            myAttributesSharing.put(name, sharing);
            log.debug("\tattribute = " + name + " (" + dataType + ") with sharing = " + sharing.getText());
            break;
          case "objectClass":
            derivedClasses.add((Element)child);
            break;
          default:
            log.debug("skipping element " + child.getNodeName());
        }
      }
      child = child.getNextSibling();
    }
    
    if (myName == null) {
      throw new FileFormatException("object class defined without a name");
    }
    
    dataTypes.put(myName, myAttributesType);
    objectSharing.put(myName, mySharing);
    attributeSharing.put(myName, myAttributesSharing);
    for (Element derived : derivedClasses) {
      parseObject(derived, myName);
    }
  }
}
