package com.tenmeter.smlibrary.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtils {
    public static final String FILE_EXTENSION_SEPARATOR = ".";
    private static final long SIZE_GB = 1073741824;
    private static final long SIZE_KB = 1024;
    private static final long SIZE_MB = 1048576;

    public static class CompratorByLastModified implements Comparator<File> {
        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            long jLastModified = file.lastModified() - file2.lastModified();
            if (jLastModified > 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }
    }

    private FileUtils() {
        throw new AssertionError();
    }

    public static String checkDirPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return Constants.STR_EMPTY;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static void clearCache(Context context) {
        delete(context.getCacheDir());
        delete(context.getExternalCacheDir());
    }

    public static boolean copyFile(String str, String str2) {
        try {
            return writeFile(str2, new FileInputStream(str));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        }
    }

    public static void delete(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            deleteDirRecursive(file);
        } else {
            file.delete();
        }
    }

    public static void deleteDirRecursive(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                file2.delete();
            } else {
                deleteDirRecursive(file2);
            }
        }
        file.delete();
    }

    public static boolean deleteFile(String str) {
        if (StringUtils.isBlank(str)) {
            return true;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return false;
        }
        if (file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    deleteFile(file2.getAbsolutePath());
                }
            }
        }
        return file.delete();
    }

    public static String formatFileSize(long j) {
        if (j < SIZE_GB) {
            return StringUtil.formatDoubZeroToString(Double.valueOf(BigDecimal.valueOf(j / 1048576.0d).setScale(2, 0).doubleValue())) + "M";
        }
        return StringUtil.formatDoubZeroToString(Double.valueOf(BigDecimal.valueOf(j / 1.073741824E9d).setScale(2, 0).doubleValue())) + "G";
    }

    public static String getAppStorageDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        return externalFilesDir == null ? getStorageDir(context) : externalFilesDir.getAbsolutePath();
    }

    public static String getFileExtension(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        return (iLastIndexOf != -1 && str.lastIndexOf(File.separator) < iLastIndexOf) ? str.substring(iLastIndexOf + 1) : Constants.STR_EMPTY;
    }

    public static List<File> getFileList(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        File[] fileArrListFiles = file.listFiles();
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            arrayList.add(file2);
        }
        return arrayList;
    }

    public static String getFileMD5(File file) throws NoSuchAlgorithmException, IOException {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            int i = fileInputStream.read(bArr, 0, 1024);
            if (i == -1) {
                fileInputStream.close();
                return new BigInteger(1, messageDigest.digest()).toString(16);
            }
            messageDigest.update(bArr, 0, i);
        }
    }

    public static String getFileName(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(iLastIndexOf + 1);
    }

    public static String getFileNameWithoutExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        int iLastIndexOf2 = str.lastIndexOf(File.separator);
        if (iLastIndexOf2 == -1) {
            return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
        }
        if (iLastIndexOf != -1 && iLastIndexOf2 < iLastIndexOf) {
            return str.substring(iLastIndexOf2 + 1, iLastIndexOf);
        }
        return str.substring(iLastIndexOf2 + 1);
    }

    public static long getFileSize(String str) {
        if (StringUtils.isBlank(str)) {
            return 0L;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return -1L;
    }

    public static String getFolderName(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf == -1 ? Constants.STR_EMPTY : str.substring(0, iLastIndexOf);
    }

    public static String getRealFilePathFromUri(Context context, Uri uri) {
        Cursor cursorQuery;
        int columnIndex;
        String string = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme != null && !"file".equalsIgnoreCase(scheme)) {
            if (!"content".equalsIgnoreCase(scheme) || (cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
                return null;
            }
            if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_data")) > -1) {
                string = cursorQuery.getString(columnIndex);
            }
            cursorQuery.close();
            return string;
        }
        return uri.getPath();
    }

    private static String getSDCardDir() {
        File[] fileArrListFiles = Environment.getExternalStorageDirectory().getParentFile().listFiles();
        String str = null;
        long j = 0;
        for (int i = 0; i < fileArrListFiles.length; i++) {
            if (fileArrListFiles[i].canWrite()) {
                String absolutePath = fileArrListFiles[i].getAbsolutePath();
                long sDFreeSize = getSDFreeSize(absolutePath);
                if (sDFreeSize > j) {
                    str = absolutePath;
                    j = sDFreeSize;
                }
            }
        }
        return str;
    }

    public static long getSDFreeSize(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static String getStorageDir(Context context) {
        return getStorageDir(context, true);
    }

    public static boolean isFileExist(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public static boolean isFolderExist(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isDirectory();
    }

    public static String loadCacheSize(Context context) {
        return formatFileSize(getFileSize(context.getCacheDir()) + getFileSize(context.getExternalCacheDir()));
    }

    public static boolean makeDirs(String str) {
        String folderName = getFolderName(str);
        if (TextUtils.isEmpty(folderName)) {
            return false;
        }
        File file = new File(folderName);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static File makeFilePath(String str, String str2) {
        makeRootDirectory(str);
        File file = null;
        try {
            File file2 = new File(str + str2);
            try {
                if (file2.exists()) {
                    return file2;
                }
                file2.createNewFile();
                return file2;
            } catch (Exception e) {
                e = e;
                file = file2;
                e.printStackTrace();
                return file;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void makeRootDirectory(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        } catch (Exception e) {
            Log.i("error:", e + Constants.STR_EMPTY);
        }
    }

    public static void moveFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new RuntimeException("Both sourceFilePath and destFilePath cannot be null.");
        }
        moveFile(new File(str), new File(str2));
    }

    public static String readFile(String str) throws Throwable {
        String str2 = Constants.STR_EMPTY;
        File file = new File(str);
        BufferedReader bufferedReader = null;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        str2 = str2 + line + " ";
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                    }
                }
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return str2;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public static byte[] readFileToByteArray(String str) throws Throwable {
        FileInputStream fileInputStream;
        File file = new File(str);
        ?? Exists = file.exists();
        try {
            if (Exists == 0) {
                KLog.e("File doesn't exist!");
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    if (fileInputStream.getChannel().size() == 0) {
                        KLog.d("The FileInputStream has no content!");
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return null;
                    }
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                        return bArr;
                    } catch (IOException unused2) {
                        return null;
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                    return null;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                    return null;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                fileInputStream = null;
            } catch (IOException e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                Exists = 0;
                try {
                    Exists.close();
                    throw th;
                } catch (IOException unused5) {
                    return null;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static List<String> readFileToList(String str, String str2) throws Throwable {
        File file = new File(str);
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), str2));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            bufferedReader2.close();
                            try {
                                bufferedReader2.close();
                                return arrayList;
                            } catch (IOException e) {
                                throw new RuntimeException("IOException occurred. ", e);
                            }
                        }
                        arrayList.add(line);
                    } catch (IOException e2) {
                        e = e2;
                        throw new RuntimeException("IOException occurred. ", e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                throw new RuntimeException("IOException occurred. ", e3);
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean writeFile(String str, String str2, boolean z) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        FileWriter fileWriter = null;
        try {
            try {
                makeDirs(str);
                FileWriter fileWriter2 = new FileWriter(str, z);
                try {
                    fileWriter2.write(str2);
                    fileWriter2.close();
                    try {
                        fileWriter2.close();
                        return true;
                    } catch (IOException e) {
                        throw new RuntimeException("IOException occurred. ", e);
                    }
                } catch (IOException e2) {
                    e = e2;
                    throw new RuntimeException("IOException occurred. ", e);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e3) {
                            throw new RuntimeException("IOException occurred. ", e3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        }
    }

    public static void writeTxtToFile(String str, String str2, String str3) {
        makeFilePath(str2, str3);
        String str4 = str2 + str3;
        String str5 = str + "\r\n";
        try {
            File file = new File(str4);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + str4);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            randomAccessFile.seek(file.length());
            randomAccessFile.write(str5.getBytes());
            randomAccessFile.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }

    public static String getStorageDir(Context context, boolean z) {
        String string = Environment.getExternalStorageDirectory().toString();
        if (new File(string).canWrite()) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            String str = File.separator;
            sb.append(str);
            sb.append("uet");
            sb.append(str);
            sb.append("teacherpad");
            return sb.toString();
        }
        String sDCardDir = getSDCardDir();
        if (sDCardDir == null) {
            if (z) {
                return context.getCacheDir().toString();
            }
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sDCardDir);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("uet");
        sb2.append(str2);
        sb2.append("teacherpad");
        return sb2.toString();
    }

    public static long getFileSize(File file) {
        long jAvailable = 0;
        if (file == null) {
            return 0L;
        }
        try {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    jAvailable += getFileSize(file2);
                } else {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    jAvailable += (long) fileInputStream.available();
                    fileInputStream.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jAvailable;
    }

    public static void moveFile(File file, File file2) {
        if (file.renameTo(file2)) {
            return;
        }
        copyFile(file.getAbsolutePath(), file2.getAbsolutePath());
        deleteFile(file.getAbsolutePath());
    }

    public static boolean writeFile(String str, List<String> list, boolean z) throws Throwable {
        int i = 0;
        if (list == null || list.size() == 0) {
            return false;
        }
        FileWriter fileWriter = null;
        try {
            try {
                makeDirs(str);
                FileWriter fileWriter2 = new FileWriter(str, z);
                try {
                    for (String str2 : list) {
                        int i2 = i + 1;
                        if (i > 0) {
                            fileWriter2.write("\r\n");
                        }
                        fileWriter2.write(str2);
                        i = i2;
                    }
                    fileWriter2.close();
                    try {
                        fileWriter2.close();
                        return true;
                    } catch (IOException e) {
                        throw new RuntimeException("IOException occurred. ", e);
                    }
                } catch (IOException e2) {
                    e = e2;
                    throw new RuntimeException("IOException occurred. ", e);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e3) {
                            throw new RuntimeException("IOException occurred. ", e3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        }
    }

    public static boolean writeFile(String str, String str2) {
        return writeFile(str, str2, false);
    }

    public static boolean writeFile(String str, List<String> list) {
        return writeFile(str, list, false);
    }

    public static boolean writeFile(String str, InputStream inputStream) {
        return writeFile(str, inputStream, false);
    }

    public static boolean writeFile(String str, InputStream inputStream, boolean z) {
        return writeFile(str != null ? new File(str) : null, inputStream, z);
    }

    public static boolean writeFile(File file, InputStream inputStream) {
        return writeFile(file, inputStream, false);
    }

    public static boolean writeFile(File file, InputStream inputStream, boolean z) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                makeDirs(file.getAbsolutePath());
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i != -1) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            fileOutputStream2.flush();
                            try {
                                fileOutputStream2.close();
                                inputStream.close();
                                return true;
                            } catch (IOException e) {
                                throw new RuntimeException("IOException occurred. ", e);
                            }
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    throw new RuntimeException("FileNotFoundException occurred. ", e);
                } catch (IOException e3) {
                    e = e3;
                    throw new RuntimeException("IOException occurred. ", e);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            inputStream.close();
                        } catch (IOException e4) {
                            throw new RuntimeException("IOException occurred. ", e4);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
        } catch (IOException e6) {
            e = e6;
        }
    }
}
