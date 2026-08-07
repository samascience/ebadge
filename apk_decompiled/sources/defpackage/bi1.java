package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class bi1 extends fy1 {
    public static final ContentValues c = new ContentValues();
    private final b b;

    public static final class a extends fy1.a {
        private final b.a b;

        public a(ContentResolver contentResolver, Uri uri) {
            super(new jd.b());
            b52.h(contentResolver, "Content resolver can't be null.");
            b52.h(uri, "Collection Uri can't be null.");
            b.a aVar = (b.a) this.a;
            this.b = aVar;
            aVar.e(contentResolver).d(uri).f(bi1.c);
        }

        public bi1 a() {
            return new bi1(this.b.c());
        }

        public a b(ContentValues contentValues) {
            b52.h(contentValues, "Content values can't be null.");
            this.b.f(contentValues);
            return this;
        }
    }

    static abstract class b extends fy1.b {

        static abstract class a extends fy1.b.a {
            a() {
            }

            abstract b c();

            abstract a d(Uri uri);

            abstract a e(ContentResolver contentResolver);

            abstract a f(ContentValues contentValues);
        }

        b() {
        }

        abstract Uri d();

        abstract ContentResolver e();

        abstract ContentValues f();
    }

    bi1(b bVar) {
        super(bVar);
        this.b = bVar;
    }

    public Uri d() {
        return this.b.d();
    }

    public ContentResolver e() {
        return this.b.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bi1) {
            return this.b.equals(((bi1) obj).b);
        }
        return false;
    }

    public ContentValues f() {
        return this.b.f();
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b.toString().replaceFirst("MediaStoreOutputOptionsInternal", "MediaStoreOutputOptions");
    }
}
