package com.tripfactory.tripfactorytest.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Security {

    @XmlElement(name = "BinarySecurityToken", namespace = "http://schemas.xmlsoap.org/ws/2002/12/secext")
    String binarySecurityToken;

    public String getBinarySecurityToken() {
        return binarySecurityToken;
    }

    public void setBinarySecurityToken(String binarySecurityToken) {
        binarySecurityToken = binarySecurityToken;
    }
}
