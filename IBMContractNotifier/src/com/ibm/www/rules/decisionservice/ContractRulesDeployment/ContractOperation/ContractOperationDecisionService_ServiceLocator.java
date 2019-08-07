/**
 * ContractOperationDecisionService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation;

public class ContractOperationDecisionService_ServiceLocator extends org.apache.axis.client.Service implements com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationDecisionService_Service {

    public ContractOperationDecisionService_ServiceLocator() {
    }


    public ContractOperationDecisionService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ContractOperationDecisionService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ContractRulesDeploymentContractOperationPort
    private java.lang.String ContractRulesDeploymentContractOperationPort_address ;

    public java.lang.String getContractRulesDeploymentContractOperationPortAddress() {
        return ContractRulesDeploymentContractOperationPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ContractRulesDeploymentContractOperationPortWSDDServiceName = "ContractRulesDeploymentContractOperationPort";

    public java.lang.String getContractRulesDeploymentContractOperationPortWSDDServiceName() {
        return ContractRulesDeploymentContractOperationPortWSDDServiceName;
    }

    public void setContractRulesDeploymentContractOperationPortWSDDServiceName(java.lang.String name) {
        ContractRulesDeploymentContractOperationPortWSDDServiceName = name;
    }

    public com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationDecisionService_PortType getContractRulesDeploymentContractOperationPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ContractRulesDeploymentContractOperationPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getContractRulesDeploymentContractOperationPort(endpoint);
    }

    public com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationDecisionService_PortType getContractRulesDeploymentContractOperationPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractRulesDeploymentContractOperationBindingStub _stub = new com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractRulesDeploymentContractOperationBindingStub(portAddress, this);
            _stub.setPortName(getContractRulesDeploymentContractOperationPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setContractRulesDeploymentContractOperationPortEndpointAddress(java.lang.String address) {
        ContractRulesDeploymentContractOperationPort_address = address + "/DecisionService/ws/ContractRulesDeployment/contractOperation/v75";
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationDecisionService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractRulesDeploymentContractOperationBindingStub _stub = new com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractRulesDeploymentContractOperationBindingStub(new java.net.URL(ContractRulesDeploymentContractOperationPort_address), this);
                _stub.setPortName(getContractRulesDeploymentContractOperationPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ContractRulesDeploymentContractOperationPort".equals(inputPortName)) {
            return getContractRulesDeploymentContractOperationPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.ibm.com/rules/decisionservice/ContractRulesDeployment/ContractOperation", "ContractOperationDecisionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.ibm.com/rules/decisionservice/ContractRulesDeployment/ContractOperation", "ContractRulesDeploymentContractOperationPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ContractRulesDeploymentContractOperationPort".equals(portName)) {
            setContractRulesDeploymentContractOperationPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
