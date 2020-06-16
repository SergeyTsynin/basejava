package storage;

import excepton.StorageException;
import model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private Path directory;

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must be not null");
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException(dir + " is not directory");
        }
        if (!Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not readable/writable");
        }
    }

    @Override
    public Path getSearchKey(String uuid) {
        return Paths.get(directory.toString(), uuid);
    }

    @Override
    protected void updateRoutine(Resume r, Path path) {
        try {
            doWrite(r, Files.newOutputStream(path));
        } catch (IOException e) {
            throw new StorageException("Can't write file " + path.toAbsolutePath(), path.getFileName().toString(), e);
        }
    }

    @Override
    protected void saveRoutine(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Can't create file " + path.toAbsolutePath(), path.getFileName().toString(), e);
        }
        updateRoutine(r, path);
    }

    @Override
    protected Resume getRoutine(Path path) {
        try {
            return doRead(Files.newInputStream(path));
        } catch (IOException e) {
            throw new StorageException("Can't read file ", path.getFileName().toString(), e);
        }
    }

    @Override
    protected void deleteRoutine(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Can't delete " + path.toAbsolutePath(), path.getFileName().toString(), e);
        }
    }

    @Override
    protected boolean isExists(Path path) {
        return Files.exists(path, LinkOption.NOFOLLOW_LINKS);
    }

    @Override
    protected List<Resume> doGetAll() {
        List<Resume> result = new ArrayList<>();
        listOfPaths().forEach(path -> result.add(getRoutine(path)));
        return result;
    }

    @Override
    public void clear() {
        listOfPaths().forEach(this::deleteRoutine);
    }

    @Override
    public int size() {
//        return 0;
        return (int) listOfPaths().count();
    }

    private Stream<Path> listOfPaths() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("paths list get error", null);
        }
    }
}
// TODO: 12.06.2020
// Реализовать ObjectStreamPathStorage (через java.nio.Path.Path) и добавить ObjectStreamPathStorageTest
// Сделать реализации Storage сохранения в файл через Path и Path с возможностью выбора стратегии сериализации
// (посмотрите на паттерн стратегия).
// Кроме сохранения через ObjectOutputStream/ObjectInputStream у нас будут еще несколько вариантов сериализации.
// Сделать тесты для тестирования сохранения через ObjectOutputStream/ObjectInputStream для Path и Path.