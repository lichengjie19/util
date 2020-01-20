package mq.test;

import java.io.Serializable;

/**
 * 操作日志表
 *
 * @author licjd
 * @date 2019/7/31 16:55
 */
public class TOptLog implements Serializable {

    private static final long serialVersionUID = 7454895762584638919L;

    /**
     * 日志跟踪ID
     */
    private String traceId;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 访问资源
     */
    private String visitAddr;

    /**
     * 访问表
     */
    private String visitTable;

    /**
     * 日志内容
     */
    private String logContent;

    /**
     * 操作人,如果是定时任务，操作人为：sys
     */
    private String optAcct;

    /**
     * 操作IP
     */
    private String optIp;

    /**
     * 创建时间
     */
    private String createTime;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getVisitAddr() {
        return visitAddr;
    }

    public void setVisitAddr(String visitAddr) {
        this.visitAddr = visitAddr;
    }

    public String getVisitTable() {
        return visitTable;
    }

    public void setVisitTable(String visitTable) {
        this.visitTable = visitTable;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getOptAcct() {
        return optAcct;
    }

    public void setOptAcct(String optAcct) {
        this.optAcct = optAcct;
    }

    public String getOptIp() {
        return optIp;
    }

    public void setOptIp(String optIp) {
        this.optIp = optIp;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
