/**
 * Contract.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation;

public class Contract  implements java.io.Serializable {
    private java.lang.String accoundID;

    private double backLog;

    private java.lang.String country;

    private double currentPv;

    private int numberOfFeedbacks;

    private int numberOfNotifications;

    private java.lang.String projectDescription;

    private java.lang.String projectName;

    private double tcv;

    public Contract() {
    }

    public Contract(
           java.lang.String accoundID,
           double backLog,
           java.lang.String country,
           double currentPv,
           int numberOfFeedbacks,
           int numberOfNotifications,
           java.lang.String projectDescription,
           java.lang.String projectName,
           double tcv) {
           this.accoundID = accoundID;
           this.backLog = backLog;
           this.country = country;
           this.currentPv = currentPv;
           this.numberOfFeedbacks = numberOfFeedbacks;
           this.numberOfNotifications = numberOfNotifications;
           this.projectDescription = projectDescription;
           this.projectName = projectName;
           this.tcv = tcv;
    }


    /**
     * Gets the accoundID value for this Contract.
     * 
     * @return accoundID
     */
    public java.lang.String getAccoundID() {
        return accoundID;
    }


    /**
     * Sets the accoundID value for this Contract.
     * 
     * @param accoundID
     */
    public void setAccoundID(java.lang.String accoundID) {
        this.accoundID = accoundID;
    }


    /**
     * Gets the backLog value for this Contract.
     * 
     * @return backLog
     */
    public double getBackLog() {
        return backLog;
    }


    /**
     * Sets the backLog value for this Contract.
     * 
     * @param backLog
     */
    public void setBackLog(double backLog) {
        this.backLog = backLog;
    }


    /**
     * Gets the country value for this Contract.
     * 
     * @return country
     */
    public java.lang.String getCountry() {
        return country;
    }


    /**
     * Sets the country value for this Contract.
     * 
     * @param country
     */
    public void setCountry(java.lang.String country) {
        this.country = country;
    }


    /**
     * Gets the currentPv value for this Contract.
     * 
     * @return currentPv
     */
    public double getCurrentPv() {
        return currentPv;
    }


    /**
     * Sets the currentPv value for this Contract.
     * 
     * @param currentPv
     */
    public void setCurrentPv(double currentPv) {
        this.currentPv = currentPv;
    }


    /**
     * Gets the numberOfFeedbacks value for this Contract.
     * 
     * @return numberOfFeedbacks
     */
    public int getNumberOfFeedbacks() {
        return numberOfFeedbacks;
    }


    /**
     * Sets the numberOfFeedbacks value for this Contract.
     * 
     * @param numberOfFeedbacks
     */
    public void setNumberOfFeedbacks(int numberOfFeedbacks) {
        this.numberOfFeedbacks = numberOfFeedbacks;
    }


    /**
     * Gets the numberOfNotifications value for this Contract.
     * 
     * @return numberOfNotifications
     */
    public int getNumberOfNotifications() {
        return numberOfNotifications;
    }


    /**
     * Sets the numberOfNotifications value for this Contract.
     * 
     * @param numberOfNotifications
     */
    public void setNumberOfNotifications(int numberOfNotifications) {
        this.numberOfNotifications = numberOfNotifications;
    }


    /**
     * Gets the projectDescription value for this Contract.
     * 
     * @return projectDescription
     */
    public java.lang.String getProjectDescription() {
        return projectDescription;
    }


    /**
     * Sets the projectDescription value for this Contract.
     * 
     * @param projectDescription
     */
    public void setProjectDescription(java.lang.String projectDescription) {
        this.projectDescription = projectDescription;
    }


    /**
     * Gets the projectName value for this Contract.
     * 
     * @return projectName
     */
    public java.lang.String getProjectName() {
        return projectName;
    }


    /**
     * Sets the projectName value for this Contract.
     * 
     * @param projectName
     */
    public void setProjectName(java.lang.String projectName) {
        this.projectName = projectName;
    }


    /**
     * Gets the tcv value for this Contract.
     * 
     * @return tcv
     */
    public double getTcv() {
        return tcv;
    }


    /**
     * Sets the tcv value for this Contract.
     * 
     * @param tcv
     */
    public void setTcv(double tcv) {
        this.tcv = tcv;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Contract)) return false;
        Contract other = (Contract) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accoundID==null && other.getAccoundID()==null) || 
             (this.accoundID!=null &&
              this.accoundID.equals(other.getAccoundID()))) &&
            this.backLog == other.getBackLog() &&
            ((this.country==null && other.getCountry()==null) || 
             (this.country!=null &&
              this.country.equals(other.getCountry()))) &&
            this.currentPv == other.getCurrentPv() &&
            this.numberOfFeedbacks == other.getNumberOfFeedbacks() &&
            this.numberOfNotifications == other.getNumberOfNotifications() &&
            ((this.projectDescription==null && other.getProjectDescription()==null) || 
             (this.projectDescription!=null &&
              this.projectDescription.equals(other.getProjectDescription()))) &&
            ((this.projectName==null && other.getProjectName()==null) || 
             (this.projectName!=null &&
              this.projectName.equals(other.getProjectName()))) &&
            this.tcv == other.getTcv();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAccoundID() != null) {
            _hashCode += getAccoundID().hashCode();
        }
        _hashCode += new Double(getBackLog()).hashCode();
        if (getCountry() != null) {
            _hashCode += getCountry().hashCode();
        }
        _hashCode += new Double(getCurrentPv()).hashCode();
        _hashCode += getNumberOfFeedbacks();
        _hashCode += getNumberOfNotifications();
        if (getProjectDescription() != null) {
            _hashCode += getProjectDescription().hashCode();
        }
        if (getProjectName() != null) {
            _hashCode += getProjectName().hashCode();
        }
        _hashCode += new Double(getTcv()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Contract.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/rules/decisionservice/ContractRulesDeployment/ContractOperation", "contract"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accoundID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accoundID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("backLog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "backLog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("country");
        elemField.setXmlName(new javax.xml.namespace.QName("", "country"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentPv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currentPv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfFeedbacks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfFeedbacks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfNotifications");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfNotifications"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "projectDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "projectName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tcv");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tcv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
