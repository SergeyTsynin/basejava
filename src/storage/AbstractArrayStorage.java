package storage;

import excepton.StorageException;
import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int lastIndex = 0;

    public void clear() {
        Arrays.fill(storage, 0, lastIndex, null);
        lastIndex = 0;
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, lastIndex);
    }

    public int size() {
        return lastIndex;
    }

    protected void updateRoutine(Resume r, Object key) {
        storage[(Integer) key] = r;
    }

    protected void saveRoutine(Resume r, Object key) {
        if (lastIndex < STORAGE_LIMIT) {
            insertResume(r, (Integer) key);
            lastIndex++;
        } else {
            throw new StorageException("Error: storage is full, resume was not saved", (r.getUuid()));
        }
    }

    protected Resume getRoutine(Object key) {
        return storage[(Integer) key];
    }

    protected void deleteRoutine(Object key) {
        removeResume((Integer) key);
        storage[lastIndex - 1] = null;
        lastIndex--;
    }

    protected abstract void insertResume(Resume r, int insertPoint);

    protected abstract void removeResume(int removePoint);
}
