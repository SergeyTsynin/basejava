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
        } catch (IOException e) {
            throw new StorageException("IO Error", file.getName(), e);
        }
        try {
            doUpdate(r, file);
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
        boolean result = file.delete();
        if (!result) {
            throw new StorageException("Can't delete", file.getName());
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
        return listOfFiles().length;
    }

    private File[] listOfFiles() {
        File[] result = directory.listFiles();
        if (result == null) {
            throw new StorageException(".listFiles was return null", null);
        }
        return result;
    }

    protected abstract void doWrite(Resume r, File file) throws IOException;

    protected abstract void doUpdate(Resume r, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;
}
/*
+ AbstractFileStorage
---------------------------------------------------
-- directory.listFiles() - делай проверку на null, если null, бросай StorageException
-- deleteRoutine - file.delete() - обрабатывай значение которое возвращает этот метод, если файл не удален, бросай StorageException
-- clear- удаляй при помощи метода deleteRoutine
  if (file.isFile()) - директория тоже является неким видом файла, ее тоже надо удалать
-- saveRoutine - замени doWrite на doUpdate и перенеси вызов этого метода за пределы блока try catch, нужно разделить
иксепшены которые можно получить в ходе виполнения метода.
-- size - дешевле будет получать размер у списка имен файлов .list()

 */