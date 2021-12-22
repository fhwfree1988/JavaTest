package ir.Me.session_3.e15;

import org.apache.log4j.Logger;

public class AbstractTest {
    public static void main(String[] args) {
//        BaseAbstract ba = new BaseAbstract();

        BaseAbstract ba = new ChildAbstract();
        ba.getMessage();
    }
}

class ChildAbstract extends BaseAbstract {
    final static Logger logger = Logger.getLogger(ChildAbstract.class);

    @Override
    public void getMessage() {
        logger.info(getX());
    }
}

abstract class BaseAbstract {
    public BaseAbstract() {
        x = 12;
    }

    public abstract void getMessage();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int x;
}