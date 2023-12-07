package com.example.web_spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Route("main")
public class MainView extends VerticalLayout {

    private final CalculService calculService;
    private final CalculateIntersection calculateIntersection;

    @Autowired
    public MainView(CalculService calculService, CalculateIntersection calculateIntersection) {
        this.calculService = calculService;
        this.calculateIntersection = calculateIntersection;

        // Создание компонентов
        TextArea textArea1 = new TextArea("Пушкин");
        TextArea textArea2 = new TextArea("Лермонтов");

        Button calculateButton1 = new Button("Пушкин");
        Button calculateButton2 = new Button("Лермонтов");

        TextArea textArea3 = new TextArea("Пушкин словарь");
        TextArea textArea4 = new TextArea("Лермонтов словарь");

        Button MergeButton = new Button("Пушкин + Лермонтов");

        TextArea textArea5 = new TextArea("Пушкин + Лермонтов");

        var layout = new HorizontalLayout();
        layout.add(textArea3, textArea4);

        add(textArea1, textArea2,  calculateButton1, calculateButton2, layout, MergeButton, textArea5);

        // Обработка событий кнопок
        calculateButton1.addClickListener(event -> {
            String expression1 = textArea1.getValue();
            try {
                String result = calculService.MakeS(expression1);
                textArea3.setValue(String.valueOf(result));
            } catch (Exception e) {
                e.printStackTrace();
                Notification.show("Ошибка при вычислении арифметического выражения: " + e.getMessage());
            }
        });

        calculateButton2.addClickListener(event -> {
            String expression2 = textArea2.getValue();
            try {
                String result = calculService.MakeS(expression2);
                textArea4.setValue(String.valueOf(result));
            } catch (Exception e) {
                e.printStackTrace();
                Notification.show("Ошибка при вычислении арифметического выражения: " + e.getMessage());
            }
        });

        MergeButton.addClickListener(event -> {
            String expression1 = textArea1.getValue();
            String expression2 = textArea2.getValue();
            try {
                String result = calculateIntersection.MakeI(expression1, expression2);
                textArea5.setValue(String.valueOf(result));
            } catch (Exception e) {
                e.printStackTrace();
                Notification.show("Ошибка при вычислении арифметического выражения: " + e.getMessage());
            }
        });
    }
}