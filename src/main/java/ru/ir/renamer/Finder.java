package ru.ir.renamer;

import java.util.stream.Stream;

public interface Finder<T> {
    Stream<T> find();

    final class NoFinder<T> implements Finder<T> {
        public Stream<T> find() {
            return Stream.empty();
        }
    }

}
