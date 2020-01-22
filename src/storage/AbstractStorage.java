package storage;

import excepton.ExistStorageException;
import excepton.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        updateRoutine(r, getSearchKeyForExistedResume(r.getUuid()));
    }

    public void save(Resume r) {
        saveRoutine(r, getSearchKeyForNewResume(r));
    }

    public Resume get(String uuid) {
        return getRoutine(getSearchKeyForExistedResume(uuid));
    }

    public void delete(String uuid) {
        deleteRoutine(getSearchKeyForExistedResume(uuid));
    }

    private Object getSearchKeyForExistedResume(String uuid) {
        Object key = getSearchKey(uuid);
        if (isExists(key)) {
            return key;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getSearchKeyForNewResume(Resume r) {
        Object key = getSearchKey(r.getUuid());
        if (isExists(key)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            return key;
        }
    }

    protected abstract Object getSearchKey(String uuid);

    protected abstract void updateRoutine(Resume r, Object key);

    protected abstract void saveRoutine(Resume r, Object key);

    protected abstract Resume getRoutine(Object key);

    protected abstract void deleteRoutine(Object key);

    protected abstract boolean isExists(Object key);
}
