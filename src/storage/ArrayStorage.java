package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        int key = indexOfResume(r.getUuid());
        if (key > -1) {
            System.out.println("Error: resume " + r.getUuid() + " is already exists.");
        } else if (lastIndex < STORAGE_LIMIT) {
            storage[lastIndex] = r;
            lastIndex++;
        } else {
            System.out.println("Error: storage is full, resume was not saved");
        }
    }

    public void delete(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            storage[key] = storage[lastIndex - 1];
            storage[lastIndex - 1] = null;
            lastIndex--;
        } else {
            System.out.println("Error: resume " + uuid + " is not found for delete.");
        }
    }

    protected int indexOfResume(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertResume(Resume r, int insertPoint) {
        storage[lastIndex] = r;
    }
}
