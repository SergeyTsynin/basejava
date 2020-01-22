package storage;

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
        return null;
    }

    @Override
    protected void updateRoutine(Resume r, Object key) {
        storage.set((Integer) key, r);
    }

    @Override
    protected void saveRoutine(Resume r, Object key) {
        storage.add(r);
    }

    protected Resume getRoutine(Object key) {
        return storage.get((Integer) key);
    }

    protected void deleteRoutine(Object key) {
        int delKey = (Integer) key;
        storage.remove(delKey);
    }

    @Override
    protected boolean isResumeExists(Object key) {
        return key != null;
    }
}
