package CommandDesignPattern;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        CommandInterface copyPaste = new CopyPaste(editor);
        CommandInterface typeText = new TypeText(editor);

        copyPaste.execute();
        typeText.execute();
        typeText.undo();
        copyPaste.undo();
    }
}
