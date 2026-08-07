package defpackage;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.x;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class rw1 {
    private static final int[] o = {12344};
    private static final int[] p = {12445, 13632, 12344};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f381q;
    private static final String r;
    private static final String s;
    private static final String t;
    private static final float[] u;
    private static final FloatBuffer v;
    private static final float[] w;
    private static final FloatBuffer x;
    private static final b y;
    private Thread c;
    private EGLConfig g;
    private Surface i;
    private final AtomicBoolean a = new AtomicBoolean(false);
    final Map b = new HashMap();
    private EGLDisplay d = EGL14.EGL_NO_DISPLAY;
    private EGLContext e = EGL14.EGL_NO_CONTEXT;
    private int[] f = o;
    private EGLSurface h = EGL14.EGL_NO_SURFACE;
    private int j = -1;
    private int k = -1;
    private int l = -1;
    private int m = -1;
    private int n = -1;

    public static abstract class a {

        /* JADX INFO: renamed from: rw1$a$a, reason: collision with other inner class name */
        static abstract class AbstractC0168a {
            AbstractC0168a() {
            }

            abstract a a();

            abstract AbstractC0168a b(String str);

            abstract AbstractC0168a c(String str);

            abstract AbstractC0168a d(String str);

            abstract AbstractC0168a e(String str);
        }

        a() {
        }

        static AbstractC0168a a() {
            return new kd.b().e("0.0").c("0.0").d(Constants.STR_EMPTY).b(Constants.STR_EMPTY);
        }

        public abstract String b();

        public abstract String c();

        public abstract String d();

        public abstract String e();
    }

    static abstract class b {
        b() {
        }

        static b d(EGLSurface eGLSurface, int i, int i2) {
            return new ld(eGLSurface, i, i2);
        }

        abstract EGLSurface a();

        abstract int b();

        abstract int c();
    }

    static {
        Locale locale = Locale.US;
        f381q = String.format(locale, "uniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 %s;\nvoid main() {\n    gl_Position = aPosition;\n    %s = (uTexMatrix * aTextureCoord).xy;\n}\n", "vTextureCoord", "vTextureCoord");
        r = String.format(locale, "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nout vec2 %s;\nvoid main() {\n  gl_Position = aPosition;\n  %s = (uTexMatrix * aTextureCoord).xy;\n}\n", "vTextureCoord", "vTextureCoord");
        s = String.format(locale, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 %s;\nuniform samplerExternalOES %s;\nvoid main() {\n    gl_FragColor = texture2D(%s, %s);\n}\n", "vTextureCoord", "sTexture", "sTexture", "vTextureCoord");
        t = String.format(locale, "#version 300 es\n#extension GL_OES_EGL_image_external : require\n#extension GL_EXT_YUV_target : require\nprecision mediump float;\nuniform __samplerExternal2DY2YEXT %s;\nin vec2 %s;\nout vec4 outColor;\n\nvec3 yuvToRgb(vec3 yuv) {\n  const vec3 yuvOffset = vec3(0.0625, 0.5, 0.5);\n  const mat3 yuvToRgbColorTransform = mat3(\n    1.1689f, 1.1689f, 1.1689f,\n    0.0000f, -0.1881f, 2.1502f,\n    1.6853f, -0.6530f, 0.0000f\n  );\n  return clamp(yuvToRgbColorTransform * (yuv - yuvOffset), 0.0, 1.0);\n}\n\nvoid main() {\n  vec3 srcYuv = texture(%s, %s).xyz;\n  outColor = vec4(yuvToRgb(srcYuv), 1.0);\n}", "sTexture", "vTextureCoord", "sTexture", "vTextureCoord");
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        u = fArr;
        v = i(fArr);
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        w = fArr2;
        x = i(fArr2);
        y = b.d(EGL14.EGL_NO_SURFACE, 0, 0);
    }

    private void A() {
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.k, "aPosition");
        this.m = iGlGetAttribLocation;
        f(iGlGetAttribLocation, "aPosition");
        int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(this.k, "aTextureCoord");
        this.n = iGlGetAttribLocation2;
        f(iGlGetAttribLocation2, "aTextureCoord");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.k, "uTexMatrix");
        this.l = iGlGetUniformLocation;
        f(iGlGetUniformLocation, "uTexMatrix");
    }

    private static int B(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        c("glCreateShader type=" + i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        x.k("OpenGlRenderer", "Could not compile shader: " + str);
        GLES20.glDeleteShader(iGlCreateShader);
        throw new IllegalStateException("Could not compile shader type " + i + ":" + GLES20.glGetShaderInfoLog(iGlCreateShader));
    }

    private void C(EGLSurface eGLSurface) {
        b52.g(this.d);
        b52.g(this.e);
        if (!EGL14.eglMakeCurrent(this.d, eGLSurface, eGLSurface, this.e)) {
            throw new IllegalStateException("eglMakeCurrent failed");
        }
    }

    private static int D(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    private void G() {
        int i = this.k;
        if (i != -1) {
            GLES20.glDeleteProgram(i);
            this.k = -1;
        }
        if (!Objects.equals(this.d, EGL14.EGL_NO_DISPLAY)) {
            EGLDisplay eGLDisplay = this.d;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            for (b bVar : this.b.values()) {
                if (!Objects.equals(bVar.a(), EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface(this.d, bVar.a())) {
                    a("eglDestroySurface");
                }
            }
            this.b.clear();
            if (!Objects.equals(this.h, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.d, this.h);
                this.h = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals(this.e, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext(this.d, this.e);
                this.e = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.d);
            this.d = EGL14.EGL_NO_DISPLAY;
        }
        this.g = null;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.j = -1;
        this.i = null;
        this.c = null;
    }

    private void H(Surface surface, boolean z) {
        if (this.i == surface) {
            this.i = null;
            C(this.h);
        }
        b bVar = z ? (b) this.b.remove(surface) : (b) this.b.put(surface, y);
        if (bVar == null || bVar == y) {
            return;
        }
        try {
            EGL14.eglDestroySurface(this.d, bVar.a());
        } catch (RuntimeException e) {
            x.l("OpenGlRenderer", "Failed to destroy EGL surface: " + e.getMessage(), e);
        }
    }

    private void K(ByteBuffer byteBuffer, Size size, float[] fArr) {
        b52.b(byteBuffer.capacity() == (size.getWidth() * size.getHeight()) * 4, "ByteBuffer capacity is not equal to width * height * 4.");
        b52.b(byteBuffer.isDirect(), "ByteBuffer is not direct.");
        int iS = s();
        GLES20.glActiveTexture(33985);
        c("glActiveTexture");
        GLES20.glBindTexture(3553, iS);
        c("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, size.getWidth(), size.getHeight(), 0, 6407, 5121, null);
        c("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int iR = r();
        GLES20.glBindFramebuffer(36160, iR);
        c("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iS, 0);
        c("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        c("glActiveTexture");
        GLES20.glBindTexture(36197, this.j);
        c("glBindTexture");
        this.i = null;
        GLES20.glViewport(0, 0, size.getWidth(), size.getHeight());
        GLES20.glScissor(0, 0, size.getWidth(), size.getHeight());
        GLES20.glUniformMatrix4fv(this.l, 1, false, fArr, 0);
        c("glUniformMatrix4fv");
        GLES20.glDrawArrays(5, 0, 4);
        c("glDrawArrays");
        GLES20.glReadPixels(0, 0, size.getWidth(), size.getHeight(), 6408, 5121, byteBuffer);
        c("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        q(iS);
        p(iR);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.j);
    }

    private void M() {
        GLES20.glUseProgram(this.k);
        c("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.j);
        GLES20.glEnableVertexAttribArray(this.m);
        c("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.m, 2, 5126, false, 0, (Buffer) v);
        c("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.n);
        c("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.n, 2, 5126, false, 0, (Buffer) x);
        c("glVertexAttribPointer");
    }

    private static void a(String str) {
        try {
            b(str);
        } catch (IllegalStateException e) {
            x.d("OpenGlRenderer", e.toString(), e);
        }
    }

    private static void b(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    private static void c(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new IllegalStateException(str + ": GL error 0x" + Integer.toHexString(iGlGetError));
    }

    private void d() {
        b52.j(this.c == Thread.currentThread(), "Method call must be called on the GL thread.");
    }

    private void e(boolean z) {
        b52.j(z == this.a.get(), z ? "OpenGlRenderer is not initialized" : "OpenGlRenderer is already initialized");
    }

    private static void f(int i, String str) {
        if (i >= 0) {
            return;
        }
        throw new IllegalStateException("Unable to locate '" + str + "' in program");
    }

    private static int[] g(String str, ie0 ie0Var) {
        int[] iArr = o;
        if (ie0Var.b() != 3) {
            return iArr;
        }
        if (str.contains("EGL_EXT_gl_colorspace_bt2020_hlg")) {
            return p;
        }
        x.k("OpenGlRenderer", "Dynamic range uses HLG encoding, but device does not support EGL_EXT_gl_colorspace_bt2020_hlg.Fallback to default colorspace.");
        return iArr;
    }

    private void h(ie0 ie0Var, a.AbstractC0168a abstractC0168a) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.d = eGLDisplayEglGetDisplay;
        if (Objects.equals(eGLDisplayEglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            throw new IllegalStateException("Unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.d, iArr, 0, iArr, 1)) {
            this.d = EGL14.EGL_NO_DISPLAY;
            throw new IllegalStateException("Unable to initialize EGL14");
        }
        if (abstractC0168a != null) {
            abstractC0168a.c(iArr[0] + FileUtils.FILE_EXTENSION_SEPARATOR + iArr[1]);
        }
        int i = ie0Var.d() ? 10 : 8;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.d, new int[]{12324, i, 12323, i, 12322, i, 12321, ie0Var.d() ? 2 : 8, 12325, 0, 12326, 0, 12352, ie0Var.d() ? 64 : 4, 12610, ie0Var.d() ? -1 : 1, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new IllegalStateException("Unable to find a suitable EGLConfig");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.d, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, ie0Var.d() ? 3 : 2, 12344}, 0);
        b("eglCreateContext");
        this.g = eGLConfig;
        this.e = eGLContextEglCreateContext;
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.d, eGLContextEglCreateContext, 12440, iArr2, 0);
        Log.d("OpenGlRenderer", "EGLContext created, client version " + iArr2[0]);
    }

    public static FloatBuffer i(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    private b j(Surface surface) {
        try {
            EGLDisplay eGLDisplay = this.d;
            EGLConfig eGLConfig = this.g;
            Objects.requireNonNull(eGLConfig);
            EGLSurface eGLSurfaceO = o(eGLDisplay, eGLConfig, surface, this.f);
            Size sizeW = w(eGLSurfaceO);
            return b.d(eGLSurfaceO, sizeW.getWidth(), sizeW.getHeight());
        } catch (IllegalArgumentException | IllegalStateException e) {
            x.l("OpenGlRenderer", "Failed to create EGL surface: " + e.getMessage(), e);
            return null;
        }
    }

    private static EGLSurface k(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, i, 12374, i2, 12344}, 0);
        b("eglCreatePbufferSurface");
        if (eGLSurfaceEglCreatePbufferSurface != null) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0082  */
    /* JADX WARN: Code duplicated, block: B:37:0x0087  */
    private void l(ie0 ie0Var, on2 on2Var) throws Throwable {
        int i;
        int i2;
        int iB;
        try {
            iB = B(35633, ie0Var.d() ? r : f381q);
            try {
                int iZ = z(ie0Var, on2Var);
                try {
                    int iGlCreateProgram = GLES20.glCreateProgram();
                    try {
                        c("glCreateProgram");
                        GLES20.glAttachShader(iGlCreateProgram, iB);
                        c("glAttachShader");
                        GLES20.glAttachShader(iGlCreateProgram, iZ);
                        c("glAttachShader");
                        GLES20.glLinkProgram(iGlCreateProgram);
                        int[] iArr = new int[1];
                        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
                        if (iArr[0] == 1) {
                            this.k = iGlCreateProgram;
                            return;
                        }
                        throw new IllegalStateException("Could not link program: " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
                    } catch (IllegalArgumentException e) {
                        e = e;
                        i = iZ;
                        e = e;
                        i2 = iGlCreateProgram;
                        if (iB != -1) {
                            GLES20.glDeleteShader(iB);
                        }
                        if (i != -1) {
                            GLES20.glDeleteShader(i);
                        }
                        if (i2 != -1) {
                            GLES20.glDeleteProgram(i2);
                        }
                        throw e;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        i = iZ;
                        e = e;
                        i2 = iGlCreateProgram;
                        if (iB != -1) {
                            GLES20.glDeleteShader(iB);
                        }
                        if (i != -1) {
                            GLES20.glDeleteShader(i);
                        }
                        if (i2 != -1) {
                            GLES20.glDeleteProgram(i2);
                        }
                        throw e;
                    }
                } catch (IllegalArgumentException | IllegalStateException e3) {
                    i2 = -1;
                    i = iZ;
                    e = e3;
                }
            } catch (IllegalArgumentException | IllegalStateException e4) {
                e = e4;
                i = -1;
                i2 = -1;
            }
        } catch (IllegalArgumentException e5) {
            e = e5;
            i = -1;
            i2 = -1;
            iB = -1;
            if (iB != -1) {
                GLES20.glDeleteShader(iB);
            }
            if (i != -1) {
                GLES20.glDeleteShader(i);
            }
            if (i2 != -1) {
                GLES20.glDeleteProgram(i2);
            }
            throw e;
        } catch (IllegalStateException e6) {
            e = e6;
            i = -1;
            i2 = -1;
            iB = -1;
            if (iB != -1) {
                GLES20.glDeleteShader(iB);
            }
            if (i != -1) {
                GLES20.glDeleteShader(i);
            }
            if (i2 != -1) {
                GLES20.glDeleteProgram(i2);
            }
            throw e;
        }
    }

    private void m() {
        EGLDisplay eGLDisplay = this.d;
        EGLConfig eGLConfig = this.g;
        Objects.requireNonNull(eGLConfig);
        this.h = k(eGLDisplay, eGLConfig, 1, 1);
    }

    private void n() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        c("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(36197, i);
        c("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        c("glTexParameter");
        this.j = i;
    }

    private static EGLSurface o(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Surface surface, int[] iArr) {
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, iArr, 0);
        b("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    private static void p(int i) {
        GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
        c("glDeleteFramebuffers");
    }

    private static void q(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        c("glDeleteTextures");
    }

    private static int r() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        c("glGenFramebuffers");
        return iArr[0];
    }

    private static int s() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        c("glGenTextures");
        return iArr[0];
    }

    private az1 t(ie0 ie0Var) {
        e(false);
        try {
            h(ie0Var, null);
            m();
            C(this.h);
            String strGlGetString = GLES20.glGetString(7939);
            String strEglQueryString = EGL14.eglQueryString(this.d, 12373);
            if (strGlGetString == null) {
                strGlGetString = Constants.STR_EMPTY;
            }
            if (strEglQueryString == null) {
                strEglQueryString = Constants.STR_EMPTY;
            }
            return new az1(strGlGetString, strEglQueryString);
        } catch (IllegalStateException e) {
            x.l("OpenGlRenderer", "Failed to get GL or EGL extensions: " + e.getMessage(), e);
            return new az1(Constants.STR_EMPTY, Constants.STR_EMPTY);
        } finally {
            G();
        }
    }

    private static String u() {
        Matcher matcher = Pattern.compile("OpenGL ES ([0-9]+)\\.([0-9]+).*").matcher(GLES20.glGetString(7938));
        if (!matcher.find()) {
            return "0.0";
        }
        return ((String) b52.g(matcher.group(1))) + FileUtils.FILE_EXTENSION_SEPARATOR + ((String) b52.g(matcher.group(2)));
    }

    private b v(Surface surface) {
        b52.j(this.b.containsKey(surface), "The surface is not registered.");
        b bVar = (b) this.b.get(surface);
        Objects.requireNonNull(bVar);
        return bVar;
    }

    private Size w(EGLSurface eGLSurface) {
        return new Size(D(this.d, eGLSurface, 12375), D(this.d, eGLSurface, 12374));
    }

    private int z(ie0 ie0Var, on2 on2Var) {
        if (on2Var == on2.a) {
            return B(35632, ie0Var.d() ? t : s);
        }
        try {
            String strA = on2Var.a("sTexture", "vTextureCoord");
            if (strA != null && strA.contains("vTextureCoord") && strA.contains("sTexture")) {
                return B(35632, strA);
            }
            throw new IllegalArgumentException("Invalid fragment shader");
        } catch (Throwable th) {
            if (th instanceof IllegalArgumentException) {
                throw th;
            }
            throw new IllegalArgumentException("Unable to compile fragment shader", th);
        }
    }

    public void E(Surface surface) {
        e(true);
        d();
        if (this.b.containsKey(surface)) {
            return;
        }
        this.b.put(surface, y);
    }

    public void F() {
        if (this.a.getAndSet(false)) {
            d();
            G();
        }
    }

    public void I(long j, float[] fArr, Surface surface) {
        e(true);
        d();
        b bVarV = v(surface);
        if (bVarV == y) {
            bVarV = j(surface);
            if (bVarV == null) {
                return;
            } else {
                this.b.put(surface, bVarV);
            }
        }
        if (surface != this.i) {
            C(bVarV.a());
            this.i = surface;
            GLES20.glViewport(0, 0, bVarV.c(), bVarV.b());
            GLES20.glScissor(0, 0, bVarV.c(), bVarV.b());
        }
        GLES20.glUniformMatrix4fv(this.l, 1, false, fArr, 0);
        c("glUniformMatrix4fv");
        GLES20.glDrawArrays(5, 0, 4);
        c("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.d, bVarV.a(), j);
        if (EGL14.eglSwapBuffers(this.d, bVarV.a())) {
            return;
        }
        x.k("OpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        H(surface, false);
    }

    public Bitmap J(Size size, float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(size.getWidth() * size.getHeight() * 4);
        K(byteBufferAllocateDirect, size, fArr);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), Bitmap.Config.ARGB_8888);
        byteBufferAllocateDirect.rewind();
        ImageProcessingUtil.j(bitmapCreateBitmap, byteBufferAllocateDirect, size.getWidth() * 4);
        return bitmapCreateBitmap;
    }

    public void L(Surface surface) {
        e(true);
        d();
        H(surface, true);
    }

    public int x() {
        e(true);
        d();
        return this.j;
    }

    public a y(ie0 ie0Var, on2 on2Var) throws Throwable {
        e(false);
        a.AbstractC0168a abstractC0168aA = a.a();
        try {
            if (ie0Var.d()) {
                az1 az1VarT = t(ie0Var);
                String str = (String) b52.g((String) az1VarT.a);
                String str2 = (String) b52.g((String) az1VarT.b);
                if (!str.contains("GL_EXT_YUV_target")) {
                    x.k("OpenGlRenderer", "Device does not support GL_EXT_YUV_target. Fallback to SDR.");
                    ie0Var = ie0.d;
                }
                this.f = g(str2, ie0Var);
                abstractC0168aA.d(str);
                abstractC0168aA.b(str2);
            }
            h(ie0Var, abstractC0168aA);
            m();
            C(this.h);
            abstractC0168aA.e(u());
            l(ie0Var, on2Var);
            A();
            n();
            M();
            this.c = Thread.currentThread();
            this.a.set(true);
            return abstractC0168aA.a();
        } catch (IllegalArgumentException e) {
            e = e;
            G();
            throw e;
        } catch (IllegalStateException e2) {
            e = e2;
            G();
            throw e;
        }
    }
}
