package ru.ir.renamer;

public interface Replacer<T> {
    T replace(T in);

    final class NoReplacer<T> implements Replacer<T> {
        @Override
        public T replace(T in) {
            return in;
        }
    }
}
