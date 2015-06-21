
package ua.kpi.pti.task3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Flower complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Flower">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="soil" type="{http://www.pti.kpi.ua/task3/flowers}Soil"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="visualParameters" type="{http://www.pti.kpi.ua/task3/flowers}stringList"/>
 *         &lt;element name="growingTips" type="{http://www.pti.kpi.ua/task3/flowers}stringList"/>
 *         &lt;element name="multiplying" type="{http://www.pti.kpi.ua/task3/flowers}Multiplying"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flower", namespace = "http://www.pti.kpi.ua/task3/flowers", propOrder = {
    "soil",
    "origin",
    "visualParameters",
    "growingTips",
    "multiplying"
})
public class Flower {

    @XmlElement(namespace = "http://www.pti.kpi.ua/task3/flowers", required = true)
    protected Soil soil;
    @XmlElement(namespace = "http://www.pti.kpi.ua/task3/flowers", required = true)
    protected String origin;
    @XmlList
    @XmlElement(namespace = "http://www.pti.kpi.ua/task3/flowers", required = true)
    protected List<String> visualParameters;
    @XmlList
    @XmlElement(namespace = "http://www.pti.kpi.ua/task3/flowers", required = true)
    protected List<String> growingTips;
    @XmlElement(namespace = "http://www.pti.kpi.ua/task3/flowers", required = true)
    protected Multiplying multiplying;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the soil property.
     * 
     * @return
     *     possible object is
     *     {@link Soil }
     *     
     */
    public Soil getSoil() {
        return soil;
    }

    /**
     * Sets the value of the soil property.
     * 
     * @param value
     *     allowed object is
     *     {@link Soil }
     *     
     */
    public void setSoil(Soil value) {
        this.soil = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the visualParameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the visualParameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVisualParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVisualParameters() {
        if (visualParameters == null) {
            visualParameters = new ArrayList<String>();
        }
        return this.visualParameters;
    }

    /**
     * Gets the value of the growingTips property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the growingTips property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrowingTips().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGrowingTips() {
        if (growingTips == null) {
            growingTips = new ArrayList<String>();
        }
        return this.growingTips;
    }

    /**
     * Gets the value of the multiplying property.
     * 
     * @return
     *     possible object is
     *     {@link Multiplying }
     *     
     */
    public Multiplying getMultiplying() {
        return multiplying;
    }

    /**
     * Sets the value of the multiplying property.
     * 
     * @param value
     *     allowed object is
     *     {@link Multiplying }
     *     
     */
    public void setMultiplying(Multiplying value) {
        this.multiplying = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
