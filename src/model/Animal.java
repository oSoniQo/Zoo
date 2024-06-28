package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Animal {
    private String name;
    private LocalDate birthDate;
    private ArrayList<String> commands;

    public Animal(String name, LocalDate birthDate, ArrayList<String> commands) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }
    public Animal(String name, LocalDate birthDate) {
        this(name, birthDate, new ArrayList<String>());
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }
    public void addCommand(String command) {
        commands.add(command);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "имя " + name + ", дата рождения " + birthDate + ", команды " + commands;
    }
}
