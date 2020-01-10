import model.Resume;
import storage.SortedArrayStorage;
import storage.Storage;

/**
 * Test for my storage.SortedArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");
        Resume r4 = new Resume();
        r4.setUuid("uuid4");
        Resume r5 = new Resume();
        r5.setUuid("uuid5");

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
        ARRAY_STORAGE.update(r4);
//
        System.out.println("Size: " + ARRAY_STORAGE.size());
        printAll();
//        System.out.println("bs "+ Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r2));
/*
//        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
//
//        System.out.println("bs "+Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r2));
        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
//        ARRAY_STORAGE.delete(r1.uuid);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
*/
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
