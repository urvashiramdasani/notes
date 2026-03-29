package CompositeDesignPattern;

public class File implements FileSystemElement {
    String filename;
    Directory parent;
    String content;

    public File(String filename) {
        this.filename = filename;
    }

    @Override
    public String getName() {
        return this.filename;
    }

    @Override
    public void showStructure() {
        System.out.println("File is : " + this.filename);
    }

    @Override
    public int calculateSize() {
        return filename.length();
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public Directory getParent() {
        return this.parent;
    }

    @Override
    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
