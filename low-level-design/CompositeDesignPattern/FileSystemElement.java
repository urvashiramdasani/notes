package CompositeDesignPattern;

public interface FileSystemElement {
    String getName();
    void showStructure();
    int calculateSize();

    boolean isDirectory();
    Directory getParent();
    void setParent(Directory parent);
}
