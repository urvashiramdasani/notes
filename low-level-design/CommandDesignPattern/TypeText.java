package CommandDesignPattern;

public class TypeText implements CommandInterface {
    TextEditor editor;

    public TypeText(TextEditor textEditor) {
        this.editor = textEditor;
    }

    @Override
    public void execute() {
        this.editor.typeText("hello");
    }

    @Override
    public void undo() {
        this.editor.deleteText();
    }
}
