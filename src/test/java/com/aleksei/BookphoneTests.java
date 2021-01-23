package com.aleksei;

import com.aleksei.entity.Phone;
import com.aleksei.repository.PhoneRepository;
import com.aleksei.repository.UserRepository;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class BookphoneTests extends AIntegrationTest {

    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testAnonymous() throws Exception {
        mockMvc.perform(get("/fakeEndpoint"))
                .andExpect(status().isNotFound());

    }

    @Test
    public void contextLoads() {
    }

    @Test
    void showPhoneById_notBooked() throws Exception {
        Phone phone = new Phone();
        phone.setId(1L);
        phone.setUser(null);
        phone.setBooktimestamp(null);

        phoneRepository.save(phone);

        mockMvc.perform(
                get(RESOURCE_URL +"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.user", is(IsNull.nullValue())))
                ;
    }

    @Test
    void showPhoneById_Booked() throws Exception {
        Phone phone = new Phone();
        phone.setId(1L);
        phone.setUser(null);
        phone.setBooktimestamp(null);

        phoneRepository.save(phone);


        mockMvc.perform(
                get(RESOURCE_URL +"/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.user", is(IsNull.nullValue())))
                ;

        mockMvc.perform(
                put(RESOURCE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"phoneid\":\"1\", \"userid\":\"1\"}"))
                .andExpect(status().isNoContent());

        mockMvc.perform(
                get(RESOURCE_URL +"/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.user.id", is(1)))
        ;
    }
}
