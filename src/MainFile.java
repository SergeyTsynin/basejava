import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File folder = new File(".\\src");
//        trackMan2(folder);
        trackMan3(folder, "");
    }

    private static void trackMan2(File file) {
        File[] pig = file.listFiles();
        if (pig != null) {
            for (File value : pig) {
                if (value.isDirectory()) {
                    trackMan2(value);
                } else {
                    String name = value.getName();
                    System.out.println(name.substring(0, name.lastIndexOf(".")));
                }
            }
        }
    }

    private static void trackMan3(File file, String tab) {
        File[] pig = file.listFiles();
        if (pig != null) {
            for (File value : pig) {
                if (value.isDirectory()) {
                    System.out.println(tab + " + " + value.getName());
                    trackMan3(value, " " + tab);
                } else {
                    System.out.println(tab + "| " + value.getName());
                }
            }
        }
    }
}
