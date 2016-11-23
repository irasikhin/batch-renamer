package ru.ir.renamer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBatchRenamer implements BatchRenamer {

    private final Finder<Path> finder;

    private final Replacer<String> replacer;

    public FileBatchRenamer(Finder<Path> finder, Replacer<String> replacer) {
        this.finder = finder;
        this.replacer = replacer;
    }

    public void rename() {
        finder.find().forEach(f -> {
            try {
                Files.move(f, f.getParent().resolve(replacer.replace(f.getFileName().toString())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

}
