package kotlin.uuid;

import defpackage.p31;
import defpackage.y70;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* JADX INFO: loaded from: classes4.dex */
final class UuidSerialized implements Externalizable {
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    private long leastSignificantBits;
    private long mostSignificantBits;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public UuidSerialized(long j, long j2) {
        this.mostSignificantBits = j;
        this.leastSignificantBits = j2;
    }

    private final Object readResolve() {
        return Uuid.Companion.a(this.mostSignificantBits, this.leastSignificantBits);
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        p31.f(objectInput, "input");
        this.mostSignificantBits = objectInput.readLong();
        this.leastSignificantBits = objectInput.readLong();
    }

    public final void setLeastSignificantBits(long j) {
        this.leastSignificantBits = j;
    }

    public final void setMostSignificantBits(long j) {
        this.mostSignificantBits = j;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        p31.f(objectOutput, "output");
        objectOutput.writeLong(this.mostSignificantBits);
        objectOutput.writeLong(this.leastSignificantBits);
    }

    public UuidSerialized() {
        this(0L, 0L);
    }
}
