package command;

import java.util.Stack;

public class CommandHistory {
	private Stack<Command> history;

    public CommandHistory() {
        this.history = new Stack<>();
    }

    // Метод для добавления команды в историю
    public void push(Command command) {
        history.push(command);
    }

    // Метод для извлечения последней команды из истории
    public Command pop() {
        if (!history.isEmpty()) {
            return history.pop();
        } else {
            return null;
        }   
    }    
}
    
