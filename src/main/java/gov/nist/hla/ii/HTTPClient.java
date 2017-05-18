package gov.nist.hla.ii;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gov.nist.hla.ii.exception.HTTPClientException;
import gov.nist.hla.ii.exception.StatusCodeException;

public class HTTPClient {
  private static final Logger log = LogManager.getLogger();
  
  // IPv4 address and port number
  private String authority;
  
  private HttpClientBuilder builder;
  
  public HTTPClient(String authority) {
    this.authority = authority;
    this.builder = HttpClientBuilder.create();
  }
  
  public String get(String path)
      throws StatusCodeException,
             HTTPClientException {
    String uri = "http://" + authority + path;
    HttpGet request = new HttpGet(uri);
    HttpResponse response = sendRequest(request);
        
    HttpEntity entity = response.getEntity();
    if (entity == null) {
      throw new HTTPClientException("HTTP response contained no data");
    }
    
    try {
      return EntityUtils.toString(entity);
    } catch (IOException e) {
      throw new HTTPClientException("Unable to interpret HTTP response");
    }
  }
  
  public void post(String path, String content)
      throws StatusCodeException,
             HTTPClientException {
    String uri = "http://" + authority + path;
    HttpPost request = new HttpPost(uri);
    StringEntity entity = new StringEntity(content, ContentType.APPLICATION_JSON);
    request.setEntity(entity);
    sendRequest(request);
  }
  
  public void patch(String path, String content)
      throws StatusCodeException,
             HTTPClientException {
    String uri = "http://" + authority + path;
    HttpPatch request = new HttpPatch(uri);
    StringEntity entity = new StringEntity(content, ContentType.APPLICATION_JSON);
    request.setEntity(entity);
    sendRequest(request);
  }
  
  public void delete(String path)
      throws StatusCodeException,
             HTTPClientException {
    String uri = "http://" + authority + path;
    HttpDelete request = new HttpDelete(uri);
    sendRequest(request);
  }
  
  private HttpResponse sendRequest(HttpUriRequest request)
      throws StatusCodeException,
             HTTPClientException {
    log.debug(request.getMethod() + " request for URI=" + request.getURI());
    
    HttpClient client = builder.build();
    HttpResponse response;
    
    try {
      response = client.execute(request); // can this return null?
    } catch (IOException e) {
      throw new HTTPClientException(e);
    }
    StatusLine status = response.getStatusLine();
    
    if (status == null) {
      throw new StatusCodeException("HTTP response omitted status line");
    }
    
    int statusCode = status.getStatusCode();
    if (statusCode < 200 || statusCode >= 300) {
      throw new StatusCodeException(status.getReasonPhrase(), statusCode);
    }
    log.debug("received status code " + statusCode + ": " + status.getReasonPhrase());
    
    return response;
  }
}
