package interview;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    private Node root;
    private Node curr;

    public FileSystem() {
        this.root = new Node("/");
        this.curr = root;
    }

    private class Node {
        String name;
        Map<String, Node> dirs;
        Map<String, Node> files;

        public Node(String name) {
            this.name = name;
            this.dirs = new HashMap<>();
            this.files = new HashMap<>();
        }
    }

    private void mkdir(String path) {
        String[] dirs = path.split("/");
        Node currTemp = root;
        for (String dir : dirs) {
            if (dir.isEmpty()) {
                continue;
            }
            if (!currTemp.dirs.containsKey(dir)) {
                System.out.println("Creating directory: " + dir);
                currTemp.dirs.put(dir, new Node(dir));
            }
            currTemp = currTemp.dirs.get(dir);
        }
    }

    private void touch(String path) {
        String[] dirs = path.split("/");
        int n = dirs.length;
        Node currTemp = root;
        for (int i = 1; i < n - 1; i++) {
            if (!currTemp.dirs.containsKey(dirs[i])) {
                System.out.println("Creating directory: " + dirs[i]);
                currTemp.dirs.put(dirs[i], new Node(dirs[i]));
            }
            currTemp = currTemp.dirs.get(dirs[i]);
        }
        if (!currTemp.files.containsKey(dirs[n - 1])) {
            System.out.println("Creating file: " + dirs[n - 1]);
            currTemp.files.put(dirs[n - 1], new Node(dirs[n - 1]));
        }
    }

    private void cd(String path) {
        String[] dirs = path.split("/");
        int n = dirs.length;
        Node currTemp = root;
        for (int i = 1; i < n; i++) {
            if (!currTemp.dirs.containsKey(dirs[i])) {
                System.out.println("Directory not found: " + dirs[i]);
                return;
            }
            currTemp = currTemp.dirs.get(dirs[i]);
        }
        curr = currTemp;
    }

    private void ls(String path) {
        String[] dirs = path.split("/");
        int n = dirs.length;
        Node currTemp = root;
        for (int i = 1; i < n; i++) {
            if (!currTemp.dirs.containsKey(dirs[i])) {
                System.out.println("Directory not found: " + dirs[i]);
                return;
            }
            currTemp = currTemp.dirs.get(dirs[i]);
        }
        System.out.println("Directories: " + currTemp.dirs.keySet());
        System.out.println("Files: " + currTemp.files.keySet());
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.mkdir("/a");
        fs.mkdir("/a/b/c");
        fs.mkdir("/a/b/d");
        fs.mkdir("/a/b/e");

        fs.touch("/a/b/file1");

        fs.ls("/a/b");
    }
}
