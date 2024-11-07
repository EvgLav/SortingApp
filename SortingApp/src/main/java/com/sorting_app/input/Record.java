package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static com.sorting_app.utils.ConstUtil.*;


public class Record {
    private final DataObject dataObject;

    public Record(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public void recordCar() throws ValidationException {
        try {
            Files.writeString(
                    Paths.get(RECORD_FILE_PATH),
                    TEXT_FILE_RECORD_ADD_CAR,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            for (Car car : dataObject.getCars()) {
                String line = "Модель: " + car.getModel() + ", Мощность: " + car.getPower() + ", Год выпуска: " + car.getYear() + "\n";
                Files.writeString(Paths.get(RECORD_FILE_PATH), line, StandardOpenOption.APPEND);
            }

            System.out.println("Машины записаны в файл " + RECORD_FILE_PATH);

        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordCar(List<Car> cars) throws ValidationException {
        try {
            Files.writeString(
                    Paths.get(RECORD_FILE_PATH),
                    TEXT_FILE_RECORD_ADD_CAR,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            for (Car car : cars) {
                String line = "Модель: " + car.getModel() + ", Мощность: " + car.getPower() + ", Год выпуска: " + car.getYear() + "\n";
                Files.writeString(Paths.get(RECORD_FILE_PATH), line, StandardOpenOption.APPEND);
            }

            System.out.println("Машины записаны в файл " + RECORD_FILE_PATH);

        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordBook() throws ValidationException {
        try {
            Files.writeString(
                    Paths.get(RECORD_FILE_PATH),
                    TEXT_FILE_RECORD_ADD_BOOK,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            for (Book book : dataObject.getBooks()) {
                String line = "Название: " + book.getBookName() + ", Автор: " + book.getAuthor() + ", Кол-во страниц: " + book.getPages() + "\n";
                Files.writeString(Paths.get(RECORD_FILE_PATH), line, StandardOpenOption.APPEND);
            }

            System.out.println("Книги записаны в файл " + RECORD_FILE_PATH);

        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordBook(List<Book> books) throws ValidationException {
        try {
            Files.writeString(
                    Paths.get(RECORD_FILE_PATH),
                    TEXT_FILE_RECORD_ADD_BOOK,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            for (Book book : books) {
                String line = "Название: " + book.getBookName() + ", Автор: " + book.getAuthor() + ", Кол-во страниц: " + book.getPages() + "\n";
                Files.writeString(Paths.get(RECORD_FILE_PATH), line, StandardOpenOption.APPEND);
            }

            System.out.println("Книги записаны в файл " + RECORD_FILE_PATH);

        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordRootVegetable() throws ValidationException {
        try {
            Files.writeString(
                    Paths.get(RECORD_FILE_PATH),
                    TEXT_FILE_RECORD_ADD_ROOT_VEGETABLE,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            for (RootVegetable vegetable : dataObject.getRootVegetables()) {
                String line = "Тип: " + vegetable.getType() + ", Вес: " + vegetable.getWeight() + ", Цвет: " + vegetable.getColor() + "\n";
                Files.writeString(Paths.get(RECORD_FILE_PATH), line, StandardOpenOption.APPEND);

            }

            System.out.println("Корнеплоды записаны в файл " + RECORD_FILE_PATH);

        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordRootVegetable(List<RootVegetable> rootVegetables) throws ValidationException {
        try {
            Files.writeString(
                    Paths.get(RECORD_FILE_PATH),
                    TEXT_FILE_RECORD_ADD_ROOT_VEGETABLE,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            for (RootVegetable vegetable : rootVegetables) {
                String line = "Тип: " + vegetable.getType() + ", Вес: " + vegetable.getWeight() + ", Цвет: " + vegetable.getColor() + "\n";
                Files.writeString(Paths.get(RECORD_FILE_PATH), line, StandardOpenOption.APPEND);

            }

            System.out.println("Корнеплоды записаны в файл " + RECORD_FILE_PATH);

        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public static void clearFile() throws ValidationException {
        try {
            Files.newBufferedWriter(Path.of(RECORD_FILE_PATH), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new ValidationException("Проверьте наличие файла");
        }
    }
}