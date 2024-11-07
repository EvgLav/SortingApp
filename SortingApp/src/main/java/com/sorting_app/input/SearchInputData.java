package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;
import com.sorting_app.utils.BinarySearch;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SearchInputData {
    private final DataObject dataObject;

    public SearchInputData(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public List<Car> findСar() throws ValidationException {
        List<Car> result = new ArrayList<>();
        try {
            System.out.println("\nПоиск машин в коллекции\n".toUpperCase());
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

            int count = BinarySearch.binarySearch(dataObject.getCars(), car);
            if (count >= 0) {
                result.add(dataObject.getCars().get(count));
                System.out.println("\nСовпадение найдено под индексом: ".toUpperCase() + count);
            } else {System.out.println("\nСовпадений нет".toUpperCase());}

            return result;

        } catch (InputMismatchException e) {
            throw new ValidationException("Неверный ввод! введите соответствующий тип данных");
        }
    }

    public List<Book> findBooks() throws ValidationException {
        List<Book> result = new ArrayList<>();
        try {
            System.out.println("\nПоиск книг в коллекции\n".toUpperCase());
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

            int count = BinarySearch.binarySearch(dataObject.getBooks(), book);
            if (count >= 0) {
                result.add(dataObject.getBooks().get(count));
                System.out.println("\nСовпадение найдено под индексом: ".toUpperCase() + count);
            } else {System.out.println("\nСовпадений нет".toUpperCase());}

            return result;

        } catch (InputMismatchException e){
            throw new ValidationException("Неверный ввод! введите соответствующий тип данных");
        }

    }

    public List<RootVegetable> findRootVegetable() throws ValidationException {
        List<RootVegetable> result = new ArrayList<>();
        try {
            System.out.println("\nПоиск корнеплодов в коллекции\n".toUpperCase());
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

                int count = BinarySearch.binarySearch(dataObject.getRootVegetables(), rootVegetable);
                if (count >= 0) {
                    result.add(dataObject.getRootVegetables().get(count));
                    System.out.println("\nСовпадение найдено под индексом: ".toUpperCase() + count);
                } else {System.out.println("\nСовпадений нет".toUpperCase());}

            return result;
        } catch (InputMismatchException e) {
            throw new ValidationException("Неверный ввод! введите соответствующий тип данных");
        }
    }
}