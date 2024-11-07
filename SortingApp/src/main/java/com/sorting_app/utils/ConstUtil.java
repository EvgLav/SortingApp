package com.sorting_app.utils;

public final class ConstUtil {
    private ConstUtil() {
        throw new RuntimeException();
    }

    public static String RECORD_FILE_PATH = "src\\main\\resources\\Record.csv";
    public static String FILE_PATH_BOOK = "src\\main\\resources\\KeepBook.csv";
    public static String FILE_PATH_CAR = "src\\main\\resources\\KeepCar.csv";
    public static String FILE_PATH_ROOT_VEGETABLE = "src\\main\\resources\\KeepRootVegetable.csv";

    public static String TEXT_FILE_RECORD_ADD_BOOK = "\n-------------------\n Добавленные книги:\n";
    public static String TEXT_FILE_RECORD_ADD_CAR = "\n-------------------\n Добавленные автомобили:\n";
    public static String TEXT_FILE_RECORD_ADD_ROOT_VEGETABLE = "\n-------------------\n Добавленные корнеплоды:\n";
}