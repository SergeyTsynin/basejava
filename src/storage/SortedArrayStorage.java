package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "temp");
        return Arrays.binarySearch(storage, 0, lastIndex, searchKey);
    }

    @Override
    protected void insertResume(Resume r, int insertPoint) {
        insertPoint = ~insertPoint;
        System.arraycopy(storage, insertPoint, storage, insertPoint + 1, lastIndex - insertPoint);
        storage[insertPoint] = r;
    }

    @Override
    protected void removeResume(int removePoint) {
        System.arraycopy(storage, removePoint + 1, storage, removePoint, lastIndex - removePoint - 1);
    }
}
