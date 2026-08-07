package defpackage;

import java.util.List;
import java.util.Map;
import kotlin.reflect.KVisibility;

/* JADX INFO: loaded from: classes4.dex */
public interface g81 extends f81 {
    Object call(Object... objArr);

    Object callBy(Map map);

    List getParameters();

    u81 getReturnType();

    List getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
