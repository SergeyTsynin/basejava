package storage;

import excepton.ExistStorageException;
import excepton.NotExistStorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static storage.ResumeTestData.getFakeResume;

public abstract class AbstractStorageTest {
    static final String STORAGE_DIR = "D:\\_Java\\projects\\basejava\\storage";

    protected Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    //    private static final Resume RESUME_1 = new Resume(UUID_1, "alfa");
//    private static final Resume RESUME_2 = new Resume(UUID_2, "beta");
//    private static final Resume RESUME_3 = new Resume(UUID_3, "gamma");
//    private static final Resume RESUME_4 = new Resume(UUID_4, "delta");
    private static final Resume RESUME_1 = getFakeResume(UUID_1);
    private static final Resume RESUME_2 = getFakeResume(UUID_2);
    private static final Resume RESUME_3 = getFakeResume(UUID_3);
    private static final Resume RESUME_4 = getFakeResume(UUID_4);

    AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

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
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        Resume updatedResume = new Resume(UUID_1, "omega");
        storage.update(updatedResume);
        assertEquals(updatedResume, storage.get(UUID_1));
        assertSize(3);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExists() {
        storage.update(RESUME_4);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExists() {
        storage.save(RESUME_3);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExists() {
        storage.get("dummy");
    }

    @Test
    public void delete() {
        storage.delete(UUID_2);
        assertSize(2);
        assertGet(RESUME_1);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExists() {
        storage.delete("dummy");
    }

    @Test
    public void getAllSorted() {
        List<Resume> arr = storage.getAllSorted();
        List<Resume> expected = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
        Collections.sort(expected);  // repair sort
        assertEquals(expected, arr);
        assertEquals(3, arr.size());
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}