package com.tripfactory.tripfactorytest.service;

import com.tripfactory.tripfactorytest.domain.AuthorizationTokenDetails;
import com.tripfactory.tripfactorytest.domain.FlightDetailsDTO;
import com.tripfactory.tripfactorytest.util.XmlReplacerUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Service
public class SabreService {

    private final RestTemplateWrapperService restTemplateWrapperService;

    @Autowired
    public SabreService(RestTemplateWrapperService restTemplateWrapperService) {
        this.restTemplateWrapperService = restTemplateWrapperService;
    }

    public AuthorizationTokenDetails getToken() throws IOException, JAXBException {
        Resource resource = new ClassPathResource("get-token.xml");
        final String xml = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

        final String responseBody = restTemplateWrapperService.sendSoapRequest(xml, "https://sws-crt.cert.havail.sabre.com");
        return AuthorizationTokenDetails.buildTokenFromResponse(responseBody);
    }


    // TODO replace String with SeatMapDTO when status code is 200
    public String getSeatMap(FlightDetailsDTO dto) throws IOException, JAXBException {
        Resource resource = new ClassPathResource("get-seat-map.xml");
        String xml = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

        final String xmlWithAttributes = XmlReplacerUtil.replaceXmlAttributesForSeatMap(xml, dto, this.getToken());

        // now returns USG_INVALID_SECURITY_TOKEN because your organization is not allowed to hit this API
        return restTemplateWrapperService.sendSoapRequest(xmlWithAttributes, "https://sws-crt.cert.havail.sabre.com");
    }


}
