package CompositeDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class Directory implements FileSystemElement {
    private final String name;
    private Directory parent;

    // O(1) lookup for children!
    private final Map<String, FileSystemElement> children;

    public Directory(String name) {
        this.name = name;
        this.children = new HashMap<>();
    }

    public void add(FileSystemElement element) {
        children.put(element.getName(), element);
        element.setParent(this);
    }

    public Map<String, FileSystemElement> getChildren() {
        return children;
    }

    @Override
    public String getName() { return name; }

    @Override
    public boolean isDirectory() { return true; }

    @Override
    public Directory getParent() { return parent; }

    @Override
    public void setParent(Directory parent) { this.parent = parent; }

    @Override
    public int calculateSize() {
        return children.values().stream().mapToInt(FileSystemElement::calculateSize).sum();
    }

    @Override
    public void showStructure() {
        System.out.println("Directory: " + name);
        for (FileSystemElement child : children.values()) {
            child.showStructure();
        }
    }
}