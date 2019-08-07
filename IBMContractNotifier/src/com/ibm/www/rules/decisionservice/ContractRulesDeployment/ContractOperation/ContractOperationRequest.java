/**
 * ContractOperationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation;

public class ContractOperationRequest  implements java.io.Serializable {
    private java.lang.String decisionID;

    private com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.param.Contracts contracts;

    private com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.param.Notifications notifications;

    public ContractOperationRequest() {
    }

    public ContractOperationRequest(
           java.lang.String decisionID,
           com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.param.Contracts contracts,
           com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.param.Notifications notifications) {
           this.decisionID = decisionID;
           this.contracts = contracts;
           this.notifications = notifications;
    }


    /**
     * Gets the decisionID value for this ContractOperationRequest.
     * 
     * @return decisionID
     */
    public java.lang.String getDecisionID() {
        return decisionID;
    }


    /**
     * Sets the decisionID value for this ContractOperationRequest.
     * 
     * @param decisionID
     */
    public void setDecisionID(java.lang.String decisionID) {
        this.decisionID = decisionID;
    }


    /**
     * Gets the contracts value for this ContractOperationRequest.
     * 
     * @return contracts
     */
    public com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.param.Contracts getContracts() {
        return contracts;
    }


    /**
     * Sets the contracts value for this ContractOperationRequest.
     * 
     * @param contracts
     */
    public void setContracts(com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.param.Contracts contracts) {
        this.contracts = contracts;
    }


    /**
     * Gets the notifications value for this ContractOperationRequest.
     * 
     * @return notifications
     */
    public com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.param.Notifications getNotifications() {
        return notifications;
    }


    /**
     * Sets the notifications value for this ContractOperationRequest.
     * 
     * @param notifications
     */
    public void setNotifications(com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.param.Notifications notifications) {
        this.notifications = notifications;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContractOperationRequest)) return false;
        ContractOperationRequest other = (ContractOperationRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.decisionID==null && other.getDecisionID()==null) || 
             (this.decisionID!=null &&
              this.decisionID.equals(other.getDecisionID()))) &&
            ((this.contracts==null && other.getContracts()==null) || 
             (this.contracts!=null &&
              this.contracts.equals(other.getContracts()))) &&
            ((this.notifications==null && other.getNotifications()==null) || 
             (this.notifications!=null &&
              this.notifications.equals(other.getNotifications())));
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
        if (getDecisionID() != null) {
            _hashCode += getDecisionID().hashCode();
        }
        if (getContracts() != null) {
            _hashCode += getContracts().hashCode();
        }
        if (getNotifications() != null) {
            _hashCode += getNotifications().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContractOperationRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/rules/decisionservice/ContractRulesDeployment/ContractOperation", ">ContractOperationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("decisionID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/rules/decisionservice/ContractRulesDeployment/ContractOperation", "DecisionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contracts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/rules/decisionservice/ContractRulesDeployment/ContractOperation/param", "Contracts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/rules/decisionservice/ContractRulesDeployment/ContractOperation/param", ">Contracts"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notifications");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.ibm.com/rules/decisionservice/ContractRulesDeployment/ContractOperation/param", "Notifications"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.ibm.com/rules/decisionservice/ContractRulesDeployment/ContractOperation/param", ">Notifications"));
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
