package CompositeDesignPattern;

import java.util.List;

public class Directory implements FileSystem {
    List<FileSystem> fileSystemList;
    String directoryName;

    public Directory(List<FileSystem> fileSystemList, String directoryName) {
        this.fileSystemList = fileSystemList;
        this.directoryName = directoryName;
    }

    @Override
    public void showStructure() {
        System.out.println("Inside directory " + this.directoryName);
        for (FileSystem fileSystem : fileSystemList) {
            fileSystem.showStructure();
        }
    }

    @Override
    public int calculateSize() {
        int totalSize = 0;

        for (FileSystem fileSystem : fileSystemList) {
            totalSize += fileSystem.calculateSize();
        }

        return totalSize;
    }

    @Override
    public void rename(String newName) {
        System.out.println("Directory " + this.directoryName + " renamed to " + newName);
        this.directoryName = newName;
    }
}
