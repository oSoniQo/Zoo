package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cat extends Animal {
    public Cat(String name, LocalDate birthDate, ArrayList<String> commands) {
        super(name, birthDate, commands);
    }

    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
