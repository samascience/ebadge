package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import defpackage.v9;
import defpackage.z42;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface c {

    public static final class a implements c {
        private final com.bumptech.glide.load.data.c a;
        private final v9 b;
        private final List c;

        a(InputStream inputStream, List list, v9 v9Var) {
            this.b = (v9) z42.d(v9Var);
            this.c = (List) z42.d(list);
            this.a = new com.bumptech.glide.load.data.c(inputStream, v9Var);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c
        public int a() {
            return com.bumptech.glide.load.a.b(this.c, this.a.a(), this.b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c
        public void c() {
            this.a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.e(this.c, this.a.a(), this.b);
        }
    }

    public static final class b implements c {
        private final v9 a;
        private final List b;
        private final ParcelFileDescriptorRewinder c;

        b(ParcelFileDescriptor parcelFileDescriptor, List list, v9 v9Var) {
            this.a = (v9) z42.d(v9Var);
            this.b = (List) z42.d(list);
            this.c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c
        public int a() {
            return com.bumptech.glide.load.a.a(this.b, this.c, this.a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c
        public void c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.d(this.b, this.c, this.a);
        }
    }

    int a();

    Bitmap b(BitmapFactory.Options options);

    void c();

    ImageHeaderParser.ImageType d();
}
