package view.commands;

import view.ConsoleUI;

public class GetAnimalCount extends Command {
    public GetAnimalCount(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Посмотреть кол-во животных";
    }

    public void execute() {
        consoleUI.getAnimalCount();
    }
}
