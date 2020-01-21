package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

/**
 * Map based storage for Resumes
 */
public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap();

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
    protected Object indexOfResume(String uuid) {
        return (storage.containsKey(uuid)) ? uuid : null;
    }

    @Override
    protected void updateRoutine(Resume r, Object key) {
        storage.put((String) key, r);
//        storage.put(r.getUuid(), r);  // for future, don`t check it!
    }

    @Override
    protected void saveRoutine(Resume r, Object key) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getRoutine(Object key) {
        return storage.get(key);
    }

    @Override
    protected void deleteRoutine(Object key) {
        storage.remove(key);
    }

    @Override
    protected boolean resumeIsExists(Object key) {
        return key != null;
    }
}
