
package ua.kpi.pti.task3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Multiplying.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Multiplying">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LEAVES"/>
 *     &lt;enumeration value="CUTTING"/>
 *     &lt;enumeration value="SEEDS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Multiplying", namespace = "http://www.pti.kpi.ua/task3/flowers")
@XmlEnum
public enum Multiplying {

    LEAVES,
    CUTTING,
    SEEDS;

    public String value() {
        return name();
    }

    public static Multiplying fromValue(String v) {
        return valueOf(v);
    }

}
