package com.example.ecom.kyc.controller;

import org.junit.Test;
import static org.junit.Assert.*;

public class KycControllerTest {

    @Test
    public void testKycRequest() {
        KycController.KycRequest request = new KycController.KycRequest();
        request.setCustomerId(1L);
        assertEquals(Long.valueOf(1L), request.getCustomerId());
    }

    @Test
    public void testKycResponse() {
        KycController.KycResponse response = new KycController.KycResponse(1L, "ALLOW");
        assertEquals(Long.valueOf(1L), response.getCustomerId());
        assertEquals("ALLOW", response.getStatus());

        response.setStatus("DENY");
        assertEquals("DENY", response.getStatus());
    }
}
