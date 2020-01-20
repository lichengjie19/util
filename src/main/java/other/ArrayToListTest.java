package other;

import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为List, Arrays.asList()
 * 能够修改元素, 但是不能添加/移出/清空操作
 * 原因是该类型是Arrays.ArrayList
 * @author licjd
 * @date 2019/11/12 9:45
 */
public class ArrayToListTest {

    public static void main(String[] args) {
        String[] strArr = new String[3];
        strArr[0] = "one";
        strArr[1] = "two";
        strArr[2] = "three";

        List<String> stringList = Arrays.asList(strArr);
        // 修改转换后的集合, 成功地把第一个元素"one"改为"oneList"
        stringList.set(0, "oneList");
        // 在上面一步修改了转换为的list, array也相应的变化了
        System.out.println(strArr[0]);

        // 重点: 以下三个编译正确, 但都会抛出运行时异常
        stringList.add("four");
        stringList.remove(2);
        stringList.clear();
    }

}
