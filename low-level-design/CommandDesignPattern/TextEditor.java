package CommandDesignPattern;

public class TextEditor {
    public void typeText(String input) {
        System.out.println("Text typed to editor: " + input);
    }

    public void deleteText() {
        System.out.println("Text deleted");
    }

    public void copyPaste() {
        System.out.println("Copy paste done.");
    }

    public void undoCopyPaste() {
        System.out.println("Undo copy paste.");
    }
}
