package view.commands;

import view.ConsoleUI;

public class SortRegistryByBirthDate extends Command {
    public SortRegistryByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать реестр по дате рождения";
    }

    public void execute() {
        consoleUI.sortRegistryByBirthDate();
    }
}
