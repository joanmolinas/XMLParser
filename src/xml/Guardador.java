package xml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Guardador {

		
	public static void main(String[] args) {
		
		ArrayList<Ciutat> ciutats = new ArrayList<Ciutat>();
		ArrayList<Pais> paisos = new ArrayList<Pais>();
		
		Ciutat c = new Ciutat("París", 210000);
		ciutats.add(c);
		
		c = new Ciutat("Estrasburg", 270000);
		ciutats.add(c);
		
		Pais p = new Pais("França", "FRA", ciutats);
		paisos.add(p);
		
		
		ciutats = new ArrayList<Ciutat>();
		
		c = new Ciutat("Brisbane", 220000);
		ciutats.add(c);
		c = new Ciutat("Sidney", 120000);
		ciutats.add(c);
		c = new Ciutat("Adelaide", 460000);
		ciutats.add(c);

		p = new Pais("Australia", "AUS",ciutats );
		p.setNom("Australia");
		p.setCodiPais("AUS");
		
		ciutats = new ArrayList<Ciutat>();
		paisos.add(p);
		
		guarda(paisos, "mon2.xml");
		
		
		
		

	} 
	public static void guarda (ArrayList<Pais> paisos, String nomFitxer){
		Element mon = new Element("mon");
		Document doc = new Document(mon);
		
		for(Pais p : paisos) {
			Element pais = new Element("pais");
			pais.setAttribute(new Attribute("codi", p.getCodiPais().toString()));
			pais.addContent(new Element("nom").setText(p.getNom()));
			for (Ciutat c : p.getCiutats()) {
				pais.addContent(addCity(c.getNom(), String.valueOf(c.getPoblacio())));
			}
			doc.getRootElement().addContent(pais);
		}
		XMLOutputter out = new XMLOutputter();
		out.setFormat(Format.getPrettyFormat());
		try {
			out.output(doc, new FileWriter(nomFitxer));
		} catch (IOException e) {
			e.printStackTrace();
		}
					
	}
	public static Element addCity(String nom, String poblacio){
		Element ciutat = new Element("ciutat");
		ciutat.addContent(new Element("nom").setText(nom));
		ciutat.addContent(new Element("poblacio").setText(poblacio));
		return ciutat;
	}

}
