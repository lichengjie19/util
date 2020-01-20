package interview;

/**
 * 交换
 * 传值还是传引用？？
 * @author licjd
 * @date 2019/9/25 9:28
 */
public class D {

    public int value;

    public D(int value) {
        this.value = value;
    }
    public static void main(String[] args) throws Exception{
        D a1 = new D(1);
        D b1 = new D(2);
        Integer a2 = 1;
        Integer b2 = 2;
        swop(a1,b1);
        swop(a2,b2);
        System.out.println(String.format("a1 = %s, b1 = %s",a1,b1));//交换a1,b1的值 , a1 =
        System.out.println(String.format("a2 = %s, b2 = %s",a2,b2));//交换a1,b1的值 a1 = 2
    }

    public static void swop(Integer a, Integer b) throws Exception{
        a=a^b;
        b =a^b;
        a = a^b;
    }

    public static void swop(D a, D b) throws Exception{
        D c1 = new D(a.value);
        a.value = b.value;
        b.value = c1.value;
    }
    public String toString(){
        return value + "";
    }
}
