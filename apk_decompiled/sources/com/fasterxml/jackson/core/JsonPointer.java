package com.fasterxml.jackson.core;

import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import defpackage.h71;
import defpackage.hs1;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class JsonPointer implements Serializable {
    protected static final JsonPointer EMPTY = new JsonPointer();
    public static final char SEPARATOR = '/';
    private static final long serialVersionUID = 1;
    protected final String _asString;
    protected final int _asStringOffset;
    protected int _hashCode;
    protected volatile JsonPointer _head;
    protected final int _matchingElementIndex;
    protected final String _matchingPropertyName;
    protected final JsonPointer _nextSegment;

    static class Serialization implements Externalizable {
        private String _fullPath;

        public Serialization() {
        }

        private Object readResolve() throws ObjectStreamException {
            return JsonPointer.compile(this._fullPath);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            this._fullPath = objectInput.readUTF();
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(this._fullPath);
        }

        Serialization(String str) {
            this._fullPath = str;
        }
    }

    private static class a {
        public final a a;
        public final int b;
        public final String c;

        a(a aVar, int i, String str) {
            this.a = aVar;
            this.b = i;
            this.c = str;
        }
    }

    private static class b {
        public final b a;
        public final String b;
        public final int c;
        public int d;
        public b e;

        public b(b bVar, String str, int i) {
            this.a = bVar;
            this.b = str;
            this.c = i;
            if (bVar != null) {
                bVar.e = this;
            }
        }
    }

    protected JsonPointer() {
        this._nextSegment = null;
        this._matchingPropertyName = null;
        this._matchingElementIndex = -1;
        this._asString = Constants.STR_EMPTY;
        this._asStringOffset = 0;
    }

    private static void _appendEscape(StringBuilder sb, char c) {
        if (c == '0') {
            c = '~';
        } else if (c == '1') {
            c = SEPARATOR;
        } else {
            sb.append('~');
        }
        sb.append(c);
    }

    private static void _appendEscaped(StringBuilder sb, String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '/') {
                sb.append("~1");
            } else if (cCharAt == '~') {
                sb.append("~0");
            } else {
                sb.append(cCharAt);
            }
        }
    }

    private static JsonPointer _buildPath(String str, int i, String str2, a aVar) {
        JsonPointer jsonPointer = new JsonPointer(str, i, str2, EMPTY);
        while (aVar != null) {
            JsonPointer jsonPointer2 = new JsonPointer(str, aVar.b, aVar.c, jsonPointer);
            aVar = aVar.a;
            jsonPointer = jsonPointer2;
        }
        return jsonPointer;
    }

    private final boolean _compare(String str, int i, String str2, int i2) {
        int length = str.length();
        if (length - i != str2.length() - i2) {
            return false;
        }
        while (i < length) {
            int i3 = i + 1;
            int i4 = i2 + 1;
            if (str.charAt(i) != str2.charAt(i2)) {
                return false;
            }
            i = i3;
            i2 = i4;
        }
        return true;
    }

    protected static int _extractEscapedSegment(String str, int i, int i2, StringBuilder sb) {
        int length = str.length();
        int i3 = i2 - 1;
        if (i3 - i > 0) {
            sb.append((CharSequence) str, i, i3);
        }
        int i4 = i2 + 1;
        _appendEscape(sb, str.charAt(i2));
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '/') {
                return i4;
            }
            int i5 = i4 + 1;
            if (cCharAt != '~' || i5 >= length) {
                sb.append(cCharAt);
                i4 = i5;
            } else {
                i4 += 2;
                _appendEscape(sb, str.charAt(i5));
            }
        }
        return -1;
    }

    private static final int _parseIndex(String str) {
        int length = str.length();
        if (length == 0 || length > 10) {
            return -1;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt <= '0') {
            return (length == 1 && cCharAt == '0') ? 0 : -1;
        }
        if (cCharAt > '9') {
            return -1;
        }
        for (int i = 1; i < length; i++) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return -1;
            }
        }
        if (length != 10 || hs1.o(str) <= 2147483647L) {
            return hs1.m(str);
        }
        return -1;
    }

    protected static JsonPointer _parseTail(String str) {
        int length = str.length();
        a aVar = null;
        int i = 1;
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '/') {
                a aVar2 = new a(aVar, i2, str.substring(i2 + 1, i));
                i2 = i;
                i++;
                aVar = aVar2;
            } else {
                i++;
                if (cCharAt == '~' && i < length) {
                    StringBuilder sb = new StringBuilder(32);
                    int i_extractEscapedSegment = _extractEscapedSegment(str, i2 + 1, i, sb);
                    String string = sb.toString();
                    if (i_extractEscapedSegment < 0) {
                        return _buildPath(str, i2, string, aVar);
                    }
                    a aVar3 = new a(aVar, i2, string);
                    i2 = i_extractEscapedSegment;
                    i = i_extractEscapedSegment + 1;
                    aVar = aVar3;
                }
            }
        }
        return _buildPath(str, i2, str.substring(i2 + 1), aVar);
    }

    public static JsonPointer compile(String str) throws IllegalArgumentException {
        if (str == null || str.length() == 0) {
            return EMPTY;
        }
        if (str.charAt(0) == '/') {
            return _parseTail(str);
        }
        throw new IllegalArgumentException("Invalid input: JSON Pointer expression must start with '/': \"" + str + "\"");
    }

    public static JsonPointer empty() {
        return EMPTY;
    }

    public static JsonPointer forPath(h71 h71Var, boolean z) {
        b bVar;
        if (h71Var == null) {
            return EMPTY;
        }
        if (!h71Var.h() && (!z || !h71Var.k() || !h71Var.f())) {
            h71Var = h71Var.e();
        }
        int length = 0;
        b bVar2 = null;
        while (h71Var != null) {
            if (h71Var.j()) {
                String strB = h71Var.b();
                if (strB == null) {
                    strB = Constants.STR_EMPTY;
                }
                length += strB.length() + 2;
                bVar = new b(bVar2, strB, -1);
            } else {
                if (h71Var.i() || z) {
                    length += 6;
                    bVar = new b(bVar2, null, h71Var.a());
                }
                h71Var = h71Var.e();
            }
            bVar2 = bVar;
            h71Var = h71Var.e();
        }
        if (bVar2 == null) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder(length);
        b bVar3 = null;
        b bVar4 = bVar2;
        while (bVar4 != null) {
            bVar4.d = sb.length();
            sb.append(SEPARATOR);
            String str = bVar4.b;
            if (str != null) {
                _appendEscaped(sb, str);
            } else {
                sb.append(bVar4.c);
            }
            b bVar5 = bVar4;
            bVar4 = bVar4.a;
            bVar3 = bVar5;
        }
        String string = sb.toString();
        JsonPointer jsonPointer = EMPTY;
        while (bVar3 != null) {
            String str2 = bVar3.b;
            if (str2 != null) {
                jsonPointer = new JsonPointer(string, bVar3.d, str2, jsonPointer);
            } else {
                int i = bVar3.c;
                jsonPointer = new JsonPointer(string, bVar3.d, String.valueOf(i), i, jsonPointer);
            }
            bVar3 = bVar3.e;
        }
        return jsonPointer;
    }

    public static JsonPointer valueOf(String str) {
        return compile(str);
    }

    private Object writeReplace() {
        return new Serialization(toString());
    }

    protected JsonPointer _constructHead() {
        JsonPointer jsonPointerLast = last();
        if (jsonPointerLast == this) {
            return EMPTY;
        }
        int length = jsonPointerLast.length();
        JsonPointer jsonPointer = this._nextSegment;
        String string = toString();
        return new JsonPointer(string.substring(0, string.length() - length), 0, this._matchingPropertyName, this._matchingElementIndex, jsonPointer._constructHead(length, jsonPointerLast));
    }

    public JsonPointer append(JsonPointer jsonPointer) {
        JsonPointer jsonPointer2 = EMPTY;
        if (this == jsonPointer2) {
            return jsonPointer;
        }
        if (jsonPointer == jsonPointer2) {
            return this;
        }
        String strSubstring = this._asString;
        if (strSubstring.endsWith(WatchConstant.FAT_FS_ROOT)) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return compile(strSubstring + jsonPointer._asString);
    }

    public JsonPointer appendIndex(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative index cannot be appended");
        }
        String strSubstring = this._asString;
        if (strSubstring.endsWith(WatchConstant.FAT_FS_ROOT)) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return compile(strSubstring + SEPARATOR + i);
    }

    public JsonPointer appendProperty(String str) {
        if (str == null || str.isEmpty()) {
            return this;
        }
        if (str.charAt(0) != '/') {
            str = SEPARATOR + str;
        }
        String strSubstring = this._asString;
        if (strSubstring.endsWith(WatchConstant.FAT_FS_ROOT)) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return compile(strSubstring + str);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonPointer)) {
            return false;
        }
        JsonPointer jsonPointer = (JsonPointer) obj;
        return _compare(this._asString, this._asStringOffset, jsonPointer._asString, jsonPointer._asStringOffset);
    }

    public int getMatchingIndex() {
        return this._matchingElementIndex;
    }

    public String getMatchingProperty() {
        return this._matchingPropertyName;
    }

    public int hashCode() {
        int iHashCode = this._hashCode;
        if (iHashCode == 0) {
            iHashCode = toString().hashCode();
            if (iHashCode == 0) {
                iHashCode = -1;
            }
            this._hashCode = iHashCode;
        }
        return iHashCode;
    }

    public JsonPointer head() {
        JsonPointer jsonPointer_constructHead = this._head;
        if (jsonPointer_constructHead == null) {
            if (this != EMPTY) {
                jsonPointer_constructHead = _constructHead();
            }
            this._head = jsonPointer_constructHead;
        }
        return jsonPointer_constructHead;
    }

    public JsonPointer last() {
        if (this == EMPTY) {
            return null;
        }
        JsonPointer jsonPointer = this;
        while (true) {
            JsonPointer jsonPointer2 = jsonPointer._nextSegment;
            if (jsonPointer2 == EMPTY) {
                return jsonPointer;
            }
            jsonPointer = jsonPointer2;
        }
    }

    public int length() {
        return this._asString.length() - this._asStringOffset;
    }

    public JsonPointer matchElement(int i) {
        if (i != this._matchingElementIndex || i < 0) {
            return null;
        }
        return this._nextSegment;
    }

    public JsonPointer matchProperty(String str) {
        if (this._nextSegment == null || !this._matchingPropertyName.equals(str)) {
            return null;
        }
        return this._nextSegment;
    }

    public boolean matches() {
        return this._nextSegment == null;
    }

    public boolean matchesElement(int i) {
        return i == this._matchingElementIndex && i >= 0;
    }

    public boolean matchesProperty(String str) {
        return this._nextSegment != null && this._matchingPropertyName.equals(str);
    }

    public boolean mayMatchElement() {
        return this._matchingElementIndex >= 0;
    }

    public boolean mayMatchProperty() {
        return this._matchingPropertyName != null;
    }

    public JsonPointer tail() {
        return this._nextSegment;
    }

    public String toString() {
        int i = this._asStringOffset;
        return i <= 0 ? this._asString : this._asString.substring(i);
    }

    protected JsonPointer(String str, int i, String str2, JsonPointer jsonPointer) {
        this._asString = str;
        this._asStringOffset = i;
        this._nextSegment = jsonPointer;
        this._matchingPropertyName = str2;
        this._matchingElementIndex = _parseIndex(str2);
    }

    protected JsonPointer _constructHead(int i, JsonPointer jsonPointer) {
        if (this == jsonPointer) {
            return EMPTY;
        }
        JsonPointer jsonPointer2 = this._nextSegment;
        String string = toString();
        return new JsonPointer(string.substring(0, string.length() - i), 0, this._matchingPropertyName, this._matchingElementIndex, jsonPointer2._constructHead(i, jsonPointer));
    }

    protected JsonPointer(String str, int i, String str2, int i2, JsonPointer jsonPointer) {
        this._asString = str;
        this._asStringOffset = i;
        this._nextSegment = jsonPointer;
        this._matchingPropertyName = str2;
        this._matchingElementIndex = i2;
    }
}
