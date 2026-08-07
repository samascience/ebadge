package kotlinx.coroutines.time;

import defpackage.ar0;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectBuilder;

/* JADX INFO: loaded from: classes4.dex */
public final class TimeKt {
    private static final long coerceToMillis(Duration duration) {
        if (duration.compareTo(Duration.ZERO) <= 0) {
            return 0L;
        }
        if (duration.compareTo(ChronoUnit.MILLIS.getDuration()) <= 0) {
            return 1L;
        }
        if (duration.getSeconds() < 9223372036854775L || (duration.getSeconds() == 9223372036854775L && duration.getNano() < 807000000)) {
            return duration.toMillis();
        }
        return Long.MAX_VALUE;
    }

    @FlowPreview
    public static final <T> Flow<T> debounce(Flow<? extends T> flow, Duration duration) {
        return FlowKt.debounce(flow, coerceToMillis(duration));
    }

    public static final Object delay(Duration duration, x30 x30Var) {
        Object objDelay = DelayKt.delay(coerceToMillis(duration), x30Var);
        return objDelay == a.d() ? objDelay : k83.a;
    }

    public static final <R> void onTimeout(SelectBuilder<? super R> selectBuilder, Duration duration, ar0 ar0Var) {
        OnTimeoutKt.onTimeout(selectBuilder, coerceToMillis(duration), ar0Var);
    }

    @FlowPreview
    public static final <T> Flow<T> sample(Flow<? extends T> flow, Duration duration) {
        return FlowKt.sample(flow, coerceToMillis(duration));
    }

    public static final <T> Object withTimeout(Duration duration, or0 or0Var, x30 x30Var) {
        return TimeoutKt.withTimeout(coerceToMillis(duration), or0Var, x30Var);
    }

    public static final <T> Object withTimeoutOrNull(Duration duration, or0 or0Var, x30 x30Var) {
        return TimeoutKt.withTimeoutOrNull(coerceToMillis(duration), or0Var, x30Var);
    }
}
