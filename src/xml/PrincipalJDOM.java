package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class PrincipalJDOM {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static void main(String[] args) throws JDOMException, IOException {
//		Exercici 1
//		Crea un programa PrincipalJDOM que llegeixi un fitxer xml “mon.xml”
//		amb un contingut com el que apareix al final d'aquest document i obtingui 
//		en forma de List d'objectes Pais els països amb les seves ciutats que allí
//		hi apareixen. Un cop recuperats tots els països els ha d'imprimir per consola. 
//		Has d'utilitzar JDOM.
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new File("mon.xml"));
		Element root = doc.getRootElement();
		List<Element> llistaPaisos = root.getChildren();
		List<Pais> paisos = new ArrayList<Pais>();		
		
		for(Element e : llistaPaisos) {
			List<Ciutat> ciutatsArray = new ArrayList<Ciutat>();
			List<Element> ciutats = e.getChildren("ciutat");
			for(Element c : ciutats){
				String nom = c.getChild("nom").getText();
				int poblacio = Integer.parseInt(c.getChildText("poblacio"));
				Ciutat ciu = new Ciutat(nom,poblacio);
				ciutatsArray.add(ciu);
			}
			String nom = e.getChildText("nom").toString();
			String codi = e.getAttributeValue("codi").toString();
			Pais p = new Pais(nom, codi, ciutatsArray);
			paisos.add(p);
			
			
			
		}
		for (Pais pais : paisos) {
			System.out.println(pais);
		}
		
		
				
		
	}
}
