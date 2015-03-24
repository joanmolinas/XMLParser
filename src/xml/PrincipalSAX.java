package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class PrincipalSAX {

	SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		 
		ArrayList<Pais> paisos = new ArrayList<Pais>();
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		SaxParseHandler handler = new SaxParseHandler(paisos);
		
		saxParser.parse(new File("mon.xml"), handler);
		for(Pais e : paisos) {
			for (Ciutat c : e.getCiutats()) {
				System.out.println(c.getNom());
			}
		}
		 
		
		 

		   
	}

}
