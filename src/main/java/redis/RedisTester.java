package redis;

import redis.clients.jedis.Jedis;

/**
 * https://www.jianshu.com/p/56999f2b8e3b
 * Redis的写入性能 测试
 * @author licjd
 * @date 2020/2/14 17:55
 */
public class RedisTester {

    public static void main(String[] args) {
        Jedis jedis =  new Jedis("localhost", 6379, 100000);
        int i = 0;
        // 开始毫秒数
        long start = System.currentTimeMillis();
        try {
            while (true) {
                long end = System.currentTimeMillis();
                // 当大于等于1000毫秒 (一秒) 时,结束操作
                if (end - start >= 1000) {
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        } finally {
            // 关闭连接
            jedis.close();
        }
        // 打印1秒内对Redis的操作次数
        System.out.println("Redis每秒操作: " + i + "次. ");
    }

}
