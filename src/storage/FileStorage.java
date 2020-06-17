package storage;

import excepton.StorageException;
import model.Resume;
import storage.serialization.StreamSerialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private File directory;
    private StreamSerialization serialization;

    FileStorage(String dir, StreamSerialization serialization) {
        directory = new File(dir);
        this.serialization = serialization;
        Objects.requireNonNull(directory, "directory must be not null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
    }

    @Override
    public File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void updateRoutine(Resume r, File file) {
        try {
            serialization.doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Can't write file " + file.getAbsolutePath(), file.getName(), e);
        }
    }

    @Override
    protected void saveRoutine(Resume r, File file) {
        try {
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Can't create file " + file.getAbsolutePath(), file.getName(), e);
        }
        updateRoutine(r, file);
    }

    @Override
    protected Resume getRoutine(File file) {
        try {
            return serialization.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Can't read file ", file.getName(), e);
        }
    }

    @Override
    protected void deleteRoutine(File file) {
        if (!file.delete()) {
            throw new StorageException("Can't delete " + file.getAbsolutePath(), file.getName());
        }
    }

    @Override
    protected boolean isExists(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> doGetAll() {
        List<Resume> result = new ArrayList<>();
        File[] files = listOfFiles();
        for (File file : files) {
            result.add(getRoutine(file));
        }
        return result;
    }

    @Override
    public void clear() {
        File[] files = listOfFiles();
        for (File file : files) {
            deleteRoutine(file);
        }
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if (list == null) {
            throw new StorageException("Directory read error", null);
        }
        return list.length;
    }

    private File[] listOfFiles() {
        File[] result = directory.listFiles();
        if (result == null) {
            throw new StorageException(".listFiles was return null", null);
        }
        return result;
    }
}
