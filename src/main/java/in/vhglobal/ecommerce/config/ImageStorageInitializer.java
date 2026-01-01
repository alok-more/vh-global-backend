package in.vhglobal.ecommerce.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Component
@RequiredArgsConstructor
public class ImageStorageInitializer {

    private final StorageProperties storageProperties;

    @PostConstruct
    public void init() throws IOException {
        Path imagePath = Paths.get(storageProperties.getImagePath());

        Files.createDirectories(imagePath);

        log.info("✅ Image storage directory ready: {}", imagePath.toAbsolutePath());
    }
}
