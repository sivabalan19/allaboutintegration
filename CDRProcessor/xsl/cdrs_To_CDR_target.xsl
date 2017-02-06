<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="WSDL">
      <schema location="../pollFile.wsdl"/>
      <rootElement name="cdrs" namespace="http://TargetNamespace.com/pollFile"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../writeFile.wsdl"/>
      <rootElement name="CDR" namespace="http://TargetNamespace.com/writeFile"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.7.0(build 140401.1420.0097) AT [SUN FEB 05 00:13:02 CET 2017]. -->
?>
<xsl:stylesheet version="1.0" xmlns:imp1="http://TargetNamespace.com/pollFile"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:tns="http://xmlns.oracle.com/pcbpel/adapter/ftp/Proj-Fusion/CDRProcessor/pollFile"
                xmlns:ns0="http://xmlns.oracle.com/pcbpel/adapter/ftp/Proj-Fusion/CDRProcessor/writeFile"
                xmlns:pc="http://xmlns.oracle.com/pcbpel/"
                xmlns:ns1="http://TargetNamespace.com/writeFile"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:plt="http://schemas.xmlsoap.org/ws/2003/05/partner-link/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:jca="http://xmlns.oracle.com/pcbpel/wsdl/jca/"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl imp1 tns pc plt wsdl jca xsd ns0 ns1 xp20 bpws bpel bpm ora socket mhdr oraext dvm hwf med ids xdk xref ldap">
  <xsl:template match="/">
    <ns1:CDR>
      <ns1:MSIDN>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:MSISDN"/>
      </ns1:MSIDN>
      <ns1:IMSI>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:IMSI"/>
      </ns1:IMSI>
      <ns1:IMEI>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:IMEI"/>
      </ns1:IMEI>
      <ns1:PLAN>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:planName"/>
      </ns1:PLAN>
      <ns1:CALL_TYPE>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:CDR_TYPE"/>
      </ns1:CALL_TYPE>
      <ns1:CORRESP_TYPE>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:receiverId"/>
      </ns1:CORRESP_TYPE>
      <ns1:CORRESP_ISDN>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:receiverMsisdn"/>
      </ns1:CORRESP_ISDN>
      <ns1:DURATION>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:duration"/>
      </ns1:DURATION>
      <ns1:TIME>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:time"/>
      </ns1:TIME>
      <ns1:DATE>
        <xsl:value-of select="/imp1:cdrs/imp1:cdr/imp1:date"/>
      </ns1:DATE>
    </ns1:CDR>
  </xsl:template>
</xsl:stylesheet>
