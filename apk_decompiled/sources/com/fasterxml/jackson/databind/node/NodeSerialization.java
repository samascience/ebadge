package com.fasterxml.jackson.databind.node;

import defpackage.zo;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
class NodeSerialization implements Serializable, Externalizable {
    protected static final int LONGEST_EAGER_ALLOC = 100000;
    private static final long serialVersionUID = 1;
    public byte[] json;

    public NodeSerialization() {
    }

    private byte[] _read(ObjectInput objectInput, int i) throws IOException {
        if (i <= LONGEST_EAGER_ALLOC) {
            byte[] bArr = new byte[i];
            objectInput.readFully(bArr, 0, i);
            return bArr;
        }
        zo zoVar = new zo(LONGEST_EAGER_ALLOC);
        try {
            byte[] bArrK0 = zoVar.k0();
            while (true) {
                int i2 = 0;
                do {
                    int iMin = Math.min(bArrK0.length - i2, i);
                    objectInput.readFully(bArrK0, 0, iMin);
                    i -= iMin;
                    i2 += iMin;
                    if (i == 0) {
                        byte[] bArrC = zoVar.C(i2);
                        zoVar.close();
                        return bArrC;
                    }
                } while (i2 != bArrK0.length);
                bArrK0 = zoVar.D();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    zoVar.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static NodeSerialization from(Object obj) {
        try {
            return new NodeSerialization(a.e(obj));
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to JDK serialize `" + obj.getClass().getSimpleName() + "` value: " + e.getMessage(), e);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        this.json = _read(objectInput, objectInput.readInt());
    }

    protected Object readResolve() {
        try {
            return a.b(this.json);
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to JDK deserialize `JsonNode` value: " + e.getMessage(), e);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.json.length);
        objectOutput.write(this.json);
    }

    public NodeSerialization(byte[] bArr) {
        this.json = bArr;
    }
}
