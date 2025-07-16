package CommandDesignPattern;

public class CopyPaste implements CommandInterface {
    TextEditor editor;

    public CopyPaste(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        this.editor.copyPaste();
    }

    @Override
    public void undo() {
        this.editor.undoCopyPaste();
    }
}
