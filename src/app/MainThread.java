/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhquan12
 */
public class MainThread {

    public static void main(String[] args) throws InterruptedException, IOException {
        File source = new File("/Desktop/sourcefile1.txt");
        File dest = new File("/Desktop/destfile1.txt");

        //copy file conventional way using Stream
        long start = System.currentTimeMillis();
        copyFileUsingStream(source, dest);
        System.out.println("Time taken by Stream Copy = " + (System.currentTimeMillis() - start));
    }

    private static void copyFileUsingStream(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;

        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {
            input.close();
            output.close();
        }
    }
}
