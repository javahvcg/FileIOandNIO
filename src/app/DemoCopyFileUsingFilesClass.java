package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.SysexMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anhquan12
 */
public class DemoCopyFileUsingFilesClass {

    public static void main(String[] args) throws IOException {
        Path oldFile = Paths.get("src/app/", "data1.txt");
        String txt = "To be or not to be? ";
        Path newFile = Paths.get("src/app/", "copy-data1.txt");
        try {
            Files.write(oldFile, txt.getBytes());
            Files.copy(oldFile, new FileOutputStream(newFile.toFile()));
            long start = System.nanoTime();
            long end = System.nanoTime();

            System.out.println("Time taken by Java Files Copy = " + (end - start));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
