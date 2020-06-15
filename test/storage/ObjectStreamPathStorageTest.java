package storage;

import java.io.File;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {

    public ObjectStreamPathStorageTest() {
        super(new ObjectStreamPathStorage(new File(STORAGE_DIR)));
    }
}