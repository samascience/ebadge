package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes.dex */
public class NioPathDeserializer extends StdScalarDeserializer<Path> {
    private static final boolean areWindowsFilePathsSupported;
    private static final long serialVersionUID = 1;

    static {
        boolean z = false;
        for (File file : File.listRoots()) {
            String path = file.getPath();
            if (path.length() >= 2 && Character.isLetter(path.charAt(0)) && path.charAt(1) == ':') {
                z = true;
                break;
            }
        }
        areWindowsFilePathsSupported = z;
    }

    public NioPathDeserializer() {
        super((Class<?>) Path.class);
    }

    @Override // defpackage.s51
    public Path deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.d1(JsonToken.VALUE_STRING)) {
            return (Path) deserializationContext.handleUnexpectedToken(Path.class, jsonParser);
        }
        String strS0 = jsonParser.S0();
        if (strS0.indexOf(58) < 0) {
            return Paths.get(strS0, new String[0]);
        }
        if (areWindowsFilePathsSupported && strS0.length() >= 2 && Character.isLetter(strS0.charAt(0)) && strS0.charAt(1) == ':') {
            return Paths.get(strS0, new String[0]);
        }
        try {
            URI uri = new URI(strS0);
            try {
                return Paths.get(uri);
            } catch (FileSystemNotFoundException e) {
                try {
                    String scheme = uri.getScheme();
                    for (FileSystemProvider fileSystemProvider : ServiceLoader.load(FileSystemProvider.class)) {
                        if (fileSystemProvider.getScheme().equalsIgnoreCase(scheme)) {
                            return fileSystemProvider.getPath(uri);
                        }
                    }
                    return (Path) deserializationContext.handleInstantiationProblem(handledType(), strS0, e);
                } catch (Throwable th) {
                    th.addSuppressed(e);
                    return (Path) deserializationContext.handleInstantiationProblem(handledType(), strS0, th);
                }
            } catch (Throwable th2) {
                return (Path) deserializationContext.handleInstantiationProblem(handledType(), strS0, th2);
            }
        } catch (URISyntaxException e2) {
            return (Path) deserializationContext.handleInstantiationProblem(handledType(), strS0, e2);
        }
    }
}
