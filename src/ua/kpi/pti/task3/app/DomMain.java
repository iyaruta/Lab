package ua.kpi.pti.task3.app;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomMain {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(DomMain.class.getResourceAsStream("../flowers.xsd.xml"));
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("flower");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Flower name: " + eElement.getAttribute("name"));
                    System.out.println("Soil: " + eElement.getElementsByTagName("soil").item(0).getTextContent());
                    System.out.println("Origin: " + eElement.getElementsByTagName("origin").item(0).getTextContent());
                    System.out.println("Multiplying: " + eElement.getElementsByTagName("multiplying").item(0).getTextContent());
                    System.out.println("VisualParameters: " + eElement.getElementsByTagName("visualParameters").item(0).getTextContent());
                    System.out.println("GrowingTips: " + eElement.getElementsByTagName("growingTips").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
