//Задача 4
import java.io.File;
import java.util.*;

public class DirectoryLister {
    public static void main(String[] args) {
        String path = ".";
        List<String> files = new ArrayList<>();

        File[] list = new File(path).listFiles();
        if (list != null) {
            for (File f : list) files.add(f.getName());
        }

        files.stream().limit(5).forEach(System.out::println);
    }
}