package storage;

//import excepton.StorageException;
import model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList based storage for Resumes
 */
public class ListStorage extends AbstractStorage {
    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    protected Integer indexOfResume(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void updateRoutine(Resume r, int key) {
        storage.set(key, r);
    }

    @Override
    protected void saveRoutine(Resume r, int key) {
        storage.add(r);
    }

    protected Resume getRoutine(int key) {
        return storage.get(key);
    }

    protected void deleteRoutine(int key) {
        storage.remove(key);
    }
}
