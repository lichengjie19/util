package interview;

/**
 * finally
 * @author licjd
 * @date 2019/9/25 9:27
 */
public class E {

    public static void main(String[] args){
        int a = 1;
        System.out.println(a);
        a = add(a);
        System.out.println(a);
    }

    public static int add(int a){
        try{
            a++;
            System.out.println(a);
            return a;
        }finally{
            a++;
            System.out.println(a);
        }
    }

}
