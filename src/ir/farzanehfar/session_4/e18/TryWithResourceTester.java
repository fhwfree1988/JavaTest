package ir.farzanehfar.session_4.e18;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TryWithResourceTester {
    final static Logger logger = Logger.getLogger(TryWithResourceTester.class);

    public static void main(String[] args) {
        try (PrintWriter pw = new
                PrintWriter(new BufferedWriter(new FileWriter("d:\\test.txt")))) {
            pw.write("hello world!");
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
