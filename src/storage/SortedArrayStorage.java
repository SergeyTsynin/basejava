package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
//    @Override
//    public void clear() {
//
//    }
//
    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        int key = indexOfResume(r.getUuid());
        if (key > -1) {
            System.out.println("Error: resume " + r.getUuid() + " is already exists.");
        } else if (lastIndex < STORAGE_LIMIT) {
            if (-key > lastIndex) {
                storage[lastIndex] = r;
                lastIndex++;
            } else {
                key = -key;
                System.arraycopy(storage, key - 1, storage, key, lastIndex + 1 - key);
                storage[key - 1] = r;
                lastIndex++;
            }
        } else {
            System.out.println("Error: storage is full, resume was not saved");
        }
    }

    @Override
    public void delete(String uuid) {

    }

//    @Override
//    public Resume[] getAll() {
//        return new Resume[0];
//    }
//
    @Override
    protected int indexOfResume(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, lastIndex, searchKey);
    }
}
