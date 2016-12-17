package ru.ir.renamer;

import java.nio.file.Path;

public class FileBatchRenamer implements BatchRenamer {

    private final Finder<Path> finder;

    private final Replacer<Path> replacer;

    public FileBatchRenamer(Finder<Path> finder, Replacer<Path> replacer) {
        this.finder = finder;
        this.replacer = replacer;
    }

    public void rename() {
        finder.find().forEach(replacer::replace);
    }

}
