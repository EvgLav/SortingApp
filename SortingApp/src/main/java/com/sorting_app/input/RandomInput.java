package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.sorting_app.utils.ConstUtil.*;

public class RandomInput {

    DataObject dataObject;
    public RandomInput(DataObject dataObject){this.dataObject = dataObject;}

    private final List<Book> loadBookList = new ArrayList<>();
    private final List<Car> loadCarList = new ArrayList<>();
    private final List<RootVegetable> loadRootVegetableList = new ArrayList<>();
    private String line;


    public void loadCarCSV() throws ValidationException {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_CAR))) {

           while (reader.readLine() != null){
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String model = values[0].trim();
                    int power = Integer.parseInt(values[1].trim());
                    int year = Integer.parseInt(values[2].trim());
                    loadCarList.add(new Car.CarBuilder().setModel(model)
                            .setPower(power)
                            .setYear(year)
                            .build());
                }
            }
        } catch (IOException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

    public void loadBooksCSV() throws ValidationException {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_BOOK))) {

            while (reader.readLine() != null){
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String name = values[0].trim();
                    String author = values[1].trim();
                    int pages = Integer.parseInt(values[2].trim());
                    loadBookList.add(new Book.BookBuilder()
                            .setBook(name)
                            .setAuthor(author)
                            .setPages(pages)
                            .build());
                }
            }
        } catch (IOException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

    public void loadRootVegetableCSV() throws ValidationException {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_ROOT_VEGETABLE))) {

           while (reader.readLine() != null){
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String type = values[0].trim();
                    int weight = Integer.parseInt(values[1].trim());
                    String color = values[2].trim();
                    loadRootVegetableList.add(new RootVegetable.RootVegetableBuilder()
                            .setType(type)
                            .setWeight(weight)
                            .setColor(color)
                            .build());
                }
            }
        } catch (IOException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

    public void generateCarList(int count) throws ValidationException {
        try {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomIndex = random.nextInt(loadCarList.size());
                Car randomeCar = loadCarList.get(randomIndex);
                dataObject.addCar(randomeCar);
            }
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Генерация автомобилей не возможна, проверьте файл на соответствие");
        }
    }

    public void generateBookList(int count) throws ValidationException {
        try {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomIndex = random.nextInt(loadBookList.size());
                Book randomeBook = loadBookList.get(randomIndex);
                dataObject.addBook(randomeBook);
            }
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Генерация Книг не возможна, проверьте файл на соответствие");
        }
    }

    public void generateRootVegetables(int count) throws ValidationException {
        try {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomIndex = random.nextInt(loadRootVegetableList.size());
                RootVegetable randomeRootVegetable = loadRootVegetableList.get(randomIndex);
                dataObject.addRootVegetable(randomeRootVegetable);
            }
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Генерация корнеплодов не возможна, проверьте файл на соответствие");
        }
    }

}