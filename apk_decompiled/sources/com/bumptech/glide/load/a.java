package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import defpackage.v9;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bumptech.glide.load.a$a, reason: collision with other inner class name */
    class C0059a implements g {
        final /* synthetic */ InputStream a;

        C0059a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.a.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.b(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    class b implements g {
        final /* synthetic */ ByteBuffer a;

        b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.a.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            return imageHeaderParser.a(this.a);
        }
    }

    class c implements g {
        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ v9 b;

        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, v9 v9Var) {
            this.a = parcelFileDescriptorRewinder;
            this.b = v9Var;
        }

        @Override // com.bumptech.glide.load.a.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.a.a().getFileDescriptor()), this.b);
                try {
                    ImageHeaderParser.ImageType imageTypeB = imageHeaderParser.b(recyclableBufferedInputStream2);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    this.a.a();
                    return imageTypeB;
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    this.a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    class d implements f {
        final /* synthetic */ InputStream a;
        final /* synthetic */ v9 b;

        d(InputStream inputStream, v9 v9Var) {
            this.a = inputStream;
            this.b = v9Var;
        }

        @Override // com.bumptech.glide.load.a.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.c(this.a, this.b);
            } finally {
                this.a.reset();
            }
        }
    }

    class e implements f {
        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ v9 b;

        e(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, v9 v9Var) {
            this.a = parcelFileDescriptorRewinder;
            this.b = v9Var;
        }

        @Override // com.bumptech.glide.load.a.f
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.a.a().getFileDescriptor()), this.b);
                try {
                    int iC = imageHeaderParser.c(recyclableBufferedInputStream2, this.b);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    this.a.a();
                    return iC;
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    this.a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private interface f {
        int a(ImageHeaderParser imageHeaderParser);
    }

    private interface g {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, v9 v9Var) {
        return c(list, new e(parcelFileDescriptorRewinder, v9Var));
    }

    public static int b(List list, InputStream inputStream, v9 v9Var) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, v9Var);
        }
        inputStream.mark(5242880);
        return c(list, new d(inputStream, v9Var));
    }

    private static int c(List list, f fVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iA = fVar.a((ImageHeaderParser) list.get(i));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType d(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, v9 v9Var) {
        return g(list, new c(parcelFileDescriptorRewinder, v9Var));
    }

    public static ImageHeaderParser.ImageType e(List list, InputStream inputStream, v9 v9Var) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, v9Var);
        }
        inputStream.mark(5242880);
        return g(list, new C0059a(inputStream));
    }

    public static ImageHeaderParser.ImageType f(List list, ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : g(list, new b(byteBuffer));
    }

    private static ImageHeaderParser.ImageType g(List list, g gVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType imageTypeA = gVar.a((ImageHeaderParser) list.get(i));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
