
package ua.kpi.pti.task3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Soil.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Soil">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PODZOLIC"/>
 *     &lt;enumeration value="DIRT"/>
 *     &lt;enumeration value="SOD_PODZOLIC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Soil", namespace = "http://www.pti.kpi.ua/task3/flowers")
@XmlEnum
public enum Soil {

    PODZOLIC,
    DIRT,
    SOD_PODZOLIC;

    public String value() {
        return name();
    }

    public static Soil fromValue(String v) {
        return valueOf(v);
    }

}
