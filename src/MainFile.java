import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        trackMan(".\\src");
    }

    private static void trackMan(String dir) {
        File folder = new File(dir);
        if (folder.isFile()) {
            String fileName = folder.getName();
            System.out.println(fileName.substring(0, fileName.lastIndexOf(".")));
        } else {
            if (!folder.exists()) return;
            for (String name : folder.list()) {
                trackMan(folder + "\\" + name);
            }
        }
    }
}
