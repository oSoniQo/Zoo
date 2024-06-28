package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hamster extends Animal {
    public Hamster(String name, LocalDate birthDate, ArrayList<String> commands) {
        super(name, birthDate, commands);
    }

    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
