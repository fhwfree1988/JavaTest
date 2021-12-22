package ir.Me.session_1.e06;

import ir.Me.session_1.e06.test_package.BaseTest;
import org.apache.log4j.Logger;

public class AccessModifierTest {
    final static Logger logger = Logger.getLogger(AccessModifierTest.class);

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.u2 = 1;
//        logger.info(t1.u);
    }
}

class Test1 extends BaseTest {
    private int z;
    int u2;

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getU() {
//        return u;
        return u2;
    }
}