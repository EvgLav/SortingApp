package com.sorting_app.data;

import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.util.ArrayList;
import java.util.List;

public class DataObject {

    private final List<Book> books;
    private final List<Car> cars;
    private final List<RootVegetable> rootVegetables;

    public DataObject() {
        this.books = new ArrayList<>();
        this.cars = new ArrayList<>();
        this.rootVegetables = new ArrayList<>();
    }

    public List<Book> getBooks() {return books;}

    public List<Car> getCars() {return cars;}

    public List<RootVegetable> getRootVegetables() {return rootVegetables;}

    public void addBook(Book book) {
        books.add(book);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addRootVegetable(RootVegetable rootVegetable) {
        rootVegetables.add(rootVegetable);
    }

    public void printCars() {
        if (getCars().isEmpty()) {
            System.out.println("Нет машин в списке");
        } else {
            for (Car car : getCars()) {
                System.out.println(car);
            }
        }
    }
    public void printBooks() {
        if (getBooks().isEmpty()) {
            System.out.println("Нет книг в списке");
        } else {
            for (Book book : getBooks()) {
                System.out.println(book);
            }
        }
    }
    public void printRootVegetable() {
        if (getRootVegetables().isEmpty()) {
            System.out.println("Нет корнеплода в списке");
        } else {
            for (RootVegetable rootVegetable : getRootVegetables()) {
                System.out.println(rootVegetable);
            }
        }
    }
}