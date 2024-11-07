package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.utils.MergeSort;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSortStrategy implements  IStrategy{
private final DataObject dataObject;

    public MergeSortStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    private void selectMergeSort()throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВведите цифру от 1 до 4 для cортировки объектов\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД  " +
                    "4 - СОРТИРОВКА ВСЕХ ОБЪЕКТОВ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    if (!dataObject.getCars().isEmpty()) {
                        MergeSort.mergeSort(dataObject.getCars());
                    } else{
                        System.out.println("Коллекция машин пуста");
                    }
                    break;
                }
                case 2: {
                    if(!dataObject.getBooks().isEmpty()){
                        MergeSort.mergeSort(dataObject.getBooks());
                    } else {
                        System.out.println("Коллекция книг пуста");
                    }
                    break;
                }
                case 3: {
                    if(!dataObject.getRootVegetables().isEmpty()){
                        MergeSort.mergeSort(dataObject.getRootVegetables());
                    } else {
                        System.out.println("Коллекция корнеплодов пуста");
                    }
                    break;
                }
                case 4: {
                    if(!dataObject.getBooks().isEmpty() &&
                            !dataObject.getCars().isEmpty() &&
                            !dataObject.getRootVegetables().isEmpty()){
                        MergeSort.mergeSort(dataObject.getCars());
                        MergeSort.mergeSort(dataObject.getBooks());
                        MergeSort.mergeSort(dataObject.getRootVegetables());
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
            selectMergeSort();
        }catch (ValidationException validationException){
            System.out.println(validationException.getMessage());
        }
    }
}
