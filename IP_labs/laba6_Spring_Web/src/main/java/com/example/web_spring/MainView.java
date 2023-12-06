package com.example.web_spring;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Route("main")
public class MainView extends VerticalLayout {

    private final CalculatorService calculatorService;
    private final SubstringFinderService substringFinderService;

    // Внедрение сервисов через конструктор
    @Autowired
    public MainView(CalculatorService calculatorService, SubstringFinderService substringFinderService) {
        this.calculatorService = calculatorService;
        this.substringFinderService = substringFinderService;

        // Создание компонентов
        TextField field1 = new TextField("Введите данные 1:");
        TextField field2 = new TextField("Введите данные 2:");

        Button calculateButton = new Button("Вычислить");
        Button findSubstringButton = new Button("Найти подстроку");

        TextField resultField = new TextField("Результат:");
        TextField substringField = new TextField("Наибольшая подстрока:");

        // Обработка событий кнопок
        calculateButton.addClickListener(event -> {
            String expression1 = field1.getValue();
            String expression2 = field2.getValue();
            try {
                double result = calculatorService.calculate(expression1, expression2);
                resultField.setValue(String.valueOf(result));
            } catch (Exception e) {
                Notification.show("Ошибка при вычислении арифметического выражения");
            }
        });

        findSubstringButton.addClickListener(event -> {
            String input1 = field1.getValue();
            String input2 = field2.getValue();
            String commonSubstring = substringFinderService.findCommonSubstring(input1, input2);
            substringField.setValue(commonSubstring);
        });

        // Добавление компонентов на UI
        add(field1, field2, calculateButton, resultField, findSubstringButton, substringField);
    }
}