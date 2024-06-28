package view.commands;

import view.ConsoleUI;

public class TeachAnimalCommands extends Command {
    public TeachAnimalCommands(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Научить животное команде";
    }

    public void execute() {
        consoleUI.teachAnimalCommands();
    }
}
