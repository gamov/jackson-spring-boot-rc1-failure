package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class JsonConversionTest {

    JacksonTester<DtoObject> jacksonTester;

    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void Test() throws IOException {
        //language=JSON
        String json = "{\"name\": \"gam\"}";

        ObjectContent<DtoObject> objectContent = jacksonTester.read(new ByteArrayInputStream(json.getBytes()));

        assertThat(objectContent.getObject().getName()).isEqualTo("gam");
    }

    @Test
    public void writeTest() throws IOException {
        DtoObject gam = DtoObject.builder().name("gam").build();

        JsonContent<DtoObject> jsonContent = jacksonTester.write(gam);

        assertThat(jsonContent).extractingJsonPathValue("$.name").isEqualTo("gam");
    }
}
