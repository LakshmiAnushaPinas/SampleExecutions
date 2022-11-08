package test.sample.test.src.main.java;


import com.sun.security.jgss.GSSUtil;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String ar[]) throws ParserConfigurationException, SAXException, IOException, ParseException, XPathExpressionException
    {
        String resourceName = "/sample.json";
        InputStream is = App.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener files = new JSONTokener(is);
        JSONObject object = new JSONObject(files);
        Iterator<String> keys = object.getJSONObject("fields").keys();

        while(keys.hasNext()) {
            JSONObject values= (JSONObject) object.getJSONObject("fields").get(keys.next());
            JSONObject locator=  values.getJSONObject("locator");
            System.out.println(locator.get("value"));

        }


    }
}
