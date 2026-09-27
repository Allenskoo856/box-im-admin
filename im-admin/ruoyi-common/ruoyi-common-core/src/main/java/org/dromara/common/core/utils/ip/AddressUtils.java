package org.dromara.common.core.utils.ip;

import cn.hutool.core.net.NetUtil;
import cn.hutool.http.HtmlUtil;
import org.dromara.common.core.utils.StringUtils;
/**
 * 获取地址类
 *
 * @author Lion Li
 */
public class AddressUtils {

    private AddressUtils() {
    }

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AddressUtils.class);


    // 未知地址
    public static final String UNKNOWN = "XX XX";

    public static String getRealAddressByIP(String ip) {
        if (StringUtils.isBlank(ip)) {
            return UNKNOWN;
        }
        // 内网不查询
        ip = StringUtils.contains(ip, "0:0:0:0:0:0:0:1") ? "127.0.0.1" : HtmlUtil.cleanHtmlTag(ip);
        if (NetUtil.isInnerIP(ip)) {
            return "内网IP";
        }
        return RegionUtils.getCityInfo(ip);
    }
}
