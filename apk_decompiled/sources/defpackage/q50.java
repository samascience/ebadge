package defpackage;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class q50 {
    public static void a(ow2 ow2Var) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursorW = ow2Var.W("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorW.moveToNext()) {
            try {
                arrayList.add(cursorW.getString(0));
            } catch (Throwable th) {
                cursorW.close();
                throw th;
            }
        }
        cursorW.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                ow2Var.e("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static Cursor b(RoomDatabase roomDatabase, rw2 rw2Var, boolean z, CancellationSignal cancellationSignal) {
        Cursor cursorQuery = roomDatabase.query(rw2Var, cancellationSignal);
        if (!z || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? i50.a(abstractWindowedCursor) : cursorQuery;
    }

    public static int c(File file) throws IOException {
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i = byteBufferAllocate.getInt();
            channel.close();
            return i;
        } catch (Throwable th) {
            if (0 != 0) {
                abstractInterruptibleChannel.close();
            }
            throw th;
        }
    }
}
