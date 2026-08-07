package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class i20 {
    private static final hd1 a = ld1.k(i20.class);
    public static int b = Integer.parseInt(System.getenv().getOrDefault("HTTP_CONNECT_TIMEOUT", "10000"));
    public static int c = Integer.parseInt(System.getenv().getOrDefault("HTTP_CONNECTION_REQUEST_TIMEOUT", "30000"));
    public static String d = System.getenv().getOrDefault("DASHSCOPE_API_VERSION", "v1");
    public static String e = System.getenv().getOrDefault("DASHSCOPE_API_REGION", "cn-beijing");
    public static String f = null;
    public static int g = Integer.parseInt(System.getenv().getOrDefault("MAX_CONNECTIONS_HTTP", "100"));
    public static int h = Integer.parseInt(System.getenv().getOrDefault("MAX_CONNECTIONS_PER_ROUTE_HTTP", "20"));
    public static String i = null;
    public static String j = System.getenv().getOrDefault("DASHSCOPE_HTTP_BASE_URL", "https://dashscope.aliyuncs.com/api/" + d);
    public static String k = System.getenv().getOrDefault("DASHSCOPE_WEBSOCKET_BASE_URL", uv2.a("wss://dashscope.aliyuncs.com/api-ws/%s/inference/", d));
    public static q10 l = null;

    static {
        a();
    }

    public static void a() {
    }
}
