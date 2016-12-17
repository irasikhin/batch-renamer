package ru.ir.renamer;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathReplacer implements Replacer<Path> {

    private final Replacer<String> replacer;

    public PathReplacer(Replacer<String> replacer) {
        this.replacer = replacer;
    }

    @Override
    public Path replace(Path in) {
        try {
            return Files.move(in, in.getParent().resolve(replacer.replace(in.getFileName().toString())));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
