package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void delete(String uuid) {
        int key = indexOfResume(uuid);
        if (key > -1) {
            System.arraycopy(storage, key + 1, storage, key, lastIndex - key - 1);
            storage[lastIndex - 1] = null;
            lastIndex--;
        } else {
            System.out.println("Error: resume " + uuid + " is not found for delete.");
        }
    }

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
}
