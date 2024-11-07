package com.sorting_app.execution_cycle;

import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.Record;
import com.sorting_app.utils.Printer;
import com.sorting_app.data.DataObject;
import com.sorting_app.strategy.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExecutionCycle {
    private final Scanner scanner = new Scanner(System.in);
    private int command;
    private DataObject dataObject;
    private Context context;
    private boolean isExit;
    private boolean isCorrect;

    public ExecutionCycle(DataObject dataObject) {
        this.dataObject = dataObject;
        this.context = new Context();
    }

    public void run() {
        isExit = false;
        while (!isExit) {
            try {
                Printer.printHelp();
                enterCommand();
            } catch (ValidationException validationException) {
                System.out.println(validationException.getMessage());
                command = 0;
            }
            switch (command) {
                case 1: {
                    fillCollection();
                    break;
                }
                case 2: {
                    sortCollection();
                    break;
                }
                case 3: {
                    findElement();
                    break;
                }
                case 4: {
                    recordCollectionInFile();
                    break;
                }
                case 5: {
                    clearFile();
                    break;
                }
                case 6: {
                    clearCollection();
                    break;
                }
                case 7: {
                    printCollection();
                    break;
                }
                case 8: {
                    isExit = true;
                    System.out.println("\nПрограмма завершена");
                    break;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте заново.");
                    break;
                }
            }
            scanner.nextLine();
        }
    }

    private void fillCollection() {
        isCorrect = false;
        try {
            System.out.println("Ведите номер желаемого способа заполнения коллекции:" +
                    "\n1 - из файла;" +
                    "\n2 - рандом;" +
                    "\n3 - вручную.\n");
            while (!isCorrect) {
                enterCommand();
                switch (command) {
                    case 1: {
                        context.setStrategy(new InputFileStrategy(dataObject));
                        context.commandSelected();
                        isCorrect = true;
                        break;
                    }
                    case 2: {
                        context.setStrategy(new InputRandomStrategy(dataObject));
                        context.commandSelected();
                        isCorrect = true;
                        break;
                    }
                    case 3: {
                        context.setStrategy(new InputConsoleStrategy(dataObject));
                        context.commandSelected();
                        isCorrect = true;
                        break;
                    }
                    default: {
                        System.out.println("Введите число от 1 до 3.");
                    }
                }
            }
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }
    }

    private void sortCollection() {
        isCorrect = false;
        try {
            System.out.println("Ведите номер желаемого способа сортировки коллекции:" +
                    "\n1 - mergeSort;" +
                    "\n2 - сортировка по числовому полю.\n");

            while (!isCorrect) {
                enterCommand();
                switch (command) {
                    case 1: {
                        context.setStrategy(new MergeSortStrategy(dataObject));
                        context.commandSelected();
                        isCorrect = true;
                        break;
                    }
                    case 2: {
                        context.setStrategy(new SortByEvenStrategy(dataObject));
                        context.commandSelected();
                        isCorrect = true;
                        break;
                    }
                    default: {
                        System.out.println("Введите число от 1 до 2.");
                    }
                }
            }
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }
    }

    private void findElement() {
        context.setStrategy(new BinarySearchStrategy(dataObject));// find
        context.commandSelected();
    }

    private void recordCollectionInFile() {
        context.setStrategy(new RecordStrategy(dataObject));
        context.commandSelected();
    }

    private void clearFile() {
        try {
            isCorrect = checkClean("файл");
            if (!isCorrect) {
                Record.clearFile();
                System.out.println("\n<<<ФАЙЛ ОЧИЩЕН>>>");
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    private void clearCollection() {
        isCorrect = checkClean("коллекцию");
        try {
            if (!isCorrect) {
                System.out.println("Выберите тип коллекции, которую хотите очистить:" +
                        "\n1 - АВТОМОБИЛИ;" +
                        "\n2 - КНИГИ;" +
                        "\n3 - КОРНЕПЛОДЫ;" +
                        "\n4 - ВСЕ КОЛЛЕКЦИИ.");
            }
            while (!isCorrect) {
                enterCommand();
                switch (command) {
                    case 1: {
                        dataObject.getCars().clear();
                        isCorrect = true;
                        System.out.println("\n<<<Коллекция АВТОМОБИЛИ очищена>>>");
                        break;
                    }
                    case 2: {
                        dataObject.getBooks().clear();
                        isCorrect = true;
                        System.out.println("\n<<<Коллекция КНИГИ очищена>>>");
                        break;
                    }
                    case 3: {
                        dataObject.getRootVegetables().clear();
                        isCorrect = true;
                        System.out.println("\n<<<Коллекция КОРНЕПЛОДЫ очищена>>>");
                        break;
                    }
                    case 4: {
                        dataObject.getCars().clear();
                        dataObject.getBooks().clear();
                        dataObject.getRootVegetables().clear();
                        isCorrect = true;
                        System.out.println("\n<<<Все коллекции очищены>>>");
                        break;
                    }
                    default: {
                        System.out.println("Введите число от 1 до 4.");
                    }
                }
            }
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }
    }

    private void printCollection() {
        context.setStrategy(new PrintObjectStrategy(dataObject));
        context.commandSelected();
    }

    private void enterCommand() throws ValidationException {
        try {
            System.out.print("Введите команду: ");
            command = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new ValidationException("Команда может быть только в числовом виде.");
        }
    }

    private boolean checkClean(String cleanningItem) {
        try {
            System.out.println("Вы действительно хотите очистить " + cleanningItem + ". \n1 - ДА;\n2 - НЕТ.\n");
            while (true) {
                enterCommand();
                if (command == 1) {
                    return false;
                } else if (command == 2) {
                    return true;
                } else {
                    System.out.println("Введите 1 - если хотите очистить, 2 - если не хотите очищать.");
                }
            }
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
            return false;
        }

    }
}
