package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int indexOfResume(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, lastIndex, searchKey);
    }

    @Override
    protected void insertResume(Resume r, int insertPoint) {
        System.arraycopy(storage, insertPoint, storage, insertPoint + 1, lastIndex - insertPoint);
        storage[insertPoint] = r;
    }

    @Override
    protected void moveTailAfterDelete(int victim) {
        System.arraycopy(storage, victim + 1, storage, victim, lastIndex - victim - 1);
    }
}
