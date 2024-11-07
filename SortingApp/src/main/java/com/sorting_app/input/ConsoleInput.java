package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
    private final DataObject dataObject;

    public ConsoleInput(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public DataObject getDataObject() {
        return dataObject;
    }

    public void inputCar() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введи модель");
            String model = scanner.nextLine();
            System.out.println("Введи мощность");
            int power = scanner.nextInt();
            System.out.println("Введи год выпуска");
            int year = scanner.nextInt();
            if (model.isEmpty()) {
                model = null;
            }
            Car car = new Car.CarBuilder().setModel(model)
                    .setPower(power)
                    .setYear(year)
                    .build();
            dataObject.addCar(car);
        } catch (InputMismatchException exception) {
            throw new ValidationException("Введен неверный тип данных");
        }

    }

    public void inputBook() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введи название книги");
            String name = scanner.nextLine();
            System.out.println("Введи автора");
            String author = scanner.nextLine();
            System.out.println("Введи кол-во страниц");
            int pages = scanner.nextInt();
            if (name.isEmpty()) {
                name = null;
            }
            if (author.isEmpty()) {
                author = null;
            }
            Book book = new Book.BookBuilder().setBook(name)
                    .setAuthor(author)
                    .setPages(pages)
                    .build();
            dataObject.addBook(book);
        } catch (InputMismatchException exception) {
            throw new ValidationException("Введен неверный тип данных");
        }
    }

    public void inputRootVegetable() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введи тип");
            String type = scanner.nextLine();
            System.out.println("Введи вес");
            int weight = Integer.parseInt(scanner.nextLine());
            System.out.println("Введи цвет");
            String color = scanner.nextLine();
            if (type.isEmpty()) {
                type = null;
            }
            if (color.isEmpty()) {
                color = null;
            }
            RootVegetable rootVegetable =
                    new RootVegetable.RootVegetableBuilder().setType(type)
                            .setWeight(weight)
                            .setColor(color)
                            .build();
            dataObject.addRootVegetable(rootVegetable);
        } catch (InputMismatchException | NumberFormatException exception) {
            throw new ValidationException("Введен неверный тип данных");
        }
    }
}