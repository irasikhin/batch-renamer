package ru.ir.renamer;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegExStringReplacerTest {

    @Test
    public void replace() {
        Replacer replacer = new RegExStringReplacer("(.*).peb", "$1.html.peb");
        MatcherAssert.assertThat(replacer.replace("index.peb"), equalTo("index.html.peb"));
    }

}