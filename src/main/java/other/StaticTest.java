package other;

/**
 * @author licjd
 * @date 2019/11/9 18:23
 */
public class StaticTest {

    static Integer i = 47;

    public static void main(String[] args) {
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        System.out.println(st1.i.hashCode());
        System.out.println(st2.i.hashCode());
        System.out.println(StaticTest.i.hashCode());
    }

}
