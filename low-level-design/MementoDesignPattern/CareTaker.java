package MementoDesignPattern;

import java.util.Stack;

public class CareTaker {
    Stack<Memento> stack = new Stack<>();

    public void save(Editor editor) {
        stack.push(editor.createMemento());
    }

    public void undo(Editor editor) {
        if(!stack.empty()) {
            Memento lastMemento = stack.pop();
            editor.restoreMemento(lastMemento);
        }
    }
}
