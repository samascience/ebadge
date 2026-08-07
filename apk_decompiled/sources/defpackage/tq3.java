package defpackage;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.f;

/* JADX INFO: loaded from: classes.dex */
public class tq3 implements SensorEventListener {
    private static tq3 g;
    private float[] a;
    private SensorManager b;
    private float c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;

    private tq3() {
    }

    public static synchronized tq3 a() {
        try {
            if (g == null) {
                g = new tq3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public synchronized void c() {
        Sensor defaultSensor;
        try {
            if (this.f) {
                return;
            }
            if (this.d) {
                if (this.b == null) {
                    this.b = (SensorManager) f.b().getSystemService("sensor");
                }
                SensorManager sensorManager = this.b;
                if (sensorManager != null && (defaultSensor = sensorManager.getDefaultSensor(11)) != null && this.d) {
                    this.b.registerListener(this, defaultSensor, 3);
                }
                this.f = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d() {
        try {
            if (this.f) {
                SensorManager sensorManager = this.b;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this);
                    this.b = null;
                }
                this.f = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean e() {
        return this.d;
    }

    public float f() {
        return this.c;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 11) {
            return;
        }
        float[] fArr = (float[]) sensorEvent.values.clone();
        this.a = fArr;
        float[] fArr2 = new float[9];
        try {
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            float[] fArr3 = new float[3];
            SensorManager.getOrientation(fArr2, fArr3);
            float degrees = (float) Math.toDegrees(fArr3[0]);
            this.c = degrees;
            if (degrees < 0.0f) {
                degrees += 360.0f;
            }
            this.c = (float) Math.floor(degrees);
        } catch (Exception unused) {
            this.c = 0.0f;
        }
    }
}
