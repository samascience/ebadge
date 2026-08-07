package defpackage;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: loaded from: classes.dex */
public abstract class ac0 {
    public static final ac0 a = new a();
    public static final ac0 b = new b();
    public static final ac0 c = new c();
    public static final ac0 d = new d();
    public static final ac0 e = new e();

    class a extends ac0 {
        a() {
        }

        @Override // defpackage.ac0
        public boolean a() {
            return true;
        }

        @Override // defpackage.ac0
        public boolean b() {
            return true;
        }

        @Override // defpackage.ac0
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // defpackage.ac0
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    class b extends ac0 {
        b() {
        }

        @Override // defpackage.ac0
        public boolean a() {
            return false;
        }

        @Override // defpackage.ac0
        public boolean b() {
            return false;
        }

        @Override // defpackage.ac0
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // defpackage.ac0
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    class c extends ac0 {
        c() {
        }

        @Override // defpackage.ac0
        public boolean a() {
            return true;
        }

        @Override // defpackage.ac0
        public boolean b() {
            return false;
        }

        @Override // defpackage.ac0
        public boolean c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // defpackage.ac0
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    class d extends ac0 {
        d() {
        }

        @Override // defpackage.ac0
        public boolean a() {
            return false;
        }

        @Override // defpackage.ac0
        public boolean b() {
            return true;
        }

        @Override // defpackage.ac0
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // defpackage.ac0
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    class e extends ac0 {
        e() {
        }

        @Override // defpackage.ac0
        public boolean a() {
            return true;
        }

        @Override // defpackage.ac0
        public boolean b() {
            return true;
        }

        @Override // defpackage.ac0
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // defpackage.ac0
        public boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
