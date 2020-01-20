package other;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author licjd
 * @date 2019/12/17 14:27
 */
public class ZIPFiles {

    /**
     * 递归压缩文件
     * @param output ZipOutputStream 对象流
     * @param file 压缩的目标文件流
     * @param childPath 条目目录
     */
    private static void zip(ZipOutputStream output,File file,String childPath){
        FileInputStream input = null;
        try {
            // 文件为目录
            if (file.isDirectory()) {
                // 得到当前目录里面的文件列表
                File list[] = file.listFiles();
                childPath = childPath + (childPath.length() == 0 ? "" : "/")
                        + file.getName();
                // 循环递归压缩每个文件
                for (File f : list) {
                    zip(output, f, childPath);
                }
            } else {
                // 压缩文件
                childPath = (childPath.length() == 0 ? "" : childPath + "/")
                        + file.getName();
                output.putNextEntry(new ZipEntry(childPath));
                input = new FileInputStream(file);
                int readLen = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((readLen = input.read(buffer, 0, 1024 * 8)) != -1) {
                    output.write(buffer, 0, readLen);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭流
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    /**
     * 压缩文件（文件夹）
     * @param path 目标文件流
     * @param format zip 格式 | rar 格式
     * @throws Exception
     */
    public static String zipFile(File path, String format) throws Exception {
        String generatePath = "";
        if( path.isDirectory() ){
            generatePath = path.getParent().endsWith("/") == false ? path.getParent() + File.separator + path.getName() + "." + format: path.getParent() + path.getName() + "." + format;
        }else {
            generatePath = path.getParent().endsWith("/") == false ? path.getParent() + File.separator : path.getParent();
            generatePath += path.getName().substring(0,path.getName().lastIndexOf(".")) + "." + format;
        }
        // 输出流
        FileOutputStream outputStream = new FileOutputStream( generatePath );
        // 压缩输出流
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(outputStream));
        zip(out, path,"");
        out.flush();
        out.close();

        return generatePath;
    }

    // 使用例子
    public static void main(String[] args) {

        String path = "D:\\data\\test";
        String format = "zip";
        try {
            System.out.println(zipFile(new File(path),format));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

}
