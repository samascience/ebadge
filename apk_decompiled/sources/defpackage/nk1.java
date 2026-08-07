package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;

/* JADX INFO: loaded from: classes.dex */
public class nk1 extends wx {
    protected final String d;
    protected final String e;

    protected nk1(JavaType javaType, TypeFactory typeFactory, PolymorphicTypeValidator polymorphicTypeValidator) {
        super(javaType, typeFactory, polymorphicTypeValidator);
        String name = javaType.getRawClass().getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            this.d = Constants.STR_EMPTY;
            this.e = FileUtils.FILE_EXTENSION_SEPARATOR;
        } else {
            this.e = name.substring(0, iLastIndexOf + 1);
            this.d = name.substring(0, iLastIndexOf);
        }
    }

    public static nk1 j(JavaType javaType, MapperConfig mapperConfig, PolymorphicTypeValidator polymorphicTypeValidator) {
        return new nk1(javaType, mapperConfig.getTypeFactory(), polymorphicTypeValidator);
    }

    @Override // defpackage.wx, defpackage.n63
    public String a(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this.e) ? name.substring(this.e.length() - 1) : name;
    }

    @Override // defpackage.wx
    protected JavaType h(String str, t60 t60Var) {
        if (str.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
            StringBuilder sb = new StringBuilder(str.length() + this.d.length());
            if (this.d.isEmpty()) {
                sb.append(str.substring(1));
            } else {
                sb.append(this.d);
                sb.append(str);
            }
            str = sb.toString();
        }
        return super.h(str, t60Var);
    }
}
