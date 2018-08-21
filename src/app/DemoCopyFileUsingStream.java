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
public class DemoCopyFileUsingStream {

    public void writeData() throws IOException {
        OutputStream os = null;
        String path = "src//app//source_file.txt";
        String path2 = "src//app//copy-source_file.txt";
        File f = new File(path);
        File f2 = new File(path2);
        try {
            os = new FileOutputStream(f);
            String str = "“This life is what you make it. No matter what, you're going to mess up sometimes, it's a universal truth. But the good part is you get to decide how you're going to mess it up. Girls will be your friends - they'll act like it anyway. But just remember, some come, some go. The ones that stay with you through everything - they're your true best friends. Don't let go of them. Also remember, sisters make the best friends in the world. As for lovers, well, they'll come and go too. And baby, I hate to say it, most of them - actually pretty much all of them are going to break your heart, but you can't give up because if you give up, you'll never find your soulmate. You'll never find that half who makes you whole and that goes for everything. Just because you fail once, doesn't mean you're gonna fail at everything. Keep trying, hold on, and always, always, always believe in yourself, because if you don't, then who will, sweetie? So keep your head high, keep your chin up, and most importantly, keep smiling, because life's a beautiful thing and there's so much to smile about.” \n"
                    + "― Marilyn Monroe";
            os.write(str.getBytes());
            System.out.println("Write data success !");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoCopyFileUsingStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                os.flush();
                os.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void copyFileUsingStream(File f, File f2)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;

        try {
            input = new FileInputStream(f);
            output = new FileOutputStream(f2);

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

    public static void main(String[] args) throws IOException {
        DemoCopyFileUsingStream demo = new DemoCopyFileUsingStream();
        demo.writeData();
        String path = "src//app//source_file.txt";
        String path2 = "src//app//copy-source_file.txt";
        File f = new File(path);
        File f2 = new File(path2);
        long start = System.nanoTime();
        long end;
        copyFileUsingStream(f, f2);
        System.out.println("Time taken by Stream Copy = " + (System.nanoTime() - start));
    }
}
