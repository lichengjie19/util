package other;


import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * 合并CSV
 * 参考自:
 * java实践：02_读写CSV文件: https://www.jianshu.com/p/31e71f1296f9
 * 关于CSV文件的读写问题（特别是有双引号和逗号的情况）(转载): https://blog.csdn.net/keplerpig/article/details/80736449
 * java 循环读取指定文件夹下所有文件: https://blog.csdn.net/qq_39569480/article/details/93980313
 * @author licjd
 * @date 2019/12/16 20:21
 */
public class CSVTest {

    //容器：对象少的时候，直接把对象列出来；当对象很多的时候，要用一个容器装起来打包
    public static ArrayList<String[]> csvFileList = new ArrayList<>();

    public static void readCSV(String csvFilePath) {
        //try{业务代码}catch(Exception e){如果做业务的过程中出了错，的异常处理逻辑}
        try {
            // 这个不用背，只要看得懂会用就行。创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
            CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("GB18030"));
            // 跳过表头 如果需要表头的话，这句可以忽略
            reader.readHeaders();
            // 逐行读入除表头的数据
            //boolean变量：真假true或者false
            while (reader.readRecord()) {
                // System.out.println(reader.getRawRecord());
                //将一行的字符串按照“，”逗号分成多列，存放到String[]数组中
                //再将这个string[]放到list容器中存起来
                String line = reader.getRawRecord();
                if (line.contains("凭证号") && line.contains("本方账号"))
                    continue;
                //双引号内的逗号不分割  双引号外的逗号进行分割
                String[] strArr = line.trim().split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)",-1);
                // 数组内每个字符串的去除
                for (int i = 0; i < strArr.length; i++) {
                    strArr[i] = strArr[i].replace(",", "").replace("\"", "");
                }
//                System.out.println(Arrays.toString(strArr));

                csvFileList.add(strArr);
//                writeCSV("D:\\data\\merge\\20181010~20190331\\demo.scv", strArr);
            }
            //数据取完了，关闭文件
            reader.close();
            System.out.println("--------" + csvFilePath + "文件已经读完--------");

//            // 遍历读取的CSV文件
//            //for是一个整数次的循环，三个参数：最小值，最大值，增量，取个变量名存放每次循环的序列值
//            for (int row = 0; row < csvFileList.size(); row++) {
//                // 取得第row行第0列的数据
//                String cell = csvFileList.get(row)[0];
//                System.out.println("------------>"+cell);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeCSV(String csvFilePath) {
        try {
            // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);
            CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));
            // 写表头
            String[] csvHeaders = {"凭证号", "本方账号", "对方账号", "交易时间", "借贷标识", "借方发生额", "贷方发生额", "对方行号", "摘要", "用途", "对方单位名称", "余额", "个性化信息"};
            csvWriter.writeRecord(csvHeaders);
            // 写内容
//            for (int i = 0; i < csvFileList.size(); i++) {
//                String[] csvContent = { i + "000000", "StemQ", "1" + i };
            for (String[] csvContent: csvFileList) {
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();
            System.out.println("--------CSV文件已经写入--------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<File> getFiles(String path) {
        File root = new File(path);
        List<File> files = new ArrayList<>();
        if(!root.isDirectory()){
            files.add(root);
        }else{
            File[] subFiles = root.listFiles();
            for(File f : subFiles){
                files.addAll(getFiles(f.getAbsolutePath()));
            }
        }
        return files;
    }

    public static void main(String[] args) {
//        Map<String,String> map=new HashMap<>();
//        HashMapmap.put("student", "D:\\data\\merge\\20181010~20190331\\工商银行201903.csv");
        // 定义一个CSV路径
//        String csvFilePath = map.get("student");

//        List<File> files = getFiles("D:\\data\\merge\\20180401~20180630");
//        List<File> files = getFiles("D:\\data\\merge\\20180701~20180930");
//        List<File> files = getFiles("D:\\data\\merge\\20181010~20190331");
//        for (File file: files) {
            String csvFilePath = "D:\\data\\工商银行20180717.csv";
//            System.out.println(csvFilePath);
            if(csvFilePath =="" || csvFilePath == null){
                System.out.println("路径不能为空！");
            }else if(!csvFilePath.endsWith(".csv")){
                System.out.println("必须是.csv文件路径");
            }else{
                //JavaCSV.writeCSV(csvFilePath);
                CSVTest.readCSV(csvFilePath);
            }
//        }
        CSVTest.writeCSV("D:\\data\\20180717.txt");

    }


}
