package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int lastIndex = 0;

    public void clear() {
        Arrays.fill(storage, 0, lastIndex, null);
        lastIndex = 0;
    }

    public int size() {
        return lastIndex;
    }

    public Resume get(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            return storage[key];
        } else {
            System.out.println("Error: resume " + uuid + " is not found.");
            return null;
        }
    }

    protected abstract int indexOfResume(String uuid);
}
