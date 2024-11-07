package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByEven {

    private final DataObject dataObject;

    public SortByEven(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    private final Comparator<Car> carComparator = Comparator.comparingInt(Car::getPower);
    private final Comparator<Book> bookComparator = Comparator.comparingInt(Book::getPages);
    private final Comparator<RootVegetable> rootVegetableComparator = Comparator.comparing(RootVegetable::getWeight);

    public void carSortByEven() throws ValidationException {
        List<Car> listEven = new ArrayList<>();
        try {
            for (Car car : dataObject.getCars()) {
                if (car.getPower() % 2 == 0) {
                    listEven.add(car);
                }
            }
            listEven.sort(carComparator);
            int count = 0;
            for (int i = 0; i < dataObject.getCars().size(); i++) {
                if (dataObject.getCars().get(i).getPower() % 2 != 0) {
                    continue;
                }
                dataObject.getCars().set(i, listEven.get(count++));
            }
            if (dataObject.getCars().isEmpty()) {
                System.out.println("Нет данных для сортировки");
            } else {
                System.out.println("Сортировка машин по четным значения : " + dataObject.getCars());
            }
        } catch (Exception e) {
            throw new ValidationException("Что то пошло не так, проверьте на соответствие коллекции".toUpperCase());
        }
    }

    public void bookSortByEven() throws ValidationException {
        List<Book> listEven = new ArrayList<>();
        try {
            for (Book book : dataObject.getBooks()) {
                if (book.getPages() % 2 == 0) {
                    listEven.add(book);
                }
            }
            listEven.sort(bookComparator);
            int count = 0;
            for (int i = 0; i < dataObject.getBooks().size(); i++) {
                if (dataObject.getBooks().get(i).getPages() % 2 != 0) {
                    continue;
                }
                dataObject.getBooks().set(i, listEven.get(count++));
            }
            if (dataObject.getBooks().isEmpty()) {
                System.out.println("Нет данных для сортировки");
            } else {
                System.out.println("Сортировка машин по четным значения : " + dataObject.getBooks());
            }
        } catch (Exception e) {
            throw new ValidationException("Что то пошло не так, проверьте на соответствие коллекции".toUpperCase());
        }
    }

    public void rootVegetableSortByEven() throws ValidationException {
        List<RootVegetable> listEven = new ArrayList<>();
        try {
            for (RootVegetable rv : dataObject.getRootVegetables()) {
                if (rv.getWeight() % 2 == 0) {
                    listEven.add(rv);
                }
            }
            listEven.sort(rootVegetableComparator);
            int count = 0;
            for (int i = 0; i < dataObject.getRootVegetables().size(); i++) {
                if (dataObject.getRootVegetables().get(i).getWeight() % 2 != 0) {
                    continue;
                }
                dataObject.getRootVegetables().set(i, listEven.get(count++));
            }
            if (dataObject.getRootVegetables().isEmpty()) {
                System.out.println("Нет данных для сортировки");
            } else {
                System.out.println("Сортировка корнеплода по четным значения : " + dataObject.getRootVegetables());
            }
        } catch (Exception e) {
            throw new ValidationException("Что то пошло не так, проверьте на соответствие коллекции".toUpperCase());
        }
    }

}