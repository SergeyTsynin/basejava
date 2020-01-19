package storage;

import excepton.ExistStorageException;
import excepton.NotExistStorageException;
//import excepton.StorageException;
import model.Resume;

import java.util.ArrayList;

/**
 * ArrayList based storage for Resumes
 */
public class ListStorage extends AbstractStorage {
    private ArrayList<Resume> storage = new ArrayList<>();

    @Override  //ok
    public void clear() {
        storage.clear();
    }

    @Override  //ok
    public void update(Resume r) {
        if (storage.contains(r)) {
            storage.set(storage.indexOf(r), r);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    @Override  //ok
    public void save(Resume r) {
        if (!storage.contains(r)) {
            storage.add(r);
        } else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    @Override  //ok
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override  //ok
    public int size() {
        return storage.size();
    }

    protected int indexOfResume(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    protected Resume getRoutine(int key) {
        return storage.get(key);
    }

    protected void deleteRoutine(int key) {
        storage.remove(key);
    }
}
