package ir.Me.session_2.e12;

import org.apache.log4j.Logger;

public class FinalTester extends BaseFinal {
    final static Logger logger = Logger.getLogger(FinalTester.class);
    
    @Override
    void showMessage() {
        logger.info("message");
    }
}

//final class BaseFinal {
class BaseFinal {
    final static Logger logger = Logger.getLogger(BaseFinal.class);
    
    BaseFinal() {
        x = 0;
    }

    //    final int x;
    int x;

    //    final void showMessage() {
    void showMessage() {
        logger.info("message");
        x = 2;
    }
}