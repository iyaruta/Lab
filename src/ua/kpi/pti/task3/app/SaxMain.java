package ua.kpi.pti.task3.app;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.kpi.pti.task3.Flower;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class SaxMain {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        InputStream is = SaxMain.class.getResourceAsStream("../flowers.xsd.xml");
        FlowerHandler handler = new FlowerHandler();
        saxParser.parse(is, handler);

        Flower flower = handler.flower;
        System.out.println(flower.getName());

    }

    public static class FlowerHandler extends DefaultHandler {
        Flower flower;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("Flower")) {
                String name = attributes.getValue("name");
                flower = new Flower();
                flower.setName(name);
            }
        }
    }

}
