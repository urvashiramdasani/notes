package MementoDesignPattern;

public class Editor {
    String name;
    String content;

    public Editor(String name, String content) {
        this.content = content;
        this.name = name;
    }

    public void type(String text) {
        this.content += text;
    }

    public Memento createMemento() {
        return new Memento(this.name, this.content);
    }

    public void restoreMemento(Memento lastMemento) {
        this.name = lastMemento.name;
        this.content = lastMemento.content;
    }
}
