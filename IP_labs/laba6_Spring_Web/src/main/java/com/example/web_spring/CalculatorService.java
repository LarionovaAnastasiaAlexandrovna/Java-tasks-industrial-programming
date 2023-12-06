package com.example.web_spring;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(String str1, String str2) {
        // Реализация логики расчета арифметического выражения
        Double number1, number2;
        try {
            number1 = Double.parseDouble(str1);
            number2 = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка при преобразовании строки в число: " + e.getMessage());
            throw new RuntimeException("Ошибка при преобразовании строки в число", e);
        }

        // Ваш код обработки выражения и выполнения вычислений
        // Например, можно использовать библиотеку для вычисления выражений, такую как Apache Commons Math
        // Пример: double result = org.apache.commons.math3.expression.ExpressionUtils.evaluate(expression);
        // Здесь предполагается, что возвращается результат вычисления
        // В случае ошибки, можно выбросить исключение

        return number1 + number2;
    }
}