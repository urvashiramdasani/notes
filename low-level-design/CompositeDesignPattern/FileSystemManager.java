package CompositeDesignPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSystemManager {
    private final Directory root;
    private Directory cwd;

    public FileSystemManager() {
        this.root = new Directory("/");
        this.cwd = root;
    }

    // ---------------- Utility ----------------

    private List<String> splitPath(String path) {
        List<String> parts = new ArrayList<>();
        for (String part : path.split("/")) {
            if (!part.isEmpty()) {
                parts.add(part);
            }
        }
        return parts;
    }

    public String pwd() {
        if (cwd == root) return "/";

        StringBuilder path = new StringBuilder();
        Directory current = cwd;

        // Walk up the parent pointers
        while (current != root && current != null) {
            path.insert(0, "/" + current.getName());
            current = current.getParent();
        }
        return path.toString();
    }

    // ---------------- mkdir ----------------

    public void mkdir(String path) {
        Directory current = path.startsWith("/") ? root : cwd;
        List<String> parts = splitPath(path);

        for (String part : parts) {
            // If child doesn't exist, create it
            if (!current.getChildren().containsKey(part)) {
                current.add(new Directory(part));
            }

            FileSystemElement next = current.getChildren().get(part);

            // Ensure we aren't trying to make a directory inside a File!
            if (!next.isDirectory()) {
                throw new IllegalArgumentException(part + " is a file, not a directory!");
            }
            current = (Directory) next;
        }
    }

    // ---------------- GLOB CD ----------------

    public boolean cd(String path) {
        Directory start = path.startsWith("/") ? root : cwd;
        List<String> parts = splitPath(path);

        // Candidate nodes at current level
        List<Directory> currentLevel = new ArrayList<>();
        currentLevel.add(start);

        for (String part : parts) {
            List<Directory> nextLevel = new ArrayList<>();

            for (Directory dir : currentLevel) {
                if (part.equals(".")) {
                    nextLevel.add(dir);
                } else if (part.equals("..")) {
                    if (dir.getParent() != null) {
                        nextLevel.add(dir.getParent());
                    } else {
                        nextLevel.add(dir); // root's parent is root
                    }
                } else if (part.equals("*")) {
                    // Add all children that are DIRECTORIES
                    for (FileSystemElement child : dir.getChildren().values()) {
                        if (child.isDirectory()) {
                            nextLevel.add((Directory) child);
                        }
                    }
                } else {
                    FileSystemElement child = dir.getChildren().get(part);
                    if (child != null && child.isDirectory()) {
                        nextLevel.add((Directory) child);
                    }
                }
            }

            currentLevel = nextLevel;
            if (currentLevel.isEmpty()) break;
        }

        // ---- Decision ----
        if (currentLevel.isEmpty()) {
            System.out.println("cd: no such directory: " + path);
            return false;
        }

        if (currentLevel.size() > 1) {
            System.out.println("cd: multiple paths found for: " + path);
            // You could temporarily set cwd to print the absolute paths here
            return false;
        }

        // Exactly one match
        cwd = currentLevel.get(0);
        return true;
    }

    public void addContentToFile(String path, String content) {
        // 1. Start at the correct root or cwd
        Directory current = path.startsWith("/") ? root : cwd;

        // 2. Split the path and separate the file name from the directories
        List<String> parts = splitPath(path);
        String fileName = parts.remove(parts.size() - 1); // The last part is ALWAYS the file

        // 3. Silent Traversal: Walk down the tree (and create missing directories)
        for (String part : parts) {
            if (!current.getChildren().containsKey(part)) {
                current.add(new Directory(part)); // Auto-create missing directories
            }

            FileSystemElement next = current.getChildren().get(part);
            if (!next.isDirectory()) {
                throw new IllegalArgumentException(part + " is a file, cannot traverse through it!");
            }
            current = (Directory) next;
        }

        // 4. File Creation: If the file doesn't exist, create it
        if (!current.getChildren().containsKey(fileName)) {
            current.add(new File(fileName));
        }

        // 5. Safely get the file and append content
        FileSystemElement target = current.getChildren().get(fileName);
        if (target.isDirectory()) {
            throw new IllegalArgumentException("Cannot add text content to a directory!");
        }

        ((File) target).setContent(content);
    }

    public List<String> ls(String path) {
        // 1. Start at the correct root or cwd
        FileSystemElement current = path.startsWith("/") ? root : cwd;

        // 2. Split the path and traverse
        List<String> parts = splitPath(path);

        for (String part : parts) {
            if (current.isDirectory()) {
                Directory dir = (Directory) current;
                if (!dir.getChildren().containsKey(part)) {
                    throw new IllegalArgumentException("Path does not exist: " + path);
                }
                current = dir.getChildren().get(part);
            } else {
                // We hit a file before finishing the path!
                throw new IllegalArgumentException("Invalid path, encountered a file too early.");
            }
        }

        // 3. Prepare the result list
        List<String> result = new ArrayList<>();

        // 4. Handle File vs Directory
        if (!current.isDirectory()) {
            // It's a file: just return its own name
            result.add(current.getName());
        } else {
            // It's a directory: get all children names
            Directory targetDir = (Directory) current;
            result.addAll(targetDir.getChildren().keySet());

            // explicitly sort the list alphabetically!
            Collections.sort(result);
        }

        return result;
    }
}