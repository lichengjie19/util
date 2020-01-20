package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


/**
 * @author licjd
 * @date 2020/1/15 11:27
 */
public class ConfTest {

    public static void main(String[] args) {
        try{
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://testcluster");
            conf.set("dfs.nameservices", "testcluster");
            conf.set("dfs.ha.namenodes.testcluster", "namenode1046, namenode945");
            conf.set("dfs.namenode.rpc-address.testcluster.namenode1046", "100.73.12.125:8020");
            conf.set("dfs.namenode.rpc-address.testcluster.namenode945", "100.73.12.126:8020");
//            conf.setBoolean(CommonConfigurationKeys.HADOOP_SECURITY_TOKEN_SERVICE_USE_IP, Boolean.parseBoolean("false"));
//            conf.set("dfs.client.failover.proxy.provider.testcluster", "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
//            conf.set("dfs.uri", "hdfs://testcluster:8020");
            conf.set("dfs.user", "licjd");
            FileSystem fs = FileSystem.get(conf);
            if (fs.exists(new Path("hdfs://testcluster/user/hive/warehouse/licjd_demo1"))){
                System.out.println("文件存在");
            }else{
                System.out.println("文件不存在");
            }
            fs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
