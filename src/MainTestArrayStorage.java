import model.Resume;
import storage.ListStorage;
import storage.Storage;

/**
 * Test for my storage.SortedArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new ListStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1", "name1");
        Resume r2 = new Resume("uuid2", "name2");
        Resume r3 = new Resume("uuid3", "name3");
        Resume r4 = new Resume("uuid4", "name4");
        Resume r5 = new Resume("uuid5", "name5");
        Resume r6 = new Resume("uuid6", "name6");

//        System.out.println("Size: " + ARRAY_STORAGE.size());
//        ARRAY_STORAGE.save(r1);
//        ARRAY_STORAGE.update(r1);
//        ARRAY_STORAGE.save(r2);
//        ARRAY_STORAGE.update(r2);
//        printAll();
//        System.out.println("Size: " + ARRAY_STORAGE.size());
////        ARRAY_STORAGE.clear();
//        ARRAY_STORAGE.delete(r2.getUuid());
//        System.out.println("Size: " + ARRAY_STORAGE.size());
//        printAll();

        // save in wrong order
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r1);

        // try to save exists resume
        // ARRAY_STORAGE.save(r1);

        // test update
        ARRAY_STORAGE.update(r3);
//        ARRAY_STORAGE.update(r6);

        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());

        // test get
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        // test delete
        ARRAY_STORAGE.delete(r5.getUuid());
//        ARRAY_STORAGE.delete(r6.getUuid());
        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());

        ARRAY_STORAGE.clear();
        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }

}
