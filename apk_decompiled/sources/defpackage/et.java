package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class et {
    private final Context a;
    private Point b;
    private Point c;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Camera.Size size, Camera.Size size2) {
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            return i2 > i ? 1 : 0;
        }
    }

    public et(Context context) {
        this.a = context;
    }

    private Point a(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new a());
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            Log.i("CameraConfiguration", "Supported preview sizes: " + ((Object) sb));
        }
        double d = ((double) point.x) / ((double) point.y);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                if (arrayList.isEmpty()) {
                    Camera.Size previewSize2 = parameters.getPreviewSize();
                    Point point2 = new Point(previewSize2.width, previewSize2.height);
                    Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + point2);
                    return point2;
                }
                Camera.Size size2 = (Camera.Size) arrayList.get(0);
                Point point3 = new Point(size2.width, size2.height);
                Log.i("CameraConfiguration", "Using largest suitable preview size: " + point3);
                return point3;
            }
            Camera.Size size3 = (Camera.Size) it.next();
            int i = size3.width;
            int i2 = size3.height;
            if (i * i2 < 153600) {
                it.remove();
            } else {
                boolean z = i < i2;
                int i3 = z ? i2 : i;
                int i4 = z ? i : i2;
                if (Math.abs((((double) i3) / ((double) i4)) - d) > 0.15d) {
                    it.remove();
                } else if (i3 == point.x && i4 == point.y) {
                    Point point4 = new Point(i, i2);
                    Log.i("CameraConfiguration", "Found preview size exactly matching screen size: " + point4);
                    return point4;
                }
            }
        }
    }

    private Point b(Display display) {
        Point point = new Point();
        display.getSize(point);
        return point;
    }

    public void c(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.b = b(((WindowManager) this.a.getSystemService("window")).getDefaultDisplay());
        Point point = new Point();
        Point point2 = this.b;
        point.x = point2.x;
        point.y = point2.y;
        int i = point2.x;
        int i2 = point2.y;
        if (i < i2) {
            point.x = i2;
            point.y = point2.x;
        }
        this.c = a(parameters, point);
    }

    public void d(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Point point = this.c;
        parameters.setPreviewSize(point.x, point.y);
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.c;
            int i = point2.x;
            int i2 = previewSize.width;
            if (i != i2 || point2.y != previewSize.height) {
                point2.x = i2;
                point2.y = previewSize.height;
            }
        }
        camera.setDisplayOrientation(90);
    }
}
