package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Service {
    private AnimalRegistry registry;

    public Service() {
        registry = new AnimalRegistry();
    }

    public void addAnimal(String name, LocalDate birthDate, ArrayList<String> commands, String className) {
        try (Counter counter = new Counter()) {
            String newClassName = className.substring(0,6) + className.substring(6,7).toUpperCase() + className.substring(7);
            Class<?> type = Class.forName(newClassName);
            Class[] animalClassParams = {String.class, LocalDate.class, ArrayList.class};
            Animal animal = (Animal) type.getConstructor(animalClassParams).newInstance(name, birthDate, commands);
            Counter.add();
            registry.addAnimal(animal);
        } catch (Exception e) {
            System.out.println("Неверные данные");;
        }
    }
    public ArrayList<String> getAnimalCommands(String name) {
        Animal animal = registry.foundAnimalByName(name);
        return animal.getCommands();
    }
    public void teachAnimalCommands(String name, String command) {
        Animal animal = registry.foundAnimalByName(name);
        animal.addCommand(command);
    }
    public void sortAnimalsByBirthDate() {
        registry.sortByBirthDate();
    }
    public String getRegistryInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Реестр:\n");
        for (Animal animal: registry){
            stringBuilder.append(animal);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public String getAnimalCount() {
        try(Counter counter = new Counter()) {
            return String.valueOf(Counter.count);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
