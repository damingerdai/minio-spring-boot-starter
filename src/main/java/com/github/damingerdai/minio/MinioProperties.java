package com.github.damingerdai.minio;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author gming001
 * @version 2022-07-06 18:10
 */
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private String endpoint;

    private String access;

    private String secret;

    private String bucket;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
