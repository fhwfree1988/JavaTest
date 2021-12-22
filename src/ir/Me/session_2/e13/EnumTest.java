package ir.Me.session_2.e13;

import org.apache.log4j.Logger;

//public class EnumTest extends testEnum {
public class EnumTest {
    final static Logger logger = Logger.getLogger(EnumTest.class);

    public static void main(String[] args) {
        TestEnum t1 = TestEnum.e1;
        TestEnum t2 = TestEnum.e1;

        logger.info(t1 == t2);

        for (TestEnum t : TestEnum.values()) {
            logger.info("enum instance: " + t + ", s: " + t.getS());
        }
    }
}

//enum TestEnum extends Object {
enum TestEnum {
    e1("s1"), e2("s2");

    TestEnum(String s) {
        this.s = s;
    }

    private String s;

    public String getS() {
        return s;
    }
}