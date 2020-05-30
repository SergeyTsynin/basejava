package storage;

import excepton.StorageException;
import model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must be not null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void updateRoutine(Resume r, File file) {
        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO Error", file.getName(), e);
        }
    }

    @Override
    protected void saveRoutine(Resume r, File file) {
        try {
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO Error", file.getName(), e);
        }
    }

    @Override
    protected Resume getRoutine(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("IO Error", file.getName(), e);
        }
    }

    @Override
    protected void deleteRoutine(File file) {
        //noinspection ResultOfMethodCallIgnored
        file.delete();
    }

    @Override
    protected boolean isExists(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> doGetAll() {
        List<Resume> result = new ArrayList<>();
        for (File file : directory.listFiles()) {
            result.add(getRoutine(file));
        }
        return result;
    }

    @Override
    public void clear() {
        for (File file : directory.listFiles()) {
            if (file.isFile()) //noinspection ResultOfMethodCallIgnored
                file.delete();
        }
    }

    @Override
    public int size() {
        return directory.listFiles().length;
    }

    protected abstract void doWrite(Resume r, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;
}
