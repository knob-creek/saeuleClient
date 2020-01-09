package de.mtag.tankstelle.saeuleClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SäuleTest {

    @Autowired
    MockMvc mockMvc;

    JacksonTester<TankVorgang> tankVorgangJacksonTester;
    JacksonTester<Säule> saeuleJacksonTester;

    @BeforeEach
    void init() {
        JacksonTester.initFields(this, new ObjectMapper());
    }


    @Test
    void bezahlungAbgeschlossenTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tankVorgangJacksonTester.write(new TankVorgang(UUID.randomUUID())).getJson())
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

    }
}
