package com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation;

public class ContractOperationDecisionServiceProxy implements com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationDecisionService_PortType {
  private String _endpoint = null;
  private com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationDecisionService_PortType contractOperationDecisionService_PortType = null;
  
  public ContractOperationDecisionServiceProxy() {
    _initContractOperationDecisionServiceProxy();
  }
  
  public ContractOperationDecisionServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initContractOperationDecisionServiceProxy();
  }
  
  private void _initContractOperationDecisionServiceProxy() {
    try {
      contractOperationDecisionService_PortType = (new com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationDecisionService_ServiceLocator()).getContractRulesDeploymentContractOperationPort();
      if (contractOperationDecisionService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)contractOperationDecisionService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)contractOperationDecisionService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (contractOperationDecisionService_PortType != null)
      ((javax.xml.rpc.Stub)contractOperationDecisionService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationDecisionService_PortType getContractOperationDecisionService_PortType() {
    if (contractOperationDecisionService_PortType == null)
      _initContractOperationDecisionServiceProxy();
    return contractOperationDecisionService_PortType;
  }
  
  public com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationResponse contractOperation(com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationRequest contractOperationRequest) throws java.rmi.RemoteException, com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.ContractOperationException{
    if (contractOperationDecisionService_PortType == null)
      _initContractOperationDecisionServiceProxy();
    return contractOperationDecisionService_PortType.contractOperation(contractOperationRequest);
  }
  
  
}