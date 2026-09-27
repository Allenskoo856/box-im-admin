package org.dromara.common.obs.config;

import com.obs.services.ObsClient;
import com.obs.services.ObsConfiguration;
import org.dromara.common.obs.properties.ObsProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 华为云 OBS 客户端配置
 *
 * @author Blue
 * @version 1.0
 */
@Configuration
public class ObsClientConfig {

    @Bean(destroyMethod = "close")
    @ConditionalOnProperty(prefix = "obs", name = "endpoint")
    public ObsClient obsClient(ObsProperties obsProperties) {
        ObsConfiguration config = new ObsConfiguration();
        config.setEndPoint(obsProperties.getEndpoint());
        return new ObsClient(obsProperties.getAccessKey(), obsProperties.getSecretKey(), config);
    }
}