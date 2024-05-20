package com.example.demo;

import com.example.demo.controllers.DeliveryPersonController;
import com.example.demo.model.DeliveryPerson;
import com.example.demo.service.DeliveryPersonService;
import com.example.demo.service.DonationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DeliveryPersonController.class)
public class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveryPersonService deliveryPersonService;

    @MockBean
    private DonationService donationService;

    @Test
    public void testLoginDeliveryPerson() throws Exception {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        deliveryPerson.setEmailId("test@example.com");
        deliveryPerson.setPassword("password");

        when(deliveryPersonService.findByEmailId("test@example.com")).thenReturn(deliveryPerson);

        mockMvc.perform(post("/api/deliveryperson/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"emailId\": \"test@example.com\", \"password\": \"password\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.emailId").value("test@example.com"));

        verify(deliveryPersonService, times(1)).findByEmailId("test@example.com");
    }

}

