import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10_000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int lastIndex = 0;

    void clear() {
        Arrays.fill(storage, 0, lastIndex, null);
        lastIndex = 0;
    }

    void update(Resume r) {
        int key = indexOfResume(r.getUuid());
        if (key > -1) {
            storage[lastIndex] = r;
            lastIndex++;
        } else {
            System.out.println("Error: resume " + r.getUuid() + " is not found for update.");
        }
    }

    void save(Resume r) {
        int key = indexOfResume(r.getUuid());
        if (key > -1) {
            System.out.println("Error: resume " + r.getUuid() + " is already exists.");
        } else if (lastIndex < storage.length) {
            storage[lastIndex] = r;
            lastIndex++;
        } else {
            System.out.println("Error: storage is full, resume was not saved");
        }

    }

    Resume get(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            return storage[key];
        } else {
            return null;
        }
    }

    void delete(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            storage[key] = storage[lastIndex - 1];
            storage[lastIndex - 1] = null;
            lastIndex--;
        } else {
            System.out.println("Error: resume " + uuid + " is not found for delete.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, lastIndex);
    }

    int size() {
        return lastIndex;
    }

    private int indexOfResume(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
