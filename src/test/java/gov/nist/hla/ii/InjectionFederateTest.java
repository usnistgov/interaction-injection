package gov.nist.hla.ii;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.ecore.EObject;
import org.ieee.standards.ieee1516._2010.InteractionClassType;
import org.ieee.standards.ieee1516._2010.InteractionClassType1;
import org.ieee.standards.ieee1516._2010.InteractionsType;
import org.ieee.standards.ieee1516._2010.ObjectModelType;
import org.ieee.standards.ieee1516._2010._2010Factory;
import org.ieee.standards.ieee1516._2010._2010Package;
import org.ieee.standards.ieee1516._2010.util._2010ResourceFactoryImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import emf.sds.Deserialize;
import emf.sds.Serialize;
import gov.nist.hla.ii.exception.PropertyNotAssigned;
import gov.nist.hla.ii.exception.PropertyNotFound;
import gov.nist.hla.ii.exception.RTIAmbassadorException;

public class InjectionFederateTest {

	static InjectionFederate sut;
	static Properties props;
	static final String CONFIG_FILE = "config.properties";

	@BeforeClass
	public static void beforeClass() {
		try {
			sut = new InjectionFederate();
			props = new Properties();
			InputStream is = InjectionFederateTest.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
			props.load(is);
		} catch (RTIAmbassadorException | ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoadConfiguration() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			assertEquals(props.getProperty("fom-file"), sut.getFomFilePath());
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInterationCount() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			assertEquals(2, sut.getFom().getInteractions().getInteractionClass().getInteractionClass().size());
			for (InteractionClassType itr : sut.getFom().getInteractions().getInteractionClass().getInteractionClass()) {
				System.out.println(itr.getName().getValue());
			}
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetInteractionSubscribe() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			Set<String> set = sut.getInteractionSubscribe();
			assertEquals(13, set.size());
			for (String s : set) {
				System.out.println(s);
			}
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetInteractionPublish() {
		try {
			sut.loadConfiguration(CONFIG_FILE);
			Set<String> set = sut.getInteractionPublish();
			assertEquals(16, set.size());
			for (String s : set) {
				System.out.println(s);
			}
		} catch (IOException | PropertyNotFound | PropertyNotAssigned e) {
			e.printStackTrace();
		}
	}
	// @Test
	public void testDe() {
		Deserialize.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("_2010",
				new _2010ResourceFactoryImpl());
		Deserialize.getResourceSet().getPackageRegistry().put(_2010Package.eNS_URI, _2010Package.eINSTANCE);
		EObject eObject = Deserialize.it("fom/TripleFederation._2010");
	}

	// @Test
	public void testSe() {
		Serialize se = new Serialize();
		ObjectModelType objectModel = create();
		String s = Serialize.it(objectModel, "fom/TripleFederation1.xml");

	}

	private ObjectModelType create() {
		ObjectModelType objectModel = _2010Factory.eINSTANCE.createObjectModelType();
		InteractionsType intr = _2010Factory.eINSTANCE.createInteractionsType();
		InteractionClassType1 intrClassType1 = _2010Factory.eINSTANCE.createInteractionClassType1();
		intr.setInteractionClass(intrClassType1);
		InteractionClassType1 intr1ClassType = _2010Factory.eINSTANCE.createInteractionClassType1();
		intrClassType1.getInteractionClass().add(intr1ClassType);
		InteractionClassType1 intr2ClassType = _2010Factory.eINSTANCE.createInteractionClassType1();
		intrClassType1.getInteractionClass().add(intr2ClassType);
		InteractionClassType1 intr3ClassType = _2010Factory.eINSTANCE.createInteractionClassType1();
		intrClassType1.getInteractionClass().add(intr3ClassType);
		objectModel.setInteractions(intr);
		return objectModel;
	}
}
