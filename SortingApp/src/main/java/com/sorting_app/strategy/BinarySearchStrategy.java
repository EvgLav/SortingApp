package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.Record;
import com.sorting_app.input.SearchInputData;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BinarySearchStrategy implements IStrategy {
    private final DataObject dataObject;

    public BinarySearchStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    private void selectBinarySearch() throws ValidationException {
        SearchInputData searchInputData = new SearchInputData(dataObject);
        Record record = new Record(dataObject);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВведите цифру от 1 до 3 для поиска объектов\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД  ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    if (!dataObject.getCars().isEmpty()) {
                        List<Car> cars = searchInputData.findСar();
                        if (!cars.isEmpty()) {
                            System.out.println("\nЗаписать найденные данные в файл?\n" +
                                    "1 - ДА   " +
                                    "2 - НЕТ".toUpperCase());
                            int selectCount = scanner.nextInt();
                            if (selectCount == 1) {
                                record.recordCar(cars);
                            }
                        }
                    } else {
                        System.out.println("Коллекция машин пуста");
                    }
                    break;
                }
                case 2: {
                    if (!dataObject.getBooks().isEmpty()) {
                        List<Book> books = searchInputData.findBooks();
                        if (!books.isEmpty()) {
                            System.out.println("Записать найденные данные в файл?\n" +
                                    "1 - ДА   " +
                                    "2 - НЕТ".toUpperCase());
                            int selectCount = scanner.nextInt();
                            if (selectCount == 1) {
                                record.recordBook(books);
                            }
                        }
                    } else {
                        System.out.println("Коллекция книг пуста");
                    }
                    break;
                }
                case 3: {
                    if (!dataObject.getRootVegetables().isEmpty()) {
                        List<RootVegetable> rootVegetables = searchInputData.findRootVegetable();
                        if (!rootVegetables.isEmpty()) {
                            System.out.println("Записать найденные данные в файл?\n" +
                                    "1 - ДА    " +
                                    "2 - НЕТ".toUpperCase());
                            int selectCount = scanner.nextInt();
                            if (selectCount == 1) {
                                record.recordRootVegetable(rootVegetables);
                            }
                        }
                    } else {
                        System.out.println("Коллекция корнеплодов пуста");
                    }
                    break;
                }
                default:
                    break;
            }
        } catch (InputMismatchException e) {
            throw new ValidationException("Неверный ввод, введите цифру от 1 до 3");
        }
    }

    @Override
    public void generationResult() {
        try {
            selectBinarySearch();
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }

    }
}
