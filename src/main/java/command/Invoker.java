package command;

public class Invoker {
	private CommandHistory commandHistory;

    public Invoker(CommandHistory commandHistory) {
        this.commandHistory = commandHistory;
    }

    // Метод для выполнения команды
    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    // Метод для отмены последней команды
    public void undoLastCommand() {
        Command lastCommand = commandHistory.pop();
        if (lastCommand != null) {
            lastCommand.undo();
        } else {
            System.out.println("нет комманд для отмены.");
        }
    }
}
