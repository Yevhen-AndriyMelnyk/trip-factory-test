package com.tripfactory.tripfactorytest.util;

import com.tripfactory.tripfactorytest.domain.AuthorizationTokenDetails;
import com.tripfactory.tripfactorytest.domain.FlightDetailsDTO;

public class XmlReplacerUtil {

    public static String replaceXmlAttributesForSeatMap(String xml, FlightDetailsDTO dto, AuthorizationTokenDetails tokenDetails) {

        //TODO i know that replacing string to pass parameters to xml is not best option, but there was no time to do in better way

        return xml.replace("${conversation-id}", tokenDetails.getConversationId())
                .replace("${binaryToken}", tokenDetails.getBinaryToken())
                .replace("${airline}", dto.getAirline())
                .replace("${flight}", dto.getFlight())
                .replace("${bookingClass}", dto.getBookingClass())
                .replace("${departureDate}", dto.getDepartureDate())
                .replace(">${origin}", dto.getOrigin());
    }

}
