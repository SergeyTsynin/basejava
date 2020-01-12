package storage;

import excepton.ExistStorageException;
import excepton.NotExistStorageException;
import excepton.StorageException;
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

    public void update(Resume r) {
        int key = indexOfResume(r.getUuid());
        if (key > -1) {
            storage[key] = r;
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    public void save(Resume r) {
        int key = indexOfResume(r.getUuid());
        if (key > -1) {
            throw new ExistStorageException(r.getUuid());
        } else if (lastIndex < STORAGE_LIMIT) {
            insertResume(r, key);
            lastIndex++;
        } else {
            throw new StorageException("Error: storage is full, resume was not saved", (r.getUuid()));
        }
    }

    public Resume get(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            return storage[key];
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public void delete(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            removeResume(key);
            storage[lastIndex - 1] = null;
            lastIndex--;
        } else {
            throw new NotExistStorageException(uuid);
        }
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

    protected abstract int indexOfResume(String uuid);

    protected abstract void insertResume(Resume r, int insertPoint);

    protected abstract void removeResume(int removePoint);
}
