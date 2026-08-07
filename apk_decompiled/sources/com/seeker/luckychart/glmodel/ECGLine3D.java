package com.seeker.luckychart.glmodel;

import android.graphics.Color;
import android.opengl.GLES20;
import android.util.SparseArray;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.rajawali3d.BufferInfo;
import org.rajawali3d.Object3D;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.MaterialManager;

/* JADX INFO: loaded from: classes.dex */
public class ECGLine3D extends Object3D {
    private SparseArray<float[]> colorMaps = new SparseArray<>();
    private FloatBuffer mColorVertexBuffer;
    private BufferInfo mColorVertexBufferInfo;
    private FloatBuffer mDataVertexBuffer;
    private BufferInfo mDataVertexBufferInfo;
    private IntBuffer mIndexBuffer;
    private BufferInfo mIndexBufferInfo;
    private float mLineThickness;
    private int numPoints;

    public ECGLine3D(int i) {
        this.numPoints = i;
        setDrawingMode(3);
        isContainer(false);
        setDoubleSided(true);
        setTransparent(true);
        init();
    }

    private float[] getAssuredColors(int i) {
        float[] fArr = this.colorMaps.get(i);
        if (fArr != null) {
            return fArr;
        }
        float[] fArr2 = {Color.red(i) / 255.0f, Color.green(i) / 255.0f, Color.blue(i) / 255.0f, Color.alpha(i) / 255.0f};
        this.colorMaps.put(i, fArr2);
        return fArr2;
    }

    private void init() {
        int i = this.numPoints;
        float[] fArr = new float[i * 3];
        int[] iArr = new int[i];
        float[] fArr2 = new float[i * 4];
        for (int i2 = 0; i2 < this.numPoints; i2++) {
            iArr[i2] = i2;
        }
        setData(fArr, null, null, fArr2, iArr, true);
        Material material = new Material();
        material.useVertexColors(true);
        setMaterial(material);
        this.mDataVertexBufferInfo = getGeometry().getVertexBufferInfo();
        this.mDataVertexBuffer = getGeometry().getVertices();
        this.mColorVertexBufferInfo = getGeometry().getColorBufferInfo();
        this.mColorVertexBuffer = getGeometry().getColors();
        this.mIndexBufferInfo = getGeometry().getIndexBufferInfo();
        this.mIndexBuffer = getGeometry().getIndices();
        getGeometry().changeBufferUsage(this.mDataVertexBufferInfo, 35048);
        getGeometry().changeBufferUsage(this.mColorVertexBufferInfo, 35048);
        getGeometry().changeBufferUsage(this.mIndexBufferInfo, 35044);
    }

    public void addIndexToBuffer(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mIndexBuffer.put(i2, i2);
        }
        for (int i3 = i; i3 < this.numPoints; i3++) {
            this.mIndexBuffer.put(i3, i - 1);
        }
    }

    public void addVertexToBuffer(float f, float f2, int i, int i2) {
        int i3 = i2 * 3;
        this.mDataVertexBuffer.put(i3, f);
        this.mDataVertexBuffer.put(i3 + 1, f2);
        this.mDataVertexBuffer.put(i3 + 2, 0.0f);
        float[] assuredColors = getAssuredColors(i);
        int i4 = i2 * 4;
        this.mColorVertexBuffer.put(i4, assuredColors[0]);
        this.mColorVertexBuffer.put(i4 + 1, assuredColors[1]);
        this.mColorVertexBuffer.put(i4 + 2, assuredColors[2]);
        this.mColorVertexBuffer.put(i4 + 3, assuredColors[3]);
    }

    public void clearChild() {
        this.mChildren.clear();
    }

    public void destroy() {
        super.destroy();
        MaterialManager.getInstance().removeMaterial(this.mMaterial);
    }

    protected void preRender() {
        super.preRender();
        GLES20.glLineWidth(this.mLineThickness);
    }

    public void setLineThickness(float f) {
        this.mLineThickness = f;
    }

    public void updateData() {
        updateData(this.numPoints);
    }

    public void updateData(int i) {
        getGeometry().changeBufferData(this.mDataVertexBufferInfo, this.mDataVertexBuffer, 0, i * 3);
        getGeometry().changeBufferData(this.mColorVertexBufferInfo, this.mColorVertexBuffer, 0, i * 4);
        getGeometry().changeBufferData(this.mIndexBufferInfo, this.mIndexBuffer, 0, this.numPoints);
    }
}
