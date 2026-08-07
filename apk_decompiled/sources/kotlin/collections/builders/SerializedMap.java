package kotlin.collections.builders;

import defpackage.p31;
import defpackage.y70;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes4.dex */
final class SerializedMap implements Externalizable {
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public SerializedMap(Map<?, ?> map) {
        p31.f(map, "map");
        this.map = map;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        p31.f(objectInput, "input");
        byte b = objectInput.readByte();
        if (b != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b));
        }
        int i = objectInput.readInt();
        if (i < 0) {
            throw new InvalidObjectException("Illegal size value: " + i + '.');
        }
        Map mapB = u.b(i);
        for (int i2 = 0; i2 < i; i2++) {
            mapB.put(objectInput.readObject(), objectInput.readObject());
        }
        this.map = u.a(mapB);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        p31.f(objectOutput, "output");
        objectOutput.writeByte(0);
        objectOutput.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            objectOutput.writeObject(entry.getKey());
            objectOutput.writeObject(entry.getValue());
        }
    }

    public SerializedMap() {
        this(u.f());
    }
}
