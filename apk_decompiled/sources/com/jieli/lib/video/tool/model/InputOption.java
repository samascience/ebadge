package com.jieli.lib.video.tool.model;

import com.jieli.lib.video.tool.util.OutputType;

/* JADX INFO: loaded from: classes3.dex */
public final class InputOption {
    private String inPath;
    private String outPath;
    private OutputType outputType = OutputType.ANI;
    private int width = 240;
    private int height = 240;
    private int frameRate = 20;
    private int quality = 8;

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getHeight() {
        return this.height;
    }

    public String getInPath() {
        return this.inPath;
    }

    public String getOutPath() {
        return this.outPath;
    }

    public OutputType getOutputType() {
        return this.outputType;
    }

    public int getQuality() {
        return this.quality;
    }

    public int getWidth() {
        return this.width;
    }

    public InputOption setFrameRate(int i) {
        this.frameRate = i;
        return this;
    }

    public InputOption setHeight(int i) {
        this.height = i;
        return this;
    }

    public InputOption setInPath(String str) {
        this.inPath = str;
        return this;
    }

    public InputOption setOutPath(String str) {
        this.outPath = str;
        return this;
    }

    public InputOption setOutputType(OutputType outputType) {
        this.outputType = outputType;
        return this;
    }

    public InputOption setQuality(int i) {
        this.quality = i;
        return this;
    }

    public InputOption setWidth(int i) {
        this.width = i;
        return this;
    }

    public String toString() {
        return "InputOption{outputType='" + this.outputType + "', inPath='" + this.inPath + "', outPath='" + this.outPath + "', width=" + this.width + ", height=" + this.height + ", frameRate=" + this.frameRate + ", quality=" + this.quality + '}';
    }
}
