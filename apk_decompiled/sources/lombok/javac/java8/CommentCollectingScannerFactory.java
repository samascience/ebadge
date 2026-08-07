package lombok.javac.java8;

import com.sun.tools.javac.parser.Scanner;
import com.sun.tools.javac.parser.ScannerFactory;
import com.sun.tools.javac.util.Context;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/javac/java8/CommentCollectingScannerFactory.SCL.lombok */
public class CommentCollectingScannerFactory extends ScannerFactory {
    public static boolean findTextBlocks;

    public static void preRegister(final Context context) {
        if (context.get(scannerFactoryKey) == null) {
            Context.Factory<ScannerFactory> factory = new Context.Factory() { // from class: lombok.javac.java8.CommentCollectingScannerFactory.1MyFactory
                public Object make() {
                    return new CommentCollectingScannerFactory(context);
                }

                public Object make(Context c) {
                    return new CommentCollectingScannerFactory(c);
                }
            };
            context.put(scannerFactoryKey, factory);
        }
    }

    protected CommentCollectingScannerFactory(Context context) {
        super(context);
    }

    public Scanner newScanner(CharSequence input, boolean keepDocComments) {
        char[] array;
        int limit;
        if ((input instanceof CharBuffer) && ((CharBuffer) input).hasArray()) {
            CharBuffer cb = (CharBuffer) input;
            cb.compact().flip();
            array = cb.array();
            limit = cb.limit();
        } else {
            array = input.toString().toCharArray();
            limit = array.length;
        }
        if (array.length == limit) {
            char[] d = new char[limit + 1];
            System.arraycopy(array, 0, d, 0, limit);
            array = d;
        }
        return newScanner(array, limit, keepDocComments);
    }

    public Scanner newScanner(char[] input, int inputLength, boolean keepDocComments) {
        return new CommentCollectingScanner(this, CommentCollectingTokenizer.create(this, input, inputLength, findTextBlocks));
    }
}
