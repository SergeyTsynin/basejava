package storage;

import excepton.ExistStorageException;
import excepton.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        updateRoutine(r, indexOfResumeIfExists(r.getUuid()));
    }

    public void save(Resume r) {
        saveRoutine(r, indexForNewResumeIfNotExists(r));
    }

    public Resume get(String uuid) {
        return getRoutine(indexOfResumeIfExists(uuid));
    }

    public void delete(String uuid) {
        deleteRoutine(indexOfResumeIfExists(uuid));
    }

    private int indexOfResumeIfExists(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            return key;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private int indexForNewResumeIfNotExists(Resume r) {
        int key = indexOfResume(r.getUuid());
        if (key > -1) {
            throw new ExistStorageException(r.getUuid());
        } else {
            return key;
        }
    }

    protected abstract Integer indexOfResume(String uuid);

    protected abstract void updateRoutine(Resume r, int key);

    protected abstract void saveRoutine(Resume r, int key);

    protected abstract Resume getRoutine(int key);

    protected abstract void deleteRoutine(int key);
}
