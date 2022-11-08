package test.sample.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class testjsonxml {
	public static void main(String ar[]) throws ParserConfigurationException, SAXException, IOException, ParseException, XPathExpressionException
	{
		JSONParser parser = new JSONParser();
		FileReader fileReader = new FileReader("C:\\\\Users\\\\lakshmianusha.pinas\\\\Documents\\\\sample.json");
		JSONObject json = (JSONObject) parser.parse(fileReader);
		JSONObject fields = (JSONObject) json.get("fields");
		Iterator i = fields.iterator();

		

		


    }}


