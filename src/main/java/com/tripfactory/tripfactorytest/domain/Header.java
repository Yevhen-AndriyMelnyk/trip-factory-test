package com.tripfactory.tripfactorytest.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Header {

    @XmlElement(name = "MessageHeader", namespace = "http://www.ebxml.org/namespaces/messageHeader")
    protected MessageHeader messageHeader;

    @XmlElement(name = "Security", namespace = "http://schemas.xmlsoap.org/ws/2002/12/secext")
    protected Security security;

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }
}
