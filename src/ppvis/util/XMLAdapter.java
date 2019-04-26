package ppvis.util;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLAdapter {
    public static void save(List<Player> info, File file){
        try
        {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("info");
            document.appendChild(rootElement);

            for (Player p : info) {

                Element player = document.createElement("Player");
                rootElement.appendChild(player);

                Attr attr = document.createAttribute("name");
                attr.setValue(p.getName());
                player.setAttributeNode(attr);

                attr = document.createAttribute("date");
                attr.setValue(p.getDateOfBirth());
                player.setAttributeNode(attr);

                attr = document.createAttribute("teamName");
                attr.setValue(p.getTeamName());
                player.setAttributeNode(attr);

                attr = document.createAttribute("city");
                attr.setValue(p.getCity());
                player.setAttributeNode(attr);

                attr = document.createAttribute("roleInTeam");
                attr.setValue(String.valueOf(p.getRoleInTeam()));
                player.setAttributeNode(attr);

                attr = document.createAttribute("position");
                attr.setValue(Integer.toString(p.getPosition()));
                player.setAttributeNode(attr);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);

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

    public static void open(Service logic, File file){

        final String fileName = file.getPath();

        try {
            SAXParserFactory factory;
            factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                List<Player> info;
                Player p;

                String name;
                Date date;
                String teamName;
                String city;
                Role roleInTeam;
                int position;

                @Override
                public void startDocument() throws SAXException {
                    info = new ArrayList<>();
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                    if (qName.equals("Player")){

                        try {
                            name = atts.getValue("name");
                            date = new SimpleDateFormat("yyyy-MM-dd").parse(atts.getValue("date"));
                            teamName = atts.getValue("teamName");
                            city = atts.getValue("city");
                            roleInTeam = atts.getValue("roleInTeam").equalsIgnoreCase("Main") ? Role.Main : Role.Reserve;
                            position = Integer.parseInt(atts.getValue("position"));
                            p = new Player(name, date, teamName, city, roleInTeam, position);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException{
                    info.add(p);
                }
                @Override
                public void endDocument(){
                    if (info.size() != 0){
                        logic.setInfo(info);
                        System.out.println("Файл загружен!");
                    }
                }
            };

            saxParser.parse(fileName, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}