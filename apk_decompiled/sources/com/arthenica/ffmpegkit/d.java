package com.arthenica.ffmpegkit;

import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    private static final List a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("dav1d");
        arrayList.add("fontconfig");
        arrayList.add("freetype");
        arrayList.add("fribidi");
        arrayList.add("gmp");
        arrayList.add("gnutls");
        arrayList.add("kvazaar");
        arrayList.add("mp3lame");
        arrayList.add("libass");
        arrayList.add("iconv");
        arrayList.add("libilbc");
        arrayList.add("libtheora");
        arrayList.add("libvidstab");
        arrayList.add("libvorbis");
        arrayList.add("libvpx");
        arrayList.add("libwebp");
        arrayList.add("libxml2");
        arrayList.add("opencore-amr");
        arrayList.add("openh264");
        arrayList.add("openssl");
        arrayList.add("opus");
        arrayList.add("rubberband");
        arrayList.add("sdl2");
        arrayList.add("shine");
        arrayList.add("snappy");
        arrayList.add("soxr");
        arrayList.add("speex");
        arrayList.add("srt");
        arrayList.add("tesseract");
        arrayList.add("twolame");
        arrayList.add("x264");
        arrayList.add("x265");
        arrayList.add("xvid");
        arrayList.add("zimg");
    }

    public static List a() {
        String nativeBuildConf = AbiDetect.getNativeBuildConf();
        ArrayList arrayList = new ArrayList();
        for (String str : a) {
            if (!nativeBuildConf.contains("enable-" + str)) {
                if (nativeBuildConf.contains("enable-lib" + str)) {
                }
            }
            arrayList.add(str);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static String b() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        List listA = a();
        boolean zContains = listA.contains("speex");
        boolean zContains2 = listA.contains("fribidi");
        boolean zContains3 = listA.contains("gnutls");
        boolean zContains4 = listA.contains("xvid");
        boolean z6 = true;
        boolean z7 = false;
        if (!zContains || !zContains2) {
            if (zContains) {
                z2 = true;
                z = false;
                z4 = false;
            } else {
                if (zContains2) {
                    z = true;
                    z2 = false;
                } else if (!zContains4) {
                    if (zContains3) {
                        z3 = true;
                        z = false;
                        z2 = false;
                        z4 = false;
                        z6 = false;
                    } else {
                        z = false;
                        z2 = false;
                    }
                    z5 = z6;
                } else if (zContains3) {
                    z4 = true;
                    z = false;
                    z2 = false;
                    z3 = false;
                    z6 = z3;
                    z5 = z6;
                } else {
                    z5 = true;
                    z = false;
                    z2 = false;
                    z4 = false;
                    z3 = false;
                    z6 = false;
                }
                z4 = z2;
            }
            z3 = z4;
            z6 = z3;
            z5 = z6;
        } else if (zContains4) {
            z = false;
            z2 = false;
            z4 = false;
            z3 = false;
            z5 = false;
        } else {
            z = false;
            z2 = false;
            z4 = false;
            z3 = false;
            z5 = false;
            z7 = true;
            z6 = false;
        }
        boolean z8 = z5;
        boolean z9 = z3;
        boolean z10 = z4;
        boolean z11 = z2;
        boolean z12 = z;
        boolean z13 = z7;
        if (z6) {
            return (listA.contains("dav1d") && listA.contains("fontconfig") && listA.contains("freetype") && listA.contains("fribidi") && listA.contains("gmp") && listA.contains("gnutls") && listA.contains("kvazaar") && listA.contains("mp3lame") && listA.contains("libass") && listA.contains("iconv") && listA.contains("libilbc") && listA.contains("libtheora") && listA.contains("libvidstab") && listA.contains("libvorbis") && listA.contains("libvpx") && listA.contains("libwebp") && listA.contains("libxml2") && listA.contains("opencore-amr") && listA.contains("opus") && listA.contains("shine") && listA.contains("snappy") && listA.contains("soxr") && listA.contains("speex") && listA.contains("twolame") && listA.contains("x264") && listA.contains("x265") && listA.contains("xvid") && listA.contains("zimg")) ? "full-gpl" : SchedulerSupport.CUSTOM;
        }
        if (z13) {
            return (listA.contains("dav1d") && listA.contains("fontconfig") && listA.contains("freetype") && listA.contains("fribidi") && listA.contains("gmp") && listA.contains("gnutls") && listA.contains("kvazaar") && listA.contains("mp3lame") && listA.contains("libass") && listA.contains("iconv") && listA.contains("libilbc") && listA.contains("libtheora") && listA.contains("libvorbis") && listA.contains("libvpx") && listA.contains("libwebp") && listA.contains("libxml2") && listA.contains("opencore-amr") && listA.contains("opus") && listA.contains("shine") && listA.contains("snappy") && listA.contains("soxr") && listA.contains("speex") && listA.contains("twolame") && listA.contains("zimg")) ? "full" : SchedulerSupport.CUSTOM;
        }
        if (z12) {
            return (listA.contains("dav1d") && listA.contains("fontconfig") && listA.contains("freetype") && listA.contains("fribidi") && listA.contains("kvazaar") && listA.contains("libass") && listA.contains("iconv") && listA.contains("libtheora") && listA.contains("libvpx") && listA.contains("libwebp") && listA.contains("snappy") && listA.contains("zimg")) ? "video" : SchedulerSupport.CUSTOM;
        }
        if (z11) {
            return (listA.contains("mp3lame") && listA.contains("libilbc") && listA.contains("libvorbis") && listA.contains("opencore-amr") && listA.contains("opus") && listA.contains("shine") && listA.contains("soxr") && listA.contains("speex") && listA.contains("twolame")) ? "audio" : SchedulerSupport.CUSTOM;
        }
        if (z10) {
            return (listA.contains("gmp") && listA.contains("gnutls") && listA.contains("libvidstab") && listA.contains("x264") && listA.contains("x265") && listA.contains("xvid")) ? "https-gpl" : SchedulerSupport.CUSTOM;
        }
        if (z9) {
            return (listA.contains("gmp") && listA.contains("gnutls")) ? "https" : SchedulerSupport.CUSTOM;
        }
        if (z8) {
            return (listA.contains("libvidstab") && listA.contains("x264") && listA.contains("x265") && listA.contains("xvid")) ? "min-gpl" : SchedulerSupport.CUSTOM;
        }
        return listA.size() == 0 ? "min" : SchedulerSupport.CUSTOM;
    }
}
