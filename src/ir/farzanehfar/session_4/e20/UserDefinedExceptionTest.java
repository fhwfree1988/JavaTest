package ir.farzanehfar.session_4.e20;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserDefinedExceptionTest {
    final static Logger logger = Logger.getLogger(UserDefinedExceptionTest.class);
    
    public static void main(String[] args) {
        UserDefinedExceptionTest test = new UserDefinedExceptionTest();
        test.f();
    }

    public void f() {
        Scanner consoleScanner = null;
        try {
            consoleScanner = new Scanner(new File("integer.txt"));
            logger.info(consoleScanner.nextInt());
        } catch (FileNotFoundException e) {
            throw new UserException("Exception happend!");
        }
    }
}


class UserException extends RuntimeException {
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }
}