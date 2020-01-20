package other;

/**
 * @author licjd
 * @date 2019/11/10 10:57
 */
public class SystemTest {

    String str;

    public SystemTest() {
        super();
    }

    public static void main(String[] args) {
        //! System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.MAX_VALUE*123);
        System.out.println(new SystemTest().str);
    }

}
