package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.sorting_app.utils.ConstUtil.*;

public class ReadFileInput {
    private final DataObject dataObject;

    public ReadFileInput(DataObject dataObject){this.dataObject = dataObject;}


    public void loadBooksCSV(int count) throws ValidationException {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_BOOK))) {
            String line;
            for(int i = 0; i < count; i++){
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String name = values[0].trim();
                    String author = values[1].trim();
                    int pages = Integer.parseInt(values[2].trim());
                    dataObject.addBook(new Book.BookBuilder()
                            .setBook(name)
                            .setAuthor(author)
                            .setPages(pages)
                            .build());
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

    public void loadCarCSV(int count) throws ValidationException {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_CAR))) {
            String line;
            for(int i = 0; i < count; i++){
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String model = values[0].trim();
                    int power = Integer.parseInt(values[1].trim());
                    int year = Integer.parseInt(values[2].trim());
                    dataObject.addCar(new Car.CarBuilder().setModel(model)
                            .setPower(power)
                            .setYear(year)
                            .build());
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

    public void loadRootVegetableCSV(int count) throws ValidationException {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_ROOT_VEGETABLE))) {
            for(int i = 0; i < count; i++){
                String line;
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String type = values[0].trim();
                    int weight = Integer.parseInt(values[1].trim());
                    String color = values[2].trim();
                    dataObject.addRootVegetable(new RootVegetable.RootVegetableBuilder()
                            .setType(type)
                            .setWeight(weight)
                            .setColor(color)
                            .build());
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

}