package com.fasterxml.jackson.core.io;

import defpackage.i71;
import defpackage.vm2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class SerializedString implements vm2, Serializable {
    private static final i71 JSON_ENCODER = i71.j();
    private static final long serialVersionUID = 1;
    protected transient String _jdkSerializeValue;
    protected char[] _quotedChars;
    protected byte[] _quotedUTF8Ref;
    protected byte[] _unquotedUTF8Ref;
    protected final String _value;

    public SerializedString(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this._value = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this._jdkSerializeValue = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this._value);
    }

    @Override // defpackage.vm2
    public int appendQuoted(char[] cArr, int i) {
        char[] cArrK = this._quotedChars;
        if (cArrK == null) {
            cArrK = JSON_ENCODER.k(this._value);
            this._quotedChars = cArrK;
        }
        int length = cArrK.length;
        if (i + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArrK, 0, cArr, i, length);
        return length;
    }

    @Override // defpackage.vm2
    public int appendQuotedUTF8(byte[] bArr, int i) {
        byte[] bArrL = this._quotedUTF8Ref;
        if (bArrL == null) {
            bArrL = JSON_ENCODER.l(this._value);
            this._quotedUTF8Ref = bArrL;
        }
        int length = bArrL.length;
        if (i + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArrL, 0, bArr, i, length);
        return length;
    }

    @Override // defpackage.vm2
    public int appendUnquoted(char[] cArr, int i) {
        String str = this._value;
        int length = str.length();
        if (i + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i);
        return length;
    }

    @Override // defpackage.vm2
    public int appendUnquotedUTF8(byte[] bArr, int i) {
        byte[] bArrI = this._unquotedUTF8Ref;
        if (bArrI == null) {
            bArrI = JSON_ENCODER.i(this._value);
            this._unquotedUTF8Ref = bArrI;
        }
        int length = bArrI.length;
        if (i + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArrI, 0, bArr, i, length);
        return length;
    }

    @Override // defpackage.vm2
    public final char[] asQuotedChars() {
        char[] cArr = this._quotedChars;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrK = JSON_ENCODER.k(this._value);
        this._quotedChars = cArrK;
        return cArrK;
    }

    @Override // defpackage.vm2
    public final byte[] asQuotedUTF8() {
        byte[] bArr = this._quotedUTF8Ref;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArrL = JSON_ENCODER.l(this._value);
        this._quotedUTF8Ref = bArrL;
        return bArrL;
    }

    @Override // defpackage.vm2
    public final byte[] asUnquotedUTF8() {
        byte[] bArr = this._unquotedUTF8Ref;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArrI = JSON_ENCODER.i(this._value);
        this._unquotedUTF8Ref = bArrI;
        return bArrI;
    }

    public final int charLength() {
        return this._value.length();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this._value.equals(((SerializedString) obj)._value);
    }

    @Override // defpackage.vm2
    public final String getValue() {
        return this._value;
    }

    public final int hashCode() {
        return this._value.hashCode();
    }

    public int putQuotedUTF8(ByteBuffer byteBuffer) {
        byte[] bArrL = this._quotedUTF8Ref;
        if (bArrL == null) {
            bArrL = JSON_ENCODER.l(this._value);
            this._quotedUTF8Ref = bArrL;
        }
        int length = bArrL.length;
        if (length > byteBuffer.remaining()) {
            return -1;
        }
        byteBuffer.put(bArrL, 0, length);
        return length;
    }

    public int putUnquotedUTF8(ByteBuffer byteBuffer) {
        byte[] bArrI = this._unquotedUTF8Ref;
        if (bArrI == null) {
            bArrI = JSON_ENCODER.i(this._value);
            this._unquotedUTF8Ref = bArrI;
        }
        int length = bArrI.length;
        if (length > byteBuffer.remaining()) {
            return -1;
        }
        byteBuffer.put(bArrI, 0, length);
        return length;
    }

    protected Object readResolve() {
        return new SerializedString(this._jdkSerializeValue);
    }

    public final String toString() {
        return this._value;
    }

    public int writeQuotedUTF8(OutputStream outputStream) throws IOException {
        byte[] bArrL = this._quotedUTF8Ref;
        if (bArrL == null) {
            bArrL = JSON_ENCODER.l(this._value);
            this._quotedUTF8Ref = bArrL;
        }
        int length = bArrL.length;
        outputStream.write(bArrL, 0, length);
        return length;
    }

    public int writeUnquotedUTF8(OutputStream outputStream) throws IOException {
        byte[] bArrI = this._unquotedUTF8Ref;
        if (bArrI == null) {
            bArrI = JSON_ENCODER.i(this._value);
            this._unquotedUTF8Ref = bArrI;
        }
        int length = bArrI.length;
        outputStream.write(bArrI, 0, length);
        return length;
    }
}
