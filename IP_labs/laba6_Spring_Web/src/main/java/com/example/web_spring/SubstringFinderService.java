package com.example.web_spring;
import org.springframework.stereotype.Service;

@Service
public class SubstringFinderService {

    public String findCommonSubstring(String str1, String str2) {
        // Реализация логики поиска наибольшей общей подстроки
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        if (maxLength > 0) {
            return str1.substring(endIndex - maxLength + 1, endIndex + 1);
        } else {
            return "Нет общей подстроки";
        }
    }
}