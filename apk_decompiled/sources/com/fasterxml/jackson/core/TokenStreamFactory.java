package com.fasterxml.jackson.core;

import defpackage.hp0;
import defpackage.ip0;
import defpackage.n60;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public abstract class TokenStreamFactory implements Serializable {
    private static final long serialVersionUID = 2;

    protected void _checkRangeBoundsForByteArray(byte[] bArr, int i, int i2) throws IllegalArgumentException {
        if (bArr == null) {
            _reportRangeError("Invalid `byte[]` argument: `null`");
        }
        int length = bArr.length;
        int i3 = i + i2;
        if (((length - i3) | i | i2 | i3) < 0) {
            _reportRangeError(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `byte[]` of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(length)));
        }
    }

    protected void _checkRangeBoundsForCharArray(char[] cArr, int i, int i2) throws IOException {
        if (cArr == null) {
            _reportRangeError("Invalid `char[]` argument: `null`");
        }
        int length = cArr.length;
        int i3 = i + i2;
        if (((length - i3) | i | i2 | i3) < 0) {
            _reportRangeError(String.format("Invalid 'offset' (%d) and/or 'len' (%d) arguments for `char[]` of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(length)));
        }
    }

    protected OutputStream _createDataOutputWrapper(DataOutput dataOutput) {
        return new n60(dataOutput);
    }

    protected InputStream _fileInputStream(File file) throws IOException {
        return new FileInputStream(file);
    }

    protected OutputStream _fileOutputStream(File file) throws IOException {
        return new FileOutputStream(file);
    }

    protected InputStream _optimizedStreamFromURL(URL url) throws IOException {
        String host;
        return (!"file".equals(url.getProtocol()) || !((host = url.getHost()) == null || host.length() == 0) || url.getPath().indexOf(37) >= 0) ? url.openStream() : new FileInputStream(url.getPath());
    }

    protected <T> T _reportRangeError(String str) throws IllegalArgumentException {
        throw new IllegalArgumentException(str);
    }

    public abstract boolean canHandleBinaryNatively();

    public abstract boolean canParseAsync();

    public abstract boolean canUseSchema(ip0 ip0Var);

    public abstract JsonGenerator createGenerator(DataOutput dataOutput) throws IOException;

    public abstract JsonGenerator createGenerator(DataOutput dataOutput, JsonEncoding jsonEncoding) throws IOException;

    public abstract JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) throws IOException;

    public abstract JsonGenerator createGenerator(OutputStream outputStream) throws IOException;

    public abstract JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException;

    public abstract JsonGenerator createGenerator(Writer writer) throws IOException;

    public abstract JsonParser createNonBlockingByteArrayParser() throws IOException;

    public abstract JsonParser createNonBlockingByteBufferParser() throws IOException;

    public abstract JsonParser createParser(DataInput dataInput) throws IOException;

    public abstract JsonParser createParser(File file) throws IOException;

    public abstract JsonParser createParser(InputStream inputStream) throws IOException;

    public abstract JsonParser createParser(Reader reader) throws IOException;

    public abstract JsonParser createParser(String str) throws IOException;

    public abstract JsonParser createParser(URL url) throws IOException;

    public abstract JsonParser createParser(byte[] bArr) throws IOException;

    public abstract JsonParser createParser(byte[] bArr, int i, int i2) throws IOException;

    public abstract JsonParser createParser(char[] cArr) throws IOException;

    public abstract JsonParser createParser(char[] cArr, int i, int i2) throws IOException;

    public abstract int getFormatGeneratorFeatures();

    public abstract String getFormatName();

    public abstract int getFormatParserFeatures();

    public abstract Class<? extends hp0> getFormatReadFeatureType();

    public abstract Class<? extends hp0> getFormatWriteFeatureType();

    public abstract int getGeneratorFeatures();

    public abstract int getParserFeatures();

    public abstract boolean isEnabled(JsonGenerator.Feature feature);

    public abstract boolean isEnabled(JsonParser.Feature feature);

    public abstract boolean requiresPropertyOrdering();

    public abstract /* synthetic */ Version version();
}
