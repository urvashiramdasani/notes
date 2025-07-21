package CompositeDesignPattern;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Directory directory1 = new Directory(List.of(file1, file2), "directory1");

        File file3 = new File("file3.txt");
        Directory directory2 = new Directory(List.of(file3, directory1), "directory2");

        System.out.println("File System Structure:");
        directory2.showStructure();

        System.out.println("\nTotal Size: " + directory2.calculateSize());

        file1.rename("new_file1.txt");
        directory1.rename("new_directory1");
    }
}
