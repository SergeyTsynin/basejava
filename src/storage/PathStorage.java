package storage;

import excepton.StorageException;
import model.Resume;
import storage.serialization.ObjectStreamSerialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;
    private ObjectStreamSerialization serialization;

    PathStorage(String dir, ObjectStreamSerialization serialization) {
        directory = Paths.get(dir);
        this.serialization = serialization;
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
        return directory.resolve(uuid);
    }

    @Override
    protected void updateRoutine(Resume r, Path path) {
        try {
            serialization.doWrite(r, new BufferedOutputStream(Files.newOutputStream(path)));
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
            return serialization.doRead(new BufferedInputStream(Files.newInputStream(path)));
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
        return streamOfPaths().map(this::getRoutine).collect(Collectors.toList());
    }

    @Override
    public void clear() {
        streamOfPaths().forEach(this::deleteRoutine);
    }

    @Override
    public int size() {
        return (int) streamOfPaths().count();
    }

    private Stream<Path> streamOfPaths() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("paths list get error", null);
        }
    }
}
