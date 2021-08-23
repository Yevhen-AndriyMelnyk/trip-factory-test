package com.tripfactory.tripfactorytest.domain;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class AuthorizationTokenDetails {

    private String conversationId;

    private String binaryToken;

    public AuthorizationTokenDetails(String conversationId, String binaryToken) {
        this.conversationId = conversationId;
        this.binaryToken = binaryToken;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getBinaryToken() {
        return binaryToken;
    }

    public void setBinaryToken(String binaryToken) {
        this.binaryToken = binaryToken;
    }


    public static AuthorizationTokenDetails buildTokenFromResponse(String response) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Envelope auth = (Envelope) jaxbUnmarshaller.unmarshal(new StringReader(response));
        return new AuthorizationTokenDetails(auth.getHeader().getMessageHeader().getConversationId(), auth.getHeader().getSecurity().getBinarySecurityToken());
    }
}
