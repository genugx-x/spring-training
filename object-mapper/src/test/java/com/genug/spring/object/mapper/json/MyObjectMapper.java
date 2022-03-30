package com.genug.spring.object.mapper.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class MyObjectMapper {

    public void test() {
        JsonData ob = new JsonData("Beom", 33, "ENTP");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(ob);

            JsonData result = objectMapper.readValue(json, JsonData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
