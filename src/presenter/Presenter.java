package presenter;

import model.Service;
import view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addAnimal(String name, LocalDate birthDate, ArrayList<String> commands, String className) {
        service.addAnimal(name, birthDate, commands, className);
        getRegistryInfo();
    }

    public void getRegistryInfo() {
        String info = service.getRegistryInfo();
        view.printMessage(info);
    }
    public void getAnimalCommands(String name) {
        ArrayList<String> commands = service.getAnimalCommands(name);
        view.printMessage(String.valueOf(commands));
    }
    public void teachAnimalCommands(String name, String command) {
        service.teachAnimalCommands(name, command);
    }
    public void sortRegistryByBirthDate() {
        service.sortAnimalsByBirthDate();
        getRegistryInfo();
    }
    public void getAnimalCount() {
        view.printMessage(service.getAnimalCount());
    }
}
