package test.sample.test;

import com.sun.security.jgss.GSSUtil;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class testjsonxml {
	public static void main(String ar[]) throws ParserConfigurationException, SAXException, IOException, ParseException, XPathExpressionException
	
	{
		String resourceName = "/sample.json";
    InputStream test = testjsonxml.class.getResourceAsStream(resourceName);
    if (test == null) {
        throw new NullPointerException("Cannot find resource file " + resourceName);
    }

    JSONTokener files = new JSONTokener(test);
    JSONObject object = new JSONObject(files);
    Iterator<String> keys = object.getJSONObject("fields").keys();
    
	
		 //get xml 
		 File xmlFile = new File("C:\\Users\\lakshmianusha.pinas\\Documents\\samplexml.xml");
		 
		 //Get DOM 
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document xml =db.parse(xmlFile);
	
		  //Get XPath 
		
		  XPathFactory xpf = XPathFactory.newInstance();
		  XPath xpath = xpf.newXPath();
		  
		  JSONObject values=(JSONObject) object.get("fields");
		 	for(Object key : values.keySet())
		 	{
		 		String keyStr=(String)key;
		 		//System.out.println("field name is "+ keyStr);
		 		JSONObject myxpaths= (JSONObject) object.getJSONObject("fields").get(keys.next());
		 	    JSONObject locator=  myxpaths.getJSONObject("locator");
		 	    String originalXpath=locator.get("value").toString();
	           // System.out.println(locator.get("value"));
	            Object name1 =  xpath.evaluate(originalXpath, xml, XPathConstants.BOOLEAN);
	            boolean validation=(Boolean)name1;
	            if(validation==false)
	            {
	            	System.out.println(keyStr +" " +originalXpath);
	            }
    }
    		  
    }

    }

