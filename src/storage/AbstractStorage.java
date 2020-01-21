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

    private Object indexOfResumeIfExists(String uuid) {
        Object key = indexOfResume(uuid);
        if (resumeIsExists(key)) {
            return key;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object indexForNewResumeIfNotExists(Resume r) {
        Object key = indexOfResume(r.getUuid());
        if (resumeIsExists(key)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            return key;
        }
    }

    protected abstract Object indexOfResume(String uuid);

    protected abstract void updateRoutine(Resume r, Object key);

    protected abstract void saveRoutine(Resume r, Object key);

    protected abstract Resume getRoutine(Object key);

    protected abstract void deleteRoutine(Object key);

    protected abstract boolean resumeIsExists(Object key);

}
