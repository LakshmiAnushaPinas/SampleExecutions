package test.sample.test;

import com.sun.security.jgss.GSSUtil;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
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
		  DocumentBuilder db = dbf.newDocumentBuilder(); Document xml =db.parse(xmlFile);
	
		  //Get XPath 
		  XPathFactory xpf = XPathFactory.newInstance(); XPath xpath =
		  xpf.newXPath();
		 

    while(keys.hasNext()) {
        JSONObject values= (JSONObject) object.getJSONObject("fields").get(keys.next());
        JSONObject locator=  values.getJSONObject("locator");
        String originalXpath=locator.get("value").toString();
        System.out.println(locator.get("value"));
       String name = (String) xpath.evaluate(originalXpath, xml, XPathConstants.STRING);
			 
			   if(name.equals("")) {
			   System.out.println("xpath which don't have value in xml"+ originalXpath);
			   }//if
			  
    }

    }}


