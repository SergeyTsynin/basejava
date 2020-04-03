package storage;

import model.Resume;

/**
 * Map based storage for Resumes
 * Search key - uuid
 */
public class MapUuidStorage extends MapStorage {
    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void updateRoutine(Resume r, Object key) {
        storage.put((String) key, r);
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
