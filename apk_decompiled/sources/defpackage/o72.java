package defpackage;

import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o72 {
    public static final UUID a;
    public static final UUID b;
    public static final UUID c;
    public static final UUID d;
    public static final UUID e;
    public static final UUID f;
    public static final UUID g;
    public static final UUID h;
    public static final UUID i;
    public static final UUID j;
    public static final UUID k;
    public static final UUID l;
    public static final UUID m;
    public static final UUID n;
    public static final UUID o;
    private static UUID p;

    static {
        UUID uuidFromString = UUID.fromString(tg3.m().l().e());
        a = uuidFromString;
        b = UUID.fromString("7E400002-B5A3-F393-E0A9-E50E24DCCA9D");
        c = UUID.fromString("7E400003-B5A3-F393-E0A9-E50E24DCCA9D");
        d = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB");
        e = UUID.fromString("7E400004-B5A3-F393-E0A9-E50E24DCCA9D");
        f = UUID.fromString("0000180a-0000-1000-8000-00805f9b34fb");
        g = UUID.fromString("00002a26-0000-1000-8000-00805f9b34fb");
        h = UUID.fromString("00002a28-0000-1000-8000-00805f9b34fb");
        i = UUID.fromString("0000180f-0000-1000-8000-00805f9b34fb");
        j = UUID.fromString("00002a19-0000-1000-8000-00805f9b34fb");
        k = UUID.fromString("2a2a-0000-1000-8000-00805f9b34fb");
        l = UUID.fromString("00010203-0405-0607-0809-0a0b0c0d1912");
        m = UUID.fromString("0000ffff-0000-1000-8000-00805f9b34fb");
        n = UUID.fromString("5833FF01-9B8B-5191-6142-22A4536EF123");
        o = UUID.fromString("0000ae00-0000-1000-8000-00805F9B34FB");
        p = uuidFromString;
    }

    public static final UUID a() {
        return p;
    }

    public static void b(UUID uuid) {
        p = uuid;
    }
}
