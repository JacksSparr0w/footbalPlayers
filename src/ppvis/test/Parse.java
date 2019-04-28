package ppvis.test;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ppvis.util.model.Role;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.Random;

public class Parse {
    public static void main(String[] args) {
        Random random = new Random();

        String[] names = new String[]{"Killian Mballe", "Harry kein", "Neimar", "Rahim Sterling", "Mohammed Ali",
        "Romely Rokaky Aby", "Paulo Dibala", "Philippe  Cuoto", "Pol Pogba"};
        String[] teamNames = new String[]{"Barselona", "Liverpool", "Mnachester", "Juventus",
        "Bayern", "Atletico", "Paris Saint-Germain", "Tottenham", "Real Madrid", "FC"};
        String[] citis = new String[]{"Paris", "Barselona", "London", "Moscow", "Minsk", "Berlin",
        "Amsterdam"};


        try
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("info");
            document.appendChild(rootElement);

            for (int i = 0; i < 50; i++) {

                Element player = document.createElement("Player");
                rootElement.appendChild(player);

                Attr attr = document.createAttribute("name");
                attr.setValue(names[random.nextInt(names.length)]);
                player.setAttributeNode(attr);

                attr = document.createAttribute("date");
                String s = Integer.toString(random.nextInt(2010)) + "-" +Integer.toString(random.nextInt(12)) + "-" +
                        Integer.toString(random.nextInt(28));
                attr.setValue(s);
                player.setAttributeNode(attr);

                attr = document.createAttribute("teamName");
                attr.setValue(teamNames[random.nextInt(teamNames.length)]);
                player.setAttributeNode(attr);

                attr = document.createAttribute("city");
                attr.setValue(citis[random.nextInt(citis.length)]);
                player.setAttributeNode(attr);

                attr = document.createAttribute("roleInTeam");
                int r = random.nextInt(30);
                attr.setValue(String.valueOf(r % 2 == 0 ? Role.Main : Role.Reserve));
                player.setAttributeNode(attr);

                attr = document.createAttribute("position");
                attr.setValue(Integer.toString(random.nextInt(45)));
                player.setAttributeNode(attr);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult("out.xml");

            transformer.transform(domSource, streamResult);
            System.out.println("Файл сохранен!");
        }
        catch (ParserConfigurationException pce)
        {
            System.out.println(pce.getLocalizedMessage());
            pce.printStackTrace();
        }
        catch (TransformerException te)
        {
            System.out.println(te.getLocalizedMessage());
            te.printStackTrace();
        }
    }
}
