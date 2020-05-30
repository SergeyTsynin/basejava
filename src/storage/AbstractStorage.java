package storage;

import excepton.ExistStorageException;
import excepton.NotExistStorageException;
import model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

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

    private SK getSearchKeyForExistedResume(String uuid) {
        SK key = getSearchKey(uuid);
        if (isExists(key)) {
            return key;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private SK getSearchKeyForNewResume(Resume r) {
        SK key = getSearchKey(r.getUuid());
        if (isExists(key)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            return key;
        }
    }

    protected abstract SK getSearchKey(String uuid);

    protected abstract void updateRoutine(Resume r, SK key);

    protected abstract void saveRoutine(Resume r, SK key);

    protected abstract Resume getRoutine(SK key);

    protected abstract void deleteRoutine(SK key);

    protected abstract boolean isExists(SK key);

    protected abstract List<Resume> doGetAll();

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doGetAll();
        Collections.sort(list);
        return list;
    }
}
