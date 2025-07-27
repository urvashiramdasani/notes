package MementoDesignPattern;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor("doc1", "some content");
        CareTaker careTaker = new CareTaker();
        editor.type(" add more");
        careTaker.save(editor);

        editor.type(" even more");
        System.out.println(editor.content);

        careTaker.undo(editor);
        System.out.println(editor.content);
    }
}
