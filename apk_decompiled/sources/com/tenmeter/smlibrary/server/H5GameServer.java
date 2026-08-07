package com.tenmeter.smlibrary.server;

import android.content.Context;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tenmeter.smlibrary.utils.KLog;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class H5GameServer extends NanoHTTPD {
    private static final int PORT = 4409;
    public static String WEB_ROOT = "";
    private Context mContext;

    public H5GameServer(Context context) throws IOException {
        super(PORT);
        this.mContext = context;
        start();
        KLog.i("H5GameServer start");
    }

    private NanoHTTPD.Response render200(String str, File file) {
        try {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, NanoHTTPD.getMimeTypeForFile(str), new FileInputStream(file), file.length());
        } catch (FileNotFoundException e) {
            return render500(e.getMessage());
        }
    }

    private NanoHTTPD.Response render301(String str) {
        NanoHTTPD.Response responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.REDIRECT, NanoHTTPD.MIME_HTML, null);
        responseNewFixedLengthResponse.addHeader("Location", str);
        return responseNewFixedLengthResponse;
    }

    private NanoHTTPD.Response render404() {
        return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, null);
    }

    private NanoHTTPD.Response render500(String str) {
        return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.INTERNAL_ERROR, NanoHTTPD.MIME_PLAINTEXT, str);
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        String uri = iHTTPSession.getUri();
        if (uri.endsWith("/index.html") || uri.endsWith("/index.htm")) {
            return render301("./");
        }
        File file = new File(WEB_ROOT, uri);
        if (!file.exists()) {
            return render404();
        }
        if (file.isFile()) {
            return render200(uri, file);
        }
        if (!uri.endsWith(WatchConstant.FAT_FS_ROOT)) {
            return render301(uri + WatchConstant.FAT_FS_ROOT);
        }
        File file2 = new File(file, "index.html");
        if (!file2.exists()) {
            return render404();
        }
        return render200(uri + "index.html", file2);
    }

    public H5GameServer(int i) {
        super(i);
    }

    public H5GameServer(String str, int i) {
        super(str, i);
    }
}
