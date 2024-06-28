package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class AnimalRegistry implements Iterable<Animal> {
    private ArrayList<Animal> registry;

    public ArrayList<Animal> getRegistry() {
        return registry;
    }

    public AnimalRegistry(ArrayList<Animal> registry) {
        this.registry = registry;
    }
    public AnimalRegistry() {
        this(new ArrayList<>());
    }
    public void addAnimal(Animal animal) {
        registry.add(animal);
    }
    public void sortByBirthDate() {
        registry.sort(new AnimalComparatorByBirthDate());
    }
    public Animal foundAnimalByName(String name) {
        for (Animal animal : registry) {
            if (Objects.equals(animal.getName(), name)) {
                return animal;
            }
        }
        return null;
    }
    public Iterator<Animal> iterator() {
        return new AnimalIterator(registry);
    }
}
