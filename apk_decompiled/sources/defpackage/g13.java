package defpackage;

import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class g13 {
    private int a;
    private float b;
    private int c;
    private Date d;
    private String e;
    private int f;
    private int g;
    private byte[] h;

    public g13(int i, int i2, int i3, Date date, String str, int i4, int i5, byte[] bArr) {
        this.a = i;
        this.b = i2 / 100.0f;
        this.c = i3;
        this.d = date;
        this.e = str;
        this.f = i4;
        this.g = i5;
        this.h = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TempCheckModel{timestamp=");
        sb.append(this.a);
        sb.append(", temperature=");
        sb.append(this.b);
        sb.append(", index=");
        sb.append(this.c);
        sb.append(", connectedDate=");
        sb.append(this.d);
        sb.append(", mac='");
        sb.append(this.e);
        sb.append('\'');
        sb.append(", heartRatePPI=");
        sb.append(this.f);
        sb.append(", riskStatus=");
        sb.append(this.g);
        sb.append(", extraDataLength=");
        byte[] bArr = this.h;
        sb.append(bArr != null ? bArr.length : 0);
        sb.append('}');
        return sb.toString();
    }
}
