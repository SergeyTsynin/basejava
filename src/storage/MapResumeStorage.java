package storage;

import model.Resume;

import java.util.*;

/**
 * Map based storage for Resumes
 */
public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override ///
    protected Object getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override ///
    protected void updateRoutine(Resume r, Object key) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected void saveRoutine(Resume r, Object key) {
        storage.put(r.getUuid(), r);
    }

    @Override ///
    protected Resume getRoutine(Object key) {
        return (Resume) key;
    }

    @Override ///
    protected void deleteRoutine(Object key) {
        storage.remove(((Resume) key).getUuid());
    }

    @Override ///
    protected boolean isExists(Object key) {
        return key != null;
    }
}
