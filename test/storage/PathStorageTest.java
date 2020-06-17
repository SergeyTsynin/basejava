package storage;

import storage.serialization.ObjectStreamSerialization;

public class PathStorageTest extends AbstractStorageTest {

    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR, new ObjectStreamSerialization()));
    }
}