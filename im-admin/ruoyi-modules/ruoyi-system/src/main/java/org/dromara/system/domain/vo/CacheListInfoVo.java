package org.dromara.system.domain.vo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 缓存监控列表信息
 *
 * @author Michelle.Chung
 */
public class CacheListInfoVo {

    private Properties info;

    private Long dbSize;

    private List<Map<String, String>> commandStats;


    public CacheListInfoVo() {
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    public Long getDbSize() {
        return dbSize;
    }

    public void setDbSize(Long dbSize) {
        this.dbSize = dbSize;
    }

    public List<Map<String, String>> getCommandStats() {
        return commandStats;
    }

    public void setCommandStats(List<Map<String, String>> commandStats) {
        this.commandStats = commandStats;
    }
}
