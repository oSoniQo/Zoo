package view;

import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Введено неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        work = true;
    }

    public void printMessage(String text) {
        System.out.println(text);
    }

    public void start() {
        greetings();
        while (work){
            printMenu(menu);
            execute();
        }
    }

    public void finish() {
        System.out.println("Работа программы завершена");
        work = false;
    }
    private void greetings(){
        System.out.println("Добро пожаловать в реестр домашних животных!");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu)){
                menu.execute(numCommand);
            }
        }
    }
    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public boolean checkTextForDateFormat(String text)  {
        try {
            LocalDate.parse(text, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private boolean checkCommand(int numCommand, Menu menu){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(Menu menu){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void sortRegistryByBirthDate() {
        presenter.sortRegistryByBirthDate();
    }

    public void getRegistryInfo() { presenter.getRegistryInfo(); }

    public void addAnimal() {
        System.out.println("Введите имя животного");
        String name = scanner.nextLine();
        LocalDate birthDate;
        System.out.println("Укажите дату рождения в формате dd.MM.yyyy");
        String birthDateString = scanner.nextLine();
        if (checkTextForDateFormat(birthDateString)) {
            birthDate = LocalDate.parse(birthDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        else {
            birthDate = LocalDate.now();
        }
        System.out.println("Введите команды через пробел");
        String commandsInput = scanner.nextLine();
        String[] com = commandsInput.split(" ");
        ArrayList<String> commands = new ArrayList<>(Arrays.asList(com));
        System.out.println("Введите класс животного - Cat, Dog, Hamster");
        String className = "model." + scanner.nextLine();
        try {
            presenter.addAnimal(name, birthDate, commands, className);
        }
        catch (Exception e) {
            inputError();
            getRegistryInfo();
        }
    }
    public void getAnimalCommands() {
        System.out.println("Введите имя животного");
        String name = scanner.nextLine();
        try {
            presenter.getAnimalCommands(name);
        }
        catch (Exception e) {
            inputError();
        }
    }
    public void teachAnimalCommands() {
        System.out.println("Введите имя животного");
        String name = scanner.nextLine();
        System.out.println("Введите команду");
        String command = scanner.nextLine();
        try {
            presenter.teachAnimalCommands(name, command);
        }
        catch (Exception e) {
            inputError();
        }
    }
    public void getAnimalCount() {
        presenter.getAnimalCount();
    }
}
