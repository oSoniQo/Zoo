package model;

import java.util.Comparator;

public class AnimalComparatorByBirthDate implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        if (o1.getBirthDate().isBefore(o2.getBirthDate())) {
            return -1;
        }
        else if (o1.getBirthDate().isAfter(o2.getBirthDate())) {
            return 1;
        }
        return 0;
    }
}
