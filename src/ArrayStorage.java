/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int lastIndex = 0;

    void clear() {
        for (int i = 0; i < lastIndex; i++) {
            storage[i] = null;
        }
        lastIndex = 0;
    }

    void save(Resume r) {
        storage[lastIndex] = r;
        lastIndex++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[lastIndex - 1];
                storage[lastIndex - 1] = null;
                lastIndex--;
                break;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[lastIndex];
        for (int i = 0; i < lastIndex; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return lastIndex;
    }
}
