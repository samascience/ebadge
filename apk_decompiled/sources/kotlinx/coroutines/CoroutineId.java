package kotlinx.coroutines;

import defpackage.p31;
import defpackage.y70;
import kotlin.coroutines.d;
import kotlin.text.i;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes4.dex */
@IgnoreJRERequirement
public final class CoroutineId extends kotlin.coroutines.a implements ThreadContextElement<String> {
    public static final Key Key = new Key(null);
    private final long id;

    public static final class Key implements d.c {
        public /* synthetic */ Key(y70 y70Var) {
            this();
        }

        private Key() {
        }
    }

    public CoroutineId(long j) {
        super(Key);
        this.id = j;
    }

    public static /* synthetic */ CoroutineId copy$default(CoroutineId coroutineId, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = coroutineId.id;
        }
        return coroutineId.copy(j);
    }

    public final long component1() {
        return this.id;
    }

    public final CoroutineId copy(long j) {
        return new CoroutineId(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CoroutineId) && this.id == ((CoroutineId) obj).id;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public String toString() {
        return "CoroutineId(" + this.id + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(d dVar, String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public String updateThreadContext(d dVar) {
        String name;
        CoroutineName coroutineName = (CoroutineName) dVar.get(CoroutineName.Key);
        if (coroutineName == null || (name = coroutineName.getName()) == null) {
            name = "coroutine";
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name2 = threadCurrentThread.getName();
        int iC0 = i.c0(name2, " @", 0, false, 6, null);
        if (iC0 < 0) {
            iC0 = name2.length();
        }
        StringBuilder sb = new StringBuilder(name.length() + iC0 + 10);
        String strSubstring = name2.substring(0, iC0);
        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append(" @");
        sb.append(name);
        sb.append('#');
        sb.append(this.id);
        String string = sb.toString();
        p31.e(string, "StringBuilder(capacity).…builderAction).toString()");
        threadCurrentThread.setName(string);
        return name2;
    }
}
