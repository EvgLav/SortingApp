package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.ReadFileInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputFileStrategy implements IStrategy {
    DataObject dataObject;

    public InputFileStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }


    @Override
    public void generationResult() {
        ReadFileInput readFileInput = new ReadFileInput(dataObject);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВведите цифру от 1 до 4 для записи данных из файла\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД  " +
                    "4 - ЗАПИСЬ ВО ВСЕ ОБЪЕКТЫ");
            int choose = scanner.nextInt();
            System.out.println("Введите количество создаваемых объектов");
            int count = scanner.nextInt();
            switch (choose) {
                case 1: {
                    readFileInput.loadCarCSV(count);
                    break;
                }
                case 2: {
                    readFileInput.loadBooksCSV(count);
                    break;
                }
                case 3: {
                    readFileInput.loadRootVegetableCSV(count);
                    break;
                }
                case 4: {
                    readFileInput.loadCarCSV(count);
                    readFileInput.loadBooksCSV(count);
                    readFileInput.loadRootVegetableCSV(count);
                    break;
                }
                default:
                    System.out.println("Неверный ввод, введите цифру от 1 до 4");
            }
        } catch (InputMismatchException exception) {
            System.out.println("Неверный тип данных, введите цифры");
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }
    }
}
