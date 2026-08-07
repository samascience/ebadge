package com.baji.protocol.model;

/* JADX INFO: loaded from: classes.dex */
public final class ProtocolConstants {
    public static final long CONNECTION_TIMEOUT_MS = 10000;
    public static final long DEFAULT_TIMEOUT_MS = 5000;
    public static final ProtocolConstants INSTANCE = new ProtocolConstants();
    public static final int MAX_CHUNK_SIZE = 200;
    public static final int MAX_FILE_SIZE = 10485760;
    public static final int MAX_PACKET_SIZE = 512;
    public static final int MAX_PAYLOAD_SIZE = 509;
    public static final int MAX_RETRY_COUNT = 3;
    public static final int PACKET_HEADER_SIZE = 3;
    public static final byte PACKET_START_MARKER = -51;
    public static final byte PRODUCT_ID = 37;
    public static final int PROTOCOL_VERSION_MAJOR = 1;
    public static final int PROTOCOL_VERSION_MINOR = 0;
    public static final String PROTOCOL_VERSION_STRING = "v1.0";
    public static final long RETRY_DELAY_MS = 1000;
    public static final long TRANSFER_TIMEOUT_MS = 30000;

    private ProtocolConstants() {
    }
}
