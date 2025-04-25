package com.yupi.yuoj.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Tencent Cloud Object Storage Client
 */
@Configuration
@ConfigurationProperties(prefix = "cos.client")
@Data
public class CosClientConfig {

    /**
     * accessKey
     */
    private String accessKey;

    /**
     * secretKey
     */
    private String secretKey;

    /**
     * district
     */
    private String region;

    /**
     * barrel name
     */
    private String bucket;

    @Bean
    public COSClient cosClient() {
        // Initialise user identity information (secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        // Generate cos client
        return new COSClient(cred, clientConfig);
    }
}