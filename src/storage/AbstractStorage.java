package storage;

import excepton.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    public Resume get(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            return getRoutine(key);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public void delete(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            deleteRoutine(key);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract int indexOfResume(String uuid);

    protected abstract Resume getRoutine(int key);

    protected abstract void deleteRoutine(int key);
}
