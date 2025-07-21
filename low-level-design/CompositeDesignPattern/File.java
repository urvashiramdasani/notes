package CompositeDesignPattern;

public class File implements FileSystem {
    String filename;

    public File(String filename) {
        this.filename = filename;
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
    public void rename(String newName) {
        System.out.println(this.filename + " renamed to " + newName);
    }
}
