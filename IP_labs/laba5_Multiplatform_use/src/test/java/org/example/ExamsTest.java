package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class ExamsTest {

    @Test
    void testToString() throws JsonProcessingException {
        Exams exams = new Exams("ПП", "Пазюра", 10);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(exams);
        System.out.println(json);
    }

    @Test
    void jsonStringToPojo() throws JsonProcessingException {
        String my_exams = "{\n" +
                " \"name_exam\" : \"PP\",\n" +
                " \"name_of_professor\" : \"P\",\n" +
                " \"grade\" : 10\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        Exams exams = mapper.readValue(my_exams, Exams.class);

        assertThat(exams.getName_exam()).isEqualTo("PP");
    }

    @Test
    void testToStringArrayExams() throws JsonProcessingException {
        Exams exams[] = new Exams[3];
        exams[0] = new Exams("ПП", "Пазюра", 10);
        exams[1] = new Exams("ДУ", "Радыно", 8);
        exams[2] = new Exams("АиСД", "Соболевская", 9);
        String[] ArrayString = new String[3];
        ArrayString[0] = JsonStringToPojo("ПП", "Пазюра", 10);
        ArrayString[1] = JsonStringToPojo("ДУ", "Радыно", 8);
        ArrayString[2] = JsonStringToPojo("АиСД", "Соболевская", 9);
        //Exams exams = new Exams("ПП", "Пазюра", 10);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(exams);
        System.out.println(json);
    }

    String JsonStringToPojo(String name_exam, String name_of_professor, Integer grade) {
        return "{\n" +
                " \"name_exam\" : \"" + name_exam + "\",\n" +
                " \"name_of_professor\" : \"" + name_of_professor + "\",\n" +
                " \"grade\" : " + grade + "\n" +
                "}";
    }
}