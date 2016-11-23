package ru.ir.renamer;

import java.util.regex.Pattern;

public class RegExStringReplacer implements Replacer<String> {

    private final Pattern inPattern;

    private final String outPattern;

    public RegExStringReplacer(String inPattern, String outPattern) {
        this.inPattern = Pattern.compile(inPattern);
        this.outPattern = outPattern;
    }

    @Override
    public String replace(String in) {
        return inPattern.matcher(in).replaceAll(outPattern);
    }

}
