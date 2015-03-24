package xml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParseHandler extends DefaultHandler {
	
	ArrayList<Pais> paisos = new ArrayList<Pais>();
	ArrayList<Ciutat> ciutats = new ArrayList<Ciutat>();
	boolean esPais, esCiutat, esNomPais, esNomCiutat, esPoblacio;
	private Pais p = null;
	private Ciutat c = null;

	
	public SaxParseHandler(ArrayList<Pais> paisos) {
		this.paisos = paisos;
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if(qName.equalsIgnoreCase("pais")) {
			p = new Pais();
			ciutats = new ArrayList<Ciutat>();
			p.setCodiPais(attributes.getValue("codi"));

			esPais = true;
		} else if(qName.equalsIgnoreCase("nom") ) {
			if(esPais){
				esNomPais = true;
			} else {
				esNomCiutat = true;
			}
		} else if(qName.equalsIgnoreCase("ciutat")) { 
			c = new Ciutat();
			esPais = false;
			esNomPais = false;
			esCiutat = true;
		} else if(qName.equalsIgnoreCase("poblacio")){
			esPoblacio = true;
		} 
		
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		
		 if(esNomPais) {
			String s = new String(ch, start, length);
			p.setNom(s);
			esNomPais = false;
		} else if(esNomCiutat && !esPoblacio){
			String s = new String(ch, start, length);
			c.setNom(s);
			esNomCiutat = false;
		} else if (esPoblacio) {
			String s = new String(ch, start, length);
			c.setPoblacio(Integer.parseInt(s));
			esPoblacio = false;
		}
	
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if(qName.equalsIgnoreCase("pais")) {
			System.out.println(ciutats.size());
			p.setCiutats(ciutats);
			paisos.add(p);
		} else if(qName.equalsIgnoreCase("ciutat")) {
			ciutats.add(c);
		}
	}

}
