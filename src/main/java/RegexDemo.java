import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 一个字符串出现两个字符的匹配正则
 * @author licjd
 * @date 2019/9/5 14:33
 */
public class RegexDemo {

    public static void main(String[] args) throws Exception{
        String str1 = "Is is the cost of of gasoline going up up";
        String str2 = "Is is the cost cost of of gasoline going going up up";
        String str3 = "Is is  cost of of gasoline going up up";
        String str4 = "Is is the cost of of gasoline  up up";

        String regex = "(.*)(the)+(.*)(going)+(.*)";

        System.out.println(str1.matches(regex));
        System.out.println(str2.matches(regex));
        System.out.println(str3.matches(regex));
        System.out.println(str4.matches(regex));

    }

}
