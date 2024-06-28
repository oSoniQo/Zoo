package view.commands;

import view.ConsoleUI;

public class GetAnimalCommands extends Command {
    public GetAnimalCommands(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Посмотреть команды животного";
    }

    public void execute() {
        consoleUI.getAnimalCommands();
    }
}
