package com.github.damingerdai.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author gming001
 * @version 2022-07-06 17:20
 */
@AutoConfiguration
@ConditionalOnClass(MinioClient.class)
@EnableConfigurationProperties(MinioProperties.class)
public class MinioAutoConfiguration {

    private Logger logger = LoggerFactory.getLogger(MinioAutoConfiguration.class);

    private MinioProperties minioProperties;

    @Bean(name = "minioClient")
    public MinioClient minioClient() throws Exception {
        this.logger.debug("---------- load minio client ----------");
        MinioClient minioClient = MinioClient.builder()
                .endpoint(this.minioProperties.getEndpoint())
                .credentials(this.minioProperties.getAccess(), this.minioProperties.getSecret())
                .build();
        boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucket()).build());
        if (isExist) {
            logger.warn("---------- minio client bucket is existed ----------");
        } else {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(this.minioProperties.getBucket()).build());
            logger.debug("---------- minio client bucket is created ----------");
        }
        logger.debug("---------- minio client is loaded ----------");
        return minioClient;
    }

    public void setMinioProperties(MinioProperties minioProperties) {
        this.minioProperties = minioProperties;
    }
}
