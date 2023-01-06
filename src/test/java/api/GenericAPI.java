package api;

import java.nio.file.Path;
import java.util.Optional;

public interface GenericAPI {

    void uploadFile(Path path);

    Optional<Path> downloadFile(Path from, Path to);

    Optional<String> getFileMetadata(Path path);

    void deleteFile(Path path);
}
