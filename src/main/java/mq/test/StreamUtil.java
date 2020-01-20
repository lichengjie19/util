package mq.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 数据流工具类
 *
 * @author lihy
 */
public class StreamUtil {
    private static final Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    public static Object byteToObject(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            return null;
        }
        Object obj = null;
        ObjectInputStream oi = null;
        ByteArrayInputStream bi = null;
        try {
            bi = new ByteArrayInputStream(bytes);
            oi = new ObjectInputStream(bi);
            obj = oi.readObject();
        } catch (Exception e) {
            logger.error("数据转换异常!", e);
        } finally {
            if (bi != null) {
                try {
                    bi.close();
                } catch (Exception e) {
                    logger.error("流关闭异常", e);
                }
            }
            if (oi != null) {
                try {
                    oi.close();
                } catch (Exception e) {
                    logger.error("流关闭异常", e);
                }
            }
        }
        return obj;
    }

    public static byte[] objectToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = null;
        ObjectOutputStream oo = null;
        byte[] bytes = null;
        try {
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
        } catch (Exception e) {
            logger.error("数据转换异常!", e);
        } finally {
            if (bo != null) {
                try {
                    bo.close();
                } catch (Exception e) {
                    logger.error("流关闭异常", e);
                }
            }
            if (oo != null) {
                try {
                    oo.close();
                } catch (Exception e) {
                    logger.error("流关闭异常", e);
                }
            }
        }
        return bytes;
    }

}
