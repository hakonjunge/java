package no.hiof.haakonju.filskrivingjson.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Character saeris = new Character("Saeris", 13);

        testJSON(saeris);

    }
    private static void testJSON(Character dndCharacter)   {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonString = objectMapper.writeValueAsString(dndCharacter);

            System.out.println(jsonString);



        }catch (JsonProcessingException e)  {
            e.printStackTrace();
        }
    }
}

