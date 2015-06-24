package ua.kpi.pti.task3.app;

import ua.kpi.pti.task3.Flower;
import ua.kpi.pti.task3.Multiplying;
import ua.kpi.pti.task3.Soil;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.Arrays;

public class StaxMain {

    public static void main(String[] args) throws XMLStreamException {
        Flower flower = null;
        String tagContent = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(
                StaxMain.class.getResourceAsStream("../flowers.xsd.xml"));
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("flower".equals(reader.getLocalName())) {
                        flower = new Flower();
                        flower.setName(reader.getAttributeValue(0));
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "soil":
                            flower.setSoil(Soil.fromValue(tagContent));
                            break;
                        case "multiplying":
                            flower.setMultiplying(Multiplying.fromValue(tagContent));
                            break;
                        case "origin":
                            flower.setOrigin(tagContent);
                            break;
                        case "visualParameters":
                            flower.getVisualParameters().addAll(Arrays.asList(tagContent.split(",")));
                            break;
                        case "growingTips":
                            flower.getGrowingTips().addAll(Arrays.asList(tagContent.split(",")));
                            break;
                    }
            }
        }

        System.out.println(flower.getName());
        System.out.println(flower.getMultiplying());
        System.out.println(flower.getOrigin());
        System.out.println(flower.getSoil());
        System.out.println(flower.getVisualParameters().get(0));
        System.out.println(flower.getVisualParameters().get(1));
        System.out.println(flower.getGrowingTips().get(0));
        System.out.println(flower.getGrowingTips().get(1));
    }

}
