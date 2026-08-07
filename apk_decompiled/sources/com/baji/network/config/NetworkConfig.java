package com.baji.network.config;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkConfig {
    public static final String DEFAULT_ACCEPT = "application/json";
    public static final String DEFAULT_BASE_URL = "https://api.legend.smartwatch.com/";
    public static final long DEFAULT_CACHE_MAX_AGE = 604800;
    public static final long DEFAULT_CACHE_SIZE = 10485760;
    public static final long DEFAULT_CONNECT_TIMEOUT = 30000;
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final boolean DEFAULT_LOG_ENABLED = true;
    public static final String DEFAULT_LOG_LEVEL = "INFO";
    public static final long DEFAULT_MAX_FILE_SIZE = 104857600;
    public static final long DEFAULT_READ_TIMEOUT = 30000;
    public static final int DEFAULT_RETRY_COUNT = 3;
    public static final long DEFAULT_RETRY_DELAY = 1000;
    public static final long DEFAULT_UPLOAD_CHUNK_SIZE = 8192;
    public static final String DEFAULT_USER_AGENT = "BajiNetwork/1.0";
    public static final long DEFAULT_WRITE_TIMEOUT = 30000;
    public static final NetworkConfig INSTANCE = new NetworkConfig();

    private NetworkConfig() {
    }
}
