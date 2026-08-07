package defpackage;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class of0 implements Closeable {
    private final int a = 1179403647;
    private final FileChannel b;

    public of0(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.b = new FileInputStream(file).getChannel();
    }

    private long n(jf0 jf0Var, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            kf0 kf0VarB = jf0Var.b(j3);
            if (kf0VarB.a == 1) {
                long j4 = kf0VarB.c;
                if (j4 <= j2 && j2 <= kf0VarB.d + j4) {
                    return (j2 - j4) + kf0VarB.b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    protected short C(ByteBuffer byteBuffer, long j) throws IOException {
        y(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    protected int D(ByteBuffer byteBuffer, long j) throws IOException {
        y(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    protected long V(ByteBuffer byteBuffer, long j) throws IOException {
        y(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    protected String a0(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short sC = C(byteBuffer, j);
            if (sC == 0) {
                return sb.toString();
            }
            sb.append((char) sC);
            j = j2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }

    protected long e0(ByteBuffer byteBuffer, long j) throws IOException {
        y(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public jf0 u() throws IOException {
        this.b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (e0(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sC = C(byteBufferAllocate, 4L);
        boolean z = C(byteBufferAllocate, 5L) == 2;
        if (sC == 1) {
            return new mf0(z, this);
        }
        if (sC == 2) {
            return new nf0(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public List w() throws IOException {
        long j;
        if0 if0VarA;
        this.b.position(0L);
        ArrayList arrayList = new ArrayList();
        jf0 jf0VarU = u();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(jf0VarU.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = jf0VarU.f;
        int i = 0;
        if (j2 == 65535) {
            j2 = jf0VarU.c(0).a;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            kf0 kf0VarB = jf0VarU.b(j3);
            if (kf0VarB.a == 2) {
                j = kf0VarB.b;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j4 = 0;
        do {
            if0VarA = jf0VarU.a(j, i);
            long j5 = if0VarA.a;
            if (j5 == 1) {
                arrayList2.add(Long.valueOf(if0VarA.b));
            } else if (j5 == 5) {
                j4 = if0VarA.b;
            }
            i++;
        } while (if0VarA.a != 0);
        if (j4 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jN = n(jf0VarU, j2, j4);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(a0(byteBufferAllocate, ((Long) it.next()).longValue() + jN));
        }
        return arrayList;
    }

    protected void y(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int i2 = this.b.read(byteBuffer, j + j2);
            if (i2 == -1) {
                throw new EOFException();
            }
            j2 += (long) i2;
        }
        byteBuffer.position(0);
    }
}
