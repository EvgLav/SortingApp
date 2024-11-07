package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;

import java.util.Scanner;

public class PrintObjectStrategy implements IStrategy {

    DataObject dataObject;

    public PrintObjectStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    @Override
    public void generationResult() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите цифру от 1 до 4 для вывода объекта\n\n" +
                "1 - АВТОМОБИЛЬ;  " +
                "2 - КНИГИ;  " +
                "3 - КОРНЕПЛОД  " +
                "4 - ВЫВЕСТИ ВСЕ ОБЪЕКТЫ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                if (!dataObject.getCars().isEmpty()) {
                    dataObject.printCars();
                } else {
                    System.out.println("Коллекция пуста");
                }
                break;
            case 2:
                if (!dataObject.getBooks().isEmpty()) {
                    dataObject.printBooks();
                } else {
                    System.out.println("Коллекция пуста");
                }
                break;
            case 3:
                if (!dataObject.getRootVegetables().isEmpty()) {
                    dataObject.printRootVegetable();
                } else {
                    System.out.println("Коллекция пуста");
                }
                break;
            case 4: {
                dataObject.printCars();
                dataObject.printBooks();
                dataObject.printRootVegetable();
                break;
            }
            default:
                System.out.println("Неверный ввод, введите цифру от 1 до 4");
                break;
        }
    }
}