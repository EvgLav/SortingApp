package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.Record;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecordStrategy implements IStrategy {
    private final DataObject dataObject;

    public RecordStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public void selectedRecord() throws ValidationException {
        Record record = new Record(dataObject);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВведите цифру от 1 до 4 для записи объекта в файл\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД  " +
                    "4 - ЗАПИСЬ ВСЕХ ОБЪЕКТОВ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    if (!dataObject.getCars().isEmpty()) {
                        record.recordCar();
                    } else{
                        System.out.println("Коллекция машин пуста");
                    }
                        break;
                }
                case 2: {
                    if(!dataObject.getBooks().isEmpty()){
                        record.recordBook();
                    } else {
                        System.out.println("Коллекция книг пуста");
                    }

                    break;
                }
                case 3: {
                    if(!dataObject.getRootVegetables().isEmpty()){
                        record.recordRootVegetable();
                    } else {
                        System.out.println("Коллекция корнеплодов пуста");
                    }
                    break;
                }
                case 4: {
                    if(!dataObject.getBooks().isEmpty() &&
                            !dataObject.getCars().isEmpty() &&
                            !dataObject.getRootVegetables().isEmpty()){
                        record.recordCar();
                        record.recordBook();
                        record.recordRootVegetable();
                    } else {
                        System.out.println("Проверьте коллекции на наличие данных, возможно одна из коллекций пуста");
                    }
                    break;
                }
                default:
                    System.out.println("Неверный ввод, введите цифру от 1 до 4");
            }
        } catch (InputMismatchException e) {
            throw new ValidationException("Неверный ввод, введите цифру от 1 до 4");
        }
    }

    @Override
    public void generationResult() {
        try {
            selectedRecord();
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }
    }
}
