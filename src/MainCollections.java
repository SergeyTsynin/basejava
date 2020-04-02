import model.Resume;

import java.util.*;

public class MainCollections {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1, "alfa");
    private static final Resume RESUME_2 = new Resume(UUID_2, "beta");
    private static final Resume RESUME_3 = new Resume(UUID_3, "gamma");
    private static final Resume RESUME_4 = new Resume(UUID_4, "delta");

    public static void main(String[] args) {

/*
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);

        for (Resume r : collection) {
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_1)) {
//                collection.remove(r);
            }
        }

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());
*/
        Map<String, Resume> storage = new HashMap<>();
        storage.put(UUID_1, RESUME_1);
        storage.put(UUID_2, RESUME_2);
        storage.put(UUID_3, RESUME_3);

        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            if (entry.getValue().equals(RESUME_3)) {
                System.out.println(entry.getKey());
                break;
            }
//            System.out.println(entry.getValue());
//            System.out.println(entry.getKey());
        }
        System.out.println("null");
//        if (storage[i].getUuid().equals(uuid)) {

        // Bad!
//        for (String uuid : storage.keySet()) {
//            System.out.println(storage.get(uuid));
//        }

    }

}
