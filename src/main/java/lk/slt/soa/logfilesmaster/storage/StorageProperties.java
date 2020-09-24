package lk.slt.soa.logfilesmaster.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "uploadFileDir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static interface StorageService {

        void init();

        void store(MultipartFile file);

        Stream<Path> loadAll();

        Path load(String filename);

        Resource loadAsResource(String filename);

        void deleteAll();

    }
}
