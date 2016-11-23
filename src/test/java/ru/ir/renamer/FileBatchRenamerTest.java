package ru.ir.renamer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileBatchRenamerTest {

    public void rename() throws IOException {
//        Path path = createTempFiles();
//        FileBatchRenamer renamer = new FileBatchRenamer("(.*).peb", "$1.html.peb", path.toAbsolutePath().toString());
//        renamer.rename();
    }

    private Path createTempFiles() throws IOException {
        Path path = Files.createTempDirectory("renamer-test");
        for (int i = 0; i < 5; i++) {
            Files.createTempFile(path, "renamer-test", ".peb");
        }
        return path;
    }

}