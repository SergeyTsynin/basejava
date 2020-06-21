package storage;

import excepton.StorageException;
import model.Resume;
import storage.serialization.StreamSerialization;

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
    private StreamSerialization serialization;

    PathStorage(String dir, StreamSerialization serialization) {
        Objects.requireNonNull(dir, "directory must be not null");
        directory = Paths.get(dir);
        this.serialization = serialization;
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
            throw new StorageException("Can't write file " + path.toAbsolutePath(), getFileName(path), e);
        }
    }

    @Override
    protected void saveRoutine(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Can't create file " + path.toAbsolutePath(), getFileName(path), e);
        }
        updateRoutine(r, path);
    }

    @Override
    protected Resume getRoutine(Path path) {
        try {
            return serialization.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Can't read file " + path.toAbsolutePath(), getFileName(path), e);
        }
    }

    @Override
    protected void deleteRoutine(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Can't delete " + path.toAbsolutePath(), getFileName(path), e);
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

    private String getFileName(Path path) {
        return path.getFileName().toString();
    }
}
