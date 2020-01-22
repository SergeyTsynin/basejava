package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

/**
 * Map based storage for Resumes
 */
public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void updateRoutine(Resume r, Object key) {
        storage.put((String) key, r);
    }

    @Override
    protected void saveRoutine(Resume r, Object key) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getRoutine(Object key) {
        String s = (String) key;
        return storage.get(s);
    }

    @Override
    protected void deleteRoutine(Object key) {
        String s = (String) key;
        storage.remove(s);
    }

    @Override
    protected boolean isExists(Object key) {
        String s = (String) key;
        return storage.containsKey(s);
    }
}
