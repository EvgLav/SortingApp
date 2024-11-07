package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.ConsoleInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputConsoleStrategy implements IStrategy {

    DataObject dataObject;

    public InputConsoleStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }


    @Override
    public void generationResult() {
        ConsoleInput consoleInput = new ConsoleInput(dataObject);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВведите цифру от 1 до 3 для ввода данных\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД");
            int choose = scanner.nextInt();
            System.out.println("Введите количество создаваемых объектов");
            int count = scanner.nextInt();
            for (int i = 1; i < count + 1; i++) {
                System.out.println("Создаваемый объект №" + i);
                switch (choose) {
                    case 1:
                        consoleInput.inputCar();
                        break;
                    case 2:
                        consoleInput.inputBook();
                        break;
                    case 3:
                        consoleInput.inputRootVegetable();
                        break;
                    default:
                        System.out.println("Неверный ввод, введите цифру от 1 до 3");
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Неверный тип данных, введите цифры");
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());

        }
    }
}