package com.example.web_spring;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class CalculService {
    public String MakeS(String text) {

        Map<String, Integer> wordFrequencyMap = new TreeMap<>();

        if (text == null || text.isEmpty()) {
            return "Текст отсутствует";
        }

        String[] words = text.toLowerCase().split("[\\s,.!?:;-]+");
        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        StringBuilder result = new StringBuilder("Словарь частоты вхождения слов:\n");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        int numberOfElements = wordFrequencyMap.size();

        result.append("\n\n Capacity: ").append(numberOfElements);

        return result.toString();
    }
}
