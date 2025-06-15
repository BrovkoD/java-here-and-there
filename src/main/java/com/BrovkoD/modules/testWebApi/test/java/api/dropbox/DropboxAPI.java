package api.dropbox;

import api.GenericAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class DropboxAPI implements GenericAPI {

    private final HttpClient client;
    private final String ACCESS_TOKEN;

    public DropboxAPI(String ACCESS_TOKEN){
        this.ACCESS_TOKEN = ACCESS_TOKEN;
        client = HttpClient.newBuilder().build();
    }

    public void uploadFile(Path path){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://content.dropboxapi.com/2/files/upload"))
                    .header("Authorization", "Bearer " + ACCESS_TOKEN)
                    .header("Dropbox-API-Arg",
                            "{\"autorename\":false," +
                                    "\"mode\":\"add\"," +
                                    "\"mute\":false," +
                                    "\"path\":\"" + "/" + path + "\"," +
                                    "\"strict_conflict\":false}")
                    .header("Content-Type", "application/octet-stream")
                    .POST(HttpRequest.BodyPublishers.ofFile(path))
                    .build();

            client.send(request, HttpResponse.BodyHandlers.discarding());
        } catch (Exception e) {
            throw new RuntimeException(String.format("Unable to upload file: %s", e));
        }
    }

    public Optional<Path> downloadFile(Path mainFilePath, Path duplicateFilePath) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://content.dropboxapi.com/2/files/download"))
                    .header("Authorization", "Bearer " + ACCESS_TOKEN)
                    .header("Dropbox-API-Arg", "{\"path\":\"" + "/" + mainFilePath + "\"}")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Files.write(duplicateFilePath, response.body().getBytes());
                return Optional.of(duplicateFilePath);
            } else {
                return Optional.empty();
            }

        } catch (Exception e) {
            throw new RuntimeException(String.format("Unable to download file: %s", e));
        }
    }

    public Optional<String> getFileMetadata(Path path) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.dropboxapi.com/2/files/get_metadata"))
                    .header("Authorization", "Bearer " + ACCESS_TOKEN)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"include_deleted\":false," +
                            "\"include_has_explicit_shared_members\":false," +
                            "\"include_media_info\":false," +
                            "\"path\":\"" + "/" + path + "\"}"
                    )).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return Optional.of(response.body());

        } catch (Exception e) {
            throw new RuntimeException(String.format("Unable to get file metadata: %s", e));
        }
    }

    public void deleteFile(Path path) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.dropboxapi.com/2/files/delete_v2"))
                    .header("Authorization", "Bearer " + ACCESS_TOKEN)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"path\":\"" + "/" + path + "\"}"))
                    .build();

            client.send(request, HttpResponse.BodyHandlers.discarding());
        } catch (Exception e) {
            throw new RuntimeException(String.format("Unable to delete the file: %s", e));
        }
    }
}
