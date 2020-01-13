package storage;

import excepton.ExistStorageException;
import excepton.NotExistStorageException;
import excepton.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractArrayStorageTest {

    private Storage storage = new ArrayStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() throws Exception {
        Resume updatedResume = new Resume(UUID_1);
        storage.update(updatedResume);
        assertTrue(storage.get(UUID_1) == updatedResume);
        assertSize(3);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExists() throws Exception {
        storage.update(RESUME_4);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExists() throws Exception {
        storage.save(RESUME_3);
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExists() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_2);
        assertSize(2);
        assertGet(RESUME_1);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExists() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void getAll() throws Exception {
        Resume[] arr = storage.getAll();
        assertEquals(RESUME_1, arr[0]);
        assertEquals(RESUME_2, arr[1]);
        assertEquals(RESUME_3, arr[2]);
        assertEquals(3, arr.length);
    }

    @Test
    public void overloadStorage() throws Exception {
        storage.clear();
        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume("r" + i));
        }
        try {
            storage.save(new Resume());
            Assert.fail("StorageException");
        } catch (StorageException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}