package defpackage;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.MergePaths;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class vi1 {
    static MergePaths a(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        MergePaths.MergePathsMode mergePathsModeForId = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(DateFormatUtils.MIN)) {
                mergePathsModeForId = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new MergePaths(strNextString, mergePathsModeForId);
    }
}
