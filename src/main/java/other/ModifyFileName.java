package other;

import java.io.File;
import java.util.List;

/**
 * 修改文件名
 * @author licjd
 * @date 2019/12/17 15:31
 */
public class ModifyFileName {

    public static void main(String[] args) {
        List<File> files = CSVTest.getFiles("D:\\上报历史数据\\20191127-支付结算合规监管数据-九派支付");
        for (File file:
             files) {
//            System.out.println(file.getName());
            String fileName = file.getName();
            String newFileName = fileName.replace("TXT.rar", "ZIP");
            System.out.println(file.getParent() + "\\" + newFileName);
            file.renameTo(new File(file.getParent() + "\\" + newFileName));
        }
    }

}
