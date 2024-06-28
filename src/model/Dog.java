package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dog extends Animal {
    public Dog(String name, LocalDate birthDate, ArrayList<String> commands) {
        super(name, birthDate, commands);
    }

    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
