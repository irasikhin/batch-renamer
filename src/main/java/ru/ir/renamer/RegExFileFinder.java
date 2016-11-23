package ru.ir.renamer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegExFileFinder implements Finder<Path> {

    private final Path path;

    private final Pattern pattern;

    public RegExFileFinder(Path path, String pattern) {
        this.path = path;
        this.pattern = Pattern.compile(pattern);
    }

    public Stream<Path> find() {
        try {
            return Files.find(path, Integer.MAX_VALUE, (file, attributes) -> pattern.matcher(file.getFileName().toString()).find());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
