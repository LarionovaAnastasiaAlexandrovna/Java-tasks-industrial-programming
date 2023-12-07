package com.example.web_spring;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CalculateIntersection {
    public String MakeI(String str1, String str2) {

        String[] words1 = str1.split("[\\s,.!?:;-]+");
        String[] words2 = str2.split("[\\s,.!?:;-]+");

        Set<String> set1 = new HashSet<>(List.of(words1));
        Set<String> set2 = new HashSet<>(List.of(words2));

        set1.retainAll(set2);

        StringBuilder result = new StringBuilder("Слова в пересечении:\n");
        for (String word : set1) {
            result.append(word).append("\n");
        }



        if(set1.size() == 0)
        {
            result.append("нет пересечений");
        }
        return result.toString();
    }
}
