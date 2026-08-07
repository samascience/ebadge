package com.telink.ota.ble;

import com.tencent.connect.common.Constants;
import defpackage.ga;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class Command {
    public UUID a;
    public UUID b;
    public UUID c;
    public CommandType d;
    public byte[] e;
    public Object f;
    public int g;

    public enum CommandType {
        READ,
        READ_DESCRIPTOR,
        WRITE,
        WRITE_NO_RESPONSE,
        ENABLE_NOTIFY,
        DISABLE_NOTIFY
    }

    public interface a {
        void a(c cVar, Command command, Object obj);

        void b(c cVar, Command command, String str);

        boolean c(c cVar, Command command);
    }

    public Command() {
        this(null, null, CommandType.WRITE);
    }

    public static Command a() {
        return new Command();
    }

    public String toString() {
        byte[] bArr = this.e;
        return "{ tag : " + this.f + ", type : " + this.d + " CHARACTERISTIC_UUID :" + this.b.toString() + " data: " + (bArr != null ? ga.a(bArr, ",") : Constants.STR_EMPTY) + " delay :" + this.g + "}";
    }

    public Command(UUID uuid, UUID uuid2, CommandType commandType) {
        this(uuid, uuid2, commandType, null);
    }

    public Command(UUID uuid, UUID uuid2, CommandType commandType, byte[] bArr) {
        this(uuid, uuid2, commandType, bArr, null);
    }

    public Command(UUID uuid, UUID uuid2, CommandType commandType, byte[] bArr, Object obj) {
        this.a = uuid;
        this.b = uuid2;
        this.d = commandType;
        this.e = bArr;
        this.f = obj;
    }
}
