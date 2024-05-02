package edu.iu.habahram.databsedemo.repository;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Repository
public class OrderFileRepository {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "db.txt";

    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

}

