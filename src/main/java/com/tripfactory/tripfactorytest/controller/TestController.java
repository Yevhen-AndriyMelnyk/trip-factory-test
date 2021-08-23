package com.tripfactory.tripfactorytest.controller;

import com.tripfactory.tripfactorytest.domain.AuthorizationTokenDetails;
import com.tripfactory.tripfactorytest.domain.FlightDetailsDTO;
import com.tripfactory.tripfactorytest.service.SabreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping("/api/trip-factory/v1/")
public class TestController {

    private final SabreService sabreService;

    @Autowired
    public TestController(SabreService sabreService) {
        this.sabreService = sabreService;
    }

    @GetMapping("/authorize")
    public AuthorizationTokenDetails authorize() throws IOException, JAXBException {
        return sabreService.getToken();
    }

    @GetMapping("/seat-map")
    public String getSeatMap(@RequestBody FlightDetailsDTO dto) throws IOException, JAXBException {
        return sabreService.getSeatMap(dto);
    }
}
