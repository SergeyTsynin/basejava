package storage;

import model.Resume;

import java.util.*;

/**
 * Map based storage for Resumes
 */
public abstract class MapStorage extends AbstractStorage {
    protected Map<String, Resume> storage = new HashMap<>();

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

    @Override
    protected void saveRoutine(Resume r, Object key) {
        storage.put(r.getUuid(), r);
    }
}
