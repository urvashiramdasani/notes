package CommandDesignPattern;

import java.util.Stack;

public class EditorInvoker {
    Stack<CommandInterface> st = new Stack<>();

    public void executeCommand(CommandInterface command) {
        command.execute();
        st.push(command);
    }

    public void undoCommand(CommandInterface command) {
        CommandInterface commandInterface = st.pop();
        commandInterface.undo();
    }
}
