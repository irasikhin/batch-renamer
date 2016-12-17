package ru.ir.renamer;

import org.apache.commons.cli.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Launcher {

    public static void main(String... args) {
        //
        // java -jar renamer.jar -e (.*).peb $1.html.peb
        //
        try {
            Options options = new Options();
            options.addOption("e", "regexp", false, "Use regexp as parse engine");
            options.addOption("d", "directory", true, "Where are to find files");
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            Replacer<Path> replacer = new Replacer.NoReplacer<>();
            Finder<Path> finder = new Finder.NoFinder<>();
            if (cmd.hasOption("e")) {
                replacer = new PathReplacer(new RegExStringReplacer(cmd.getArgs()[0], cmd.getArgs()[1]));
                finder = new RegExFileFinder(Paths.get(cmd.getOptionValue("d", ".")), cmd.getArgs()[0]);
            }

            FileBatchRenamer renamer = new FileBatchRenamer(finder, replacer);
            renamer.rename();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
