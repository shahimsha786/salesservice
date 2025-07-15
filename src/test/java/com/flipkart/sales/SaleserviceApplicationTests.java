package com.flipkart.sales;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.flipkart.sales.controller.Salescontroller;

@WebMvcTest(Salescontroller.class)
public class SaleserviceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPostSale_withValidImei() throws Exception {
        String imei = "123456789012345";
        String expectedMessage = "posted sale for this device" + imei + "shahimsha successfully";

        mockMvc.perform(get("/flip/sale/{imei}", imei))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedMessage));
    }

    @Test
    public void testPostSale_withAlphanumericImei() throws Exception {
        String imei = "IMEI123ABC456";
        String expectedMessage = "posted sale for this device" + imei + "shahimsha successfully";

        mockMvc.perform(get("/flip/sale/{imei}", imei))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedMessage));
    }

    @Test
    public void testPostSale_withSpecialCharactersImei() throws Exception {
        String imei = "IMEI@#%";
        String expectedMessage = "posted sale for this device" + imei + "shahimsha successfully";

        mockMvc.perform(get("/flip/sale/{imei}", imei))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedMessage));
    }

    @Test
    public void testPostSale_withMissingImei_shouldReturn404() throws Exception {
        // This URL doesn't match the controller mapping
        mockMvc.perform(get("/flip/sale/"))
                .andExpect(status().isNotFound());
    }
}