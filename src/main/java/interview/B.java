package interview;

/**
 * @author licjd
 * @date 2019/9/25 9:15
 */
public class B {

    public static String add(Object a, Object b) {
        return "S"+a.toString() + b.toString();
    }

    public static String add(int a, int b) {
        return "I"+(a+b);
    }

//    public static String add(Integer a, Integer b) {
//        return "I"+(a+b);
//    }

    public static void main(String[] args){
        int a = 1;
        int b = 2;
        Object c = 3;
        Object d = 4;
        Integer e = 5;
        Integer f = 6;
        System.out.println(add(a,b));
        System.out.println(add(c,d));
        System.out.println(add(e,f));
        System.out.println(add(a,c));
//        System.out.println(add(a,e));
    }

}
