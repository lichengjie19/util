package interview;

/**
 * 传值还是传引用
 * @author licjd
 * @date 2019/9/25 9:26
 */
public class C {

    public int value;
    public static void main(String[] args){
//
        C a = new C();
        a.value = 1;
        int b = 3;
//
        addFun(a,b);
//2,3
        System.out.println(a);
        System.out.println(b);
    }

    public static void addFun(C a, int b){
        a.value ++;
        b++;
    }
    public String toString(){
        return value+"";
    }

}
