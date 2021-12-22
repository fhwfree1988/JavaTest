package ir.Me.session_4.e17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ThrowsTest implements BaseThrows {
    public static void main(String[] args) {
        ThrowsTest test = new ThrowsTest();
        try {
            test.readIntFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
//    public int readIntFromFile() throws Exception {
    public int readIntFromFile() throws FileNotFoundException {
        Scanner consoleScanner = new Scanner(new File("integer.txt"));
        return consoleScanner.nextInt();
    }
}


interface BaseThrows {
    int readIntFromFile() throws IOException, IllegalArgumentException;
}