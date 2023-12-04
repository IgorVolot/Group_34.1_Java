package ait.filesystem;

import java.io.File;

public class JavaFileAppl {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

//        String path = "/users/igvol/Pictures/Screenshot";
        String path = File.separator + "users" + File.separator + "igvol" + File.separator + "Pictures" + File.separator + "Screenshot";

        System.out.println(path);
        File file = new File(path);
        System.out.println(file.exists());

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.getName());

        File[] files = file.listFiles();
        for (File f: files) {
            System.out.println(f.getName());
        }

        String newPath = path + File.separator + "my";
        File newDir = new File(newPath);
        System.out.println(newDir.exists());
        newDir.mkdir();
        System.out.println(newDir.exists());
        newDir.delete();
        System.out.println(newDir.exists());


    }
}
