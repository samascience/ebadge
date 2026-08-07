package defpackage;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder$OnPartialImageListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class j01 implements ug2 {
    final b a = b.b();

    class a implements ImageDecoder$OnHeaderDecodedListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ DecodeFormat d;
        final /* synthetic */ DownsampleStrategy e;
        final /* synthetic */ PreferredColorSpace f;

        /* JADX INFO: renamed from: j01$a$a, reason: collision with other inner class name */
        class C0132a implements ImageDecoder$OnPartialImageListener {
            C0132a() {
            }

            public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        a(int i, int i2, boolean z, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = decodeFormat;
            this.e = downsampleStrategy;
            this.f = preferredColorSpace;
        }

        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            if (j01.this.a.e(this.a, this.b, this.c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.d == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0132a());
            Size size = imageInfo.getSize();
            int width = this.a;
            if (width == Integer.MIN_VALUE) {
                width = size.getWidth();
            }
            int height = this.b;
            if (height == Integer.MIN_VALUE) {
                height = size.getHeight();
            }
            float fB = this.e.b(size.getWidth(), size.getHeight(), width, height);
            int iRound = Math.round(size.getWidth() * fB);
            int iRound2 = Math.round(size.getHeight() * fB);
            if (Log.isLoggable("ImageDecoder", 2)) {
                Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
            }
            imageDecoder.setTargetSize(iRound, iRound2);
            if (Build.VERSION.SDK_INT >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((this.f == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    @Override // defpackage.ug2
    public /* bridge */ /* synthetic */ boolean a(Object obj, rx1 rx1Var) {
        return e(b01.a(obj), rx1Var);
    }

    @Override // defpackage.ug2
    public /* bridge */ /* synthetic */ qg2 b(Object obj, int i, int i2, rx1 rx1Var) {
        return c(b01.a(obj), i, i2, rx1Var);
    }

    public final qg2 c(ImageDecoder.Source source, int i, int i2, rx1 rx1Var) {
        DecodeFormat decodeFormat = (DecodeFormat) rx1Var.a(com.bumptech.glide.load.resource.bitmap.a.f);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) rx1Var.a(DownsampleStrategy.h);
        px1 px1Var = com.bumptech.glide.load.resource.bitmap.a.j;
        return d(source, i, i2, new a(i, i2, rx1Var.a(px1Var) != null && ((Boolean) rx1Var.a(px1Var)).booleanValue(), decodeFormat, downsampleStrategy, (PreferredColorSpace) rx1Var.a(com.bumptech.glide.load.resource.bitmap.a.g)));
    }

    protected abstract qg2 d(ImageDecoder.Source source, int i, int i2, ImageDecoder$OnHeaderDecodedListener imageDecoder$OnHeaderDecodedListener);

    public final boolean e(ImageDecoder.Source source, rx1 rx1Var) {
        return true;
    }
}
