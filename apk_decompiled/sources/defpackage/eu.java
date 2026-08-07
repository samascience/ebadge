package defpackage;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
import kotlinx.coroutines.DebugKt;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public final class eu {
    private final et a;
    private Context b;
    private Camera c;

    public eu(Context context) {
        this.b = context;
        this.a = new et(context);
    }

    public void a(Camera.AutoFocusCallback autoFocusCallback) {
        Camera camera = this.c;
        if (camera != null) {
            try {
                camera.autoFocus(autoFocusCallback);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void b() {
        Camera camera = this.c;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.c.release();
            this.c = null;
        }
    }

    public void c(boolean z) {
        Camera camera = this.c;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (!parameters.isZoomSupported()) {
                Log.i("CameraManager", "zoom not supported");
                return;
            }
            int maxZoom = parameters.getMaxZoom();
            int zoom = parameters.getZoom();
            if (z && zoom < maxZoom) {
                zoom++;
            } else if (zoom > 0) {
                zoom--;
            }
            parameters.setZoom(zoom);
            this.c.setParameters(parameters);
        }
    }

    public synchronized void d() {
        if (this.c != null) {
            return;
        }
        Camera cameraOpen = Camera.open();
        this.c = cameraOpen;
        if (cameraOpen == null) {
            throw new IOException("The camera is occupied.");
        }
        this.a.c(cameraOpen);
        Camera.Parameters parameters = this.c.getParameters();
        String strFlatten = parameters == null ? null : parameters.flatten();
        try {
            this.a.d(this.c, false);
        } catch (RuntimeException unused) {
            if (strFlatten != null) {
                Camera.Parameters parameters2 = this.c.getParameters();
                parameters2.unflatten(strFlatten);
                try {
                    this.c.setParameters(parameters2);
                    this.a.d(this.c, true);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void e(float f) {
        int maxZoom;
        Camera camera = this.c;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported() && (maxZoom = parameters.getMaxZoom()) != 0) {
                parameters.setZoom((int) (maxZoom * f));
                this.c.setParameters(parameters);
            }
        }
    }

    public void f() {
        Camera camera = this.c;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() == null) {
                return;
            }
            if (parameters.getFlashMode().endsWith("torch")) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                parameters.setFlashMode("torch");
            }
            this.c.setParameters(parameters);
        }
    }

    public void g(boolean z) {
        Camera camera = this.c;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() == null) {
                return;
            }
            if (z) {
                if (parameters.getFlashMode().endsWith(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    parameters.setFlashMode("torch");
                }
            } else if (parameters.getFlashMode().endsWith("torch")) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
            this.c.setParameters(parameters);
        }
    }

    public void h(SurfaceHolder surfaceHolder, Camera.PreviewCallback previewCallback) throws IOException {
        if (this.c != null) {
            if (Build.MANUFACTURER.equals("LGE") && Build.MODEL.equals("Nexus 5X")) {
                this.c.setDisplayOrientation(o92.i().n(this.b) ? 270 : Opcodes.GETFIELD);
            } else {
                this.c.setDisplayOrientation(o92.i().n(this.b) ? 90 : 0);
            }
            this.c.setPreviewDisplay(surfaceHolder);
            this.c.setPreviewCallback(previewCallback);
            this.c.startPreview();
        }
    }

    public void i() {
        Camera camera = this.c;
        if (camera != null) {
            try {
                camera.stopPreview();
            } catch (Exception unused) {
            }
            try {
                this.c.setPreviewDisplay(null);
            } catch (IOException unused2) {
            }
        }
    }
}
