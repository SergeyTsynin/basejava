package storage;

import model.Resume;

/**
 * Map based storage for Resumes
 * Search key - Resume
 */
public class MapResumeStorage extends MapStorage {
    @Override
    protected Object getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void updateRoutine(Resume r, Object key) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getRoutine(Object key) {
        return (Resume) key;
    }

    @Override
    protected void deleteRoutine(Object key) {
        storage.remove(((Resume) key).getUuid());
    }

    @Override
    protected boolean isExists(Object key) {
        return key != null;
    }
}
