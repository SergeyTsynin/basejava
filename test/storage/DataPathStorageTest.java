package storage;

import storage.serialization.DataStreamSerialization;

public class DataPathStorageTest extends AbstractStorageTest {

    public DataPathStorageTest() {
        super(new PathStorage(STORAGE_DIR, new DataStreamSerialization()));
    }
}