package interview;

/**
 * 是否可以编译通过
 * 方法签名 = 方法名 + 参数
 * ！与方法返回值的类型无关
 * @author licjd
 * @date 2019/9/25 9:09
 */
public class A {

    public int add (int a, int b) {
        return a + b;
    }

//    public String add (int a, int b) {
//        return a + b + "";
//    }

//    public int add (String a, String b) {
//        int a1 = Integer.valueOf(a);
//        int a2 = Integer.valueOf(b);
//        return a1 + a2;
//    }

    public String add (String a, String b) {
        int a1 = Integer.valueOf(a);
        int a2 = Integer.valueOf(b);
        return a1 + a2 + "";
    }

}
