package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

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

    @Override
    protected void removeResume(int removePoint) {
        storage[removePoint] = storage[lastIndex - 1];
    }
}
