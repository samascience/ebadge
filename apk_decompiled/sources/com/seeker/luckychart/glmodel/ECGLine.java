package com.seeker.luckychart.glmodel;

import android.graphics.Color;
import android.opengl.GLES20;
import java.util.Stack;
import org.rajawali3d.Object3D;
import org.rajawali3d.math.vector.Vector3;

/* JADX INFO: loaded from: classes.dex */
public class ECGLine extends Object3D {
    private float mLineThickness;
    private Stack<Vector3> mPoints;

    private ECGLine(int i) {
        setDoubleSided(true);
        setTransparent(true);
        isContainer(false);
        setDrawingMode(i);
    }

    public static ECGLine create() {
        return new ECGLine(3);
    }

    public ECGLine init() {
        int size = this.mPoints.size();
        float[] fArr = new float[size * 3];
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            Vector3 vector3 = this.mPoints.get(i);
            int i2 = i * 3;
            fArr[i2] = (float) vector3.x;
            fArr[i2 + 1] = (float) vector3.y;
            fArr[i2 + 2] = (float) vector3.z;
            iArr[i] = i;
        }
        setData(fArr, null, null, null, iArr, true);
        return this;
    }

    protected void preRender() {
        super.preRender();
        GLES20.glLineWidth(this.mLineThickness);
    }

    public void setColor(int i) {
        this.mColor[0] = Color.red(i) / 255.0f;
        this.mColor[1] = Color.green(i) / 255.0f;
        this.mColor[2] = Color.blue(i) / 255.0f;
        this.mColor[3] = Color.alpha(i) / 255.0f;
        this.mOverrideMaterialColor = true;
    }

    public void setLineThickness(float f) {
        this.mLineThickness = f;
    }

    public void setPoints(Stack<Vector3> stack) {
        this.mPoints = stack;
    }

    public static ECGLine create(int i) {
        return new ECGLine(i);
    }
}
