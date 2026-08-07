package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.b21;
import defpackage.e31;
import defpackage.h81;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.qr0;
import defpackage.rm2;
import defpackage.rr0;
import defpackage.sr0;
import defpackage.tr0;
import defpackage.x30;
import defpackage.xd1;
import defpackage.yq0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt {
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    public static final <T> Flow<T> asFlow(yq0 yq0Var) {
        return FlowKt__BuildersKt.asFlow(yq0Var);
    }

    public static final <T> SharedFlow<T> asSharedFlow(MutableSharedFlow<T> mutableSharedFlow) {
        return FlowKt__ShareKt.asSharedFlow(mutableSharedFlow);
    }

    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> mutableStateFlow) {
        return FlowKt__ShareKt.asStateFlow(mutableStateFlow);
    }

    public static final <T> Flow<T> cache(Flow<? extends T> flow) {
        return FlowKt__MigrationKt.cache(flow);
    }

    public static final <T> Flow<T> callbackFlow(or0 or0Var) {
        return FlowKt__BuildersKt.callbackFlow(or0Var);
    }

    public static final <T> Flow<T> cancellable(Flow<? extends T> flow) {
        return FlowKt__ContextKt.cancellable(flow);
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public static final <T> Flow<T> m123catch(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt__ErrorsKt.m134catch(flow, pr0Var);
    }

    public static final <T> Object catchImpl(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, x30 x30Var) {
        return FlowKt__ErrorsKt.catchImpl(flow, flowCollector, x30Var);
    }

    public static final <T> Flow<T> channelFlow(or0 or0Var) {
        return FlowKt__BuildersKt.channelFlow(or0Var);
    }

    public static final Object collect(Flow<?> flow, x30 x30Var) {
        return FlowKt__CollectKt.collect(flow, x30Var);
    }

    public static final <T> Object collectIndexed(Flow<? extends T> flow, pr0 pr0Var, x30 x30Var) {
        return FlowKt__CollectKt.collectIndexed(flow, pr0Var, x30Var);
    }

    public static final <T> Object collectLatest(Flow<? extends T> flow, or0 or0Var, x30 x30Var) {
        return FlowKt__CollectKt.collectLatest(flow, or0Var, x30Var);
    }

    public static final <T> Object collectWhile(Flow<? extends T> flow, or0 or0Var, x30 x30Var) {
        return FlowKt__LimitKt.collectWhile(flow, or0Var, x30Var);
    }

    public static final <T1, T2, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, pr0 pr0Var) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, pr0Var);
    }

    public static final <T, R> Flow<R> compose(Flow<? extends T> flow, ar0 ar0Var) {
        return FlowKt__MigrationKt.compose(flow, ar0Var);
    }

    public static final <T, R> Flow<R> concatMap(Flow<? extends T> flow, ar0 ar0Var) {
        return FlowKt__MigrationKt.concatMap(flow, ar0Var);
    }

    public static final <T> Flow<T> concatWith(Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.concatWith(flow, t);
    }

    public static final <T> Flow<T> conflate(Flow<? extends T> flow) {
        return FlowKt__ContextKt.conflate(flow);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.consumeAsFlow(receiveChannel);
    }

    public static final <T> Object count(Flow<? extends T> flow, x30 x30Var) {
        return FlowKt__CountKt.count(flow, x30Var);
    }

    @FlowPreview
    public static final <T> Flow<T> debounce(Flow<? extends T> flow, long j) {
        return FlowKt__DelayKt.debounce(flow, j);
    }

    @FlowPreview
    /* JADX INFO: renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m124debounceHG0u8IE(Flow<? extends T> flow, long j) {
        return FlowKt__DelayKt.m127debounceHG0u8IE(flow, j);
    }

    @FlowPreview
    public static final <T> Flow<T> debounceDuration(Flow<? extends T> flow, ar0 ar0Var) {
        return FlowKt__DelayKt.debounceDuration(flow, ar0Var);
    }

    public static final <T> Flow<T> delayEach(Flow<? extends T> flow, long j) {
        return FlowKt__MigrationKt.delayEach(flow, j);
    }

    public static final <T> Flow<T> delayFlow(Flow<? extends T> flow, long j) {
        return FlowKt__MigrationKt.delayFlow(flow, j);
    }

    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> flow) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow);
    }

    public static final <T, K> Flow<T> distinctUntilChangedBy(Flow<? extends T> flow, ar0 ar0Var) {
        return FlowKt__DistinctKt.distinctUntilChangedBy(flow, ar0Var);
    }

    public static final <T> Flow<T> drop(Flow<? extends T> flow, int i) {
        return FlowKt__LimitKt.drop(flow, i);
    }

    public static final <T> Flow<T> dropWhile(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__LimitKt.dropWhile(flow, or0Var);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, x30 x30Var) {
        return FlowKt__ChannelsKt.emitAll(flowCollector, receiveChannel, x30Var);
    }

    public static final <T> Flow<T> emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    public static final void ensureActive(FlowCollector<?> flowCollector) {
        FlowKt__EmittersKt.ensureActive(flowCollector);
    }

    public static final <T> Flow<T> filter(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__TransformKt.filter(flow, or0Var);
    }

    public static final <T> Flow<T> filterNot(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__TransformKt.filterNot(flow, or0Var);
    }

    public static final <T> Flow<T> filterNotNull(Flow<? extends T> flow) {
        return FlowKt__TransformKt.filterNotNull(flow);
    }

    public static final <T> Object first(Flow<? extends T> flow, x30 x30Var) {
        return FlowKt__ReduceKt.first(flow, x30Var);
    }

    public static final <T> Object firstOrNull(Flow<? extends T> flow, x30 x30Var) {
        return FlowKt__ReduceKt.firstOrNull(flow, x30Var);
    }

    public static final ReceiveChannel<k83> fixedPeriodTicker(CoroutineScope coroutineScope, long j, long j2) {
        return FlowKt__DelayKt.fixedPeriodTicker(coroutineScope, j, j2);
    }

    public static final <T, R> Flow<R> flatMap(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__MigrationKt.flatMap(flow, or0Var);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> flatMapConcat(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__MergeKt.flatMapConcat(flow, or0Var);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> flatMapLatest(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__MergeKt.flatMapLatest(flow, or0Var);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> flatMapMerge(Flow<? extends T> flow, int i, or0 or0Var) {
        return FlowKt__MergeKt.flatMapMerge(flow, i, or0Var);
    }

    public static final <T> Flow<T> flatten(Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.flatten(flow);
    }

    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> flattenConcat(Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MergeKt.flattenConcat(flow);
    }

    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> flattenMerge(Flow<? extends Flow<? extends T>> flow, int i) {
        return FlowKt__MergeKt.flattenMerge(flow, i);
    }

    public static final <T> Flow<T> flow(or0 or0Var) {
        return FlowKt__BuildersKt.flow(or0Var);
    }

    public static final <T1, T2, R> Flow<R> flowCombine(Flow<? extends T1> flow, Flow<? extends T2> flow2, pr0 pr0Var) {
        return FlowKt__ZipKt.flowCombine(flow, flow2, pr0Var);
    }

    public static final <T1, T2, R> Flow<R> flowCombineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, qr0 qr0Var) {
        return FlowKt__ZipKt.flowCombineTransform(flow, flow2, qr0Var);
    }

    public static final <T> Flow<T> flowOf(T t) {
        return FlowKt__BuildersKt.flowOf(t);
    }

    public static final <T> Flow<T> flowOn(Flow<? extends T> flow, d dVar) {
        return FlowKt__ContextKt.flowOn(flow, dVar);
    }

    public static final <T, R> Object fold(Flow<? extends T> flow, R r, pr0 pr0Var, x30 x30Var) {
        return FlowKt__ReduceKt.fold(flow, r, pr0Var, x30Var);
    }

    public static final <T> void forEach(Flow<? extends T> flow, or0 or0Var) {
        FlowKt__MigrationKt.forEach(flow, or0Var);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
    }

    public static final <T> Object last(Flow<? extends T> flow, x30 x30Var) {
        return FlowKt__ReduceKt.last(flow, x30Var);
    }

    public static final <T> Object lastOrNull(Flow<? extends T> flow, x30 x30Var) {
        return FlowKt__ReduceKt.lastOrNull(flow, x30Var);
    }

    public static final <T> Job launchIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        return FlowKt__CollectKt.launchIn(flow, coroutineScope);
    }

    public static final <T, R> Flow<R> map(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__TransformKt.map(flow, or0Var);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> mapLatest(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__MergeKt.mapLatest(flow, or0Var);
    }

    public static final <T, R> Flow<R> mapNotNull(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__TransformKt.mapNotNull(flow, or0Var);
    }

    public static final <T> Flow<T> merge(Iterable<? extends Flow<? extends T>> iterable) {
        return FlowKt__MergeKt.merge(iterable);
    }

    public static final Void noImpl() {
        return FlowKt__MigrationKt.noImpl();
    }

    public static final <T> Flow<T> observeOn(Flow<? extends T> flow, d dVar) {
        return FlowKt__MigrationKt.observeOn(flow, dVar);
    }

    public static final <T> Flow<T> onCompletion(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt__EmittersKt.onCompletion(flow, pr0Var);
    }

    public static final <T> Flow<T> onEach(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__TransformKt.onEach(flow, or0Var);
    }

    public static final <T> Flow<T> onEmpty(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__EmittersKt.onEmpty(flow, or0Var);
    }

    public static final <T> Flow<T> onErrorResume(Flow<? extends T> flow, Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.onErrorResume(flow, flow2);
    }

    public static final <T> Flow<T> onErrorResumeNext(Flow<? extends T> flow, Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.onErrorResumeNext(flow, flow2);
    }

    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.onErrorReturn(flow, t);
    }

    public static final <T> Flow<T> onStart(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__EmittersKt.onStart(flow, or0Var);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> sharedFlow, or0 or0Var) {
        return FlowKt__ShareKt.onSubscription(sharedFlow, or0Var);
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        return FlowKt__ChannelsKt.produceIn(flow, coroutineScope);
    }

    public static final <T> Flow<T> publish(Flow<? extends T> flow) {
        return FlowKt__MigrationKt.publish(flow);
    }

    public static final <T> Flow<T> publishOn(Flow<? extends T> flow, d dVar) {
        return FlowKt__MigrationKt.publishOn(flow, dVar);
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.receiveAsFlow(receiveChannel);
    }

    public static final <S, T extends S> Object reduce(Flow<? extends T> flow, pr0 pr0Var, x30 x30Var) {
        return FlowKt__ReduceKt.reduce(flow, pr0Var, x30Var);
    }

    public static final <T> Flow<T> replay(Flow<? extends T> flow) {
        return FlowKt__MigrationKt.replay(flow);
    }

    public static final <T> Flow<T> retry(Flow<? extends T> flow, long j, or0 or0Var) {
        return FlowKt__ErrorsKt.retry(flow, j, or0Var);
    }

    public static final <T> Flow<T> retryWhen(Flow<? extends T> flow, qr0 qr0Var) {
        return FlowKt__ErrorsKt.retryWhen(flow, qr0Var);
    }

    public static final <T, R> Flow<R> runningFold(Flow<? extends T> flow, R r, pr0 pr0Var) {
        return FlowKt__TransformKt.runningFold(flow, r, pr0Var);
    }

    public static final <T> Flow<T> runningReduce(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt__TransformKt.runningReduce(flow, pr0Var);
    }

    @FlowPreview
    public static final <T> Flow<T> sample(Flow<? extends T> flow, long j) {
        return FlowKt__DelayKt.sample(flow, j);
    }

    @FlowPreview
    /* JADX INFO: renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m125sampleHG0u8IE(Flow<? extends T> flow, long j) {
        return FlowKt__DelayKt.m128sampleHG0u8IE(flow, j);
    }

    public static final <T, R> Flow<R> scan(Flow<? extends T> flow, R r, pr0 pr0Var) {
        return FlowKt__TransformKt.scan(flow, r, pr0Var);
    }

    public static final <T, R> Flow<R> scanFold(Flow<? extends T> flow, R r, pr0 pr0Var) {
        return FlowKt__MigrationKt.scanFold(flow, r, pr0Var);
    }

    public static final <T> Flow<T> scanReduce(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt__MigrationKt.scanReduce(flow, pr0Var);
    }

    public static final <T> SharedFlow<T> shareIn(Flow<? extends T> flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i) {
        return FlowKt__ShareKt.shareIn(flow, coroutineScope, sharingStarted, i);
    }

    public static final <T> Object single(Flow<? extends T> flow, x30 x30Var) {
        return FlowKt__ReduceKt.single(flow, x30Var);
    }

    public static final <T> Object singleOrNull(Flow<? extends T> flow, x30 x30Var) {
        return FlowKt__ReduceKt.singleOrNull(flow, x30Var);
    }

    public static final <T> Flow<T> skip(Flow<? extends T> flow, int i) {
        return FlowKt__MigrationKt.skip(flow, i);
    }

    public static final <T> Flow<T> startWith(Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.startWith(flow, t);
    }

    public static final <T> Object stateIn(Flow<? extends T> flow, CoroutineScope coroutineScope, x30 x30Var) {
        return FlowKt__ShareKt.stateIn(flow, coroutineScope, x30Var);
    }

    public static final <T> void subscribe(Flow<? extends T> flow) {
        FlowKt__MigrationKt.subscribe(flow);
    }

    public static final <T> Flow<T> subscribeOn(Flow<? extends T> flow, d dVar) {
        return FlowKt__MigrationKt.subscribeOn(flow, dVar);
    }

    public static final <T, R> Flow<R> switchMap(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__MigrationKt.switchMap(flow, or0Var);
    }

    public static final <T> Flow<T> take(Flow<? extends T> flow, int i) {
        return FlowKt__LimitKt.take(flow, i);
    }

    public static final <T> Flow<T> takeWhile(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__LimitKt.takeWhile(flow, or0Var);
    }

    @FlowPreview
    /* JADX INFO: renamed from: timeout-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m126timeoutHG0u8IE(Flow<? extends T> flow, long j) {
        return FlowKt__DelayKt.m129timeoutHG0u8IE(flow, j);
    }

    public static final <T, C extends Collection<? super T>> Object toCollection(Flow<? extends T> flow, C c, x30 x30Var) {
        return FlowKt__CollectionKt.toCollection(flow, c, x30Var);
    }

    public static final <T> Object toList(Flow<? extends T> flow, List<T> list, x30 x30Var) {
        return FlowKt__CollectionKt.toList(flow, list, x30Var);
    }

    public static final <T> Object toSet(Flow<? extends T> flow, Set<T> set, x30 x30Var) {
        return FlowKt__CollectionKt.toSet(flow, set, x30Var);
    }

    public static final <T, R> Flow<R> transform(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt__EmittersKt.transform(flow, pr0Var);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> transformLatest(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt__MergeKt.transformLatest(flow, pr0Var);
    }

    public static final <T, R> Flow<R> transformWhile(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt__LimitKt.transformWhile(flow, pr0Var);
    }

    public static final <T, R> Flow<R> unsafeTransform(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt__EmittersKt.unsafeTransform(flow, pr0Var);
    }

    public static final <T> Flow<b21> withIndex(Flow<? extends T> flow) {
        return FlowKt__TransformKt.withIndex(flow);
    }

    public static final <T1, T2, R> Flow<R> zip(Flow<? extends T1> flow, Flow<? extends T2> flow2, pr0 pr0Var) {
        return FlowKt__ZipKt.zip(flow, flow2, pr0Var);
    }

    public static final <T> Flow<T> asFlow(ar0 ar0Var) {
        return FlowKt__BuildersKt.asFlow(ar0Var);
    }

    public static final <T> Flow<T> buffer(Flow<? extends T> flow, int i, BufferOverflow bufferOverflow) {
        return FlowKt__ContextKt.buffer(flow, i, bufferOverflow);
    }

    public static final <T1, T2, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, pr0 pr0Var) {
        return FlowKt__ZipKt.combine(flow, flow2, pr0Var);
    }

    public static final <T1, T2, T3, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, qr0 qr0Var) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, qr0Var);
    }

    public static final <T1, T2, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, qr0 qr0Var) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, qr0Var);
    }

    public static final <T> Flow<T> concatWith(Flow<? extends T> flow, Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.concatWith((Flow) flow, (Flow) flow2);
    }

    public static final <T> Object count(Flow<? extends T> flow, or0 or0Var, x30 x30Var) {
        return FlowKt__CountKt.count(flow, or0Var, x30Var);
    }

    @FlowPreview
    public static final <T> Flow<T> debounce(Flow<? extends T> flow, ar0 ar0Var) {
        return FlowKt__DelayKt.debounce(flow, ar0Var);
    }

    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow, or0Var);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, Flow<? extends T> flow, x30 x30Var) {
        return FlowKt__CollectKt.emitAll(flowCollector, flow, x30Var);
    }

    public static final <R> Flow<R> filterIsInstance(Flow<?> flow, h81 h81Var) {
        return FlowKt__TransformKt.filterIsInstance(flow, h81Var);
    }

    public static final <T> Object first(Flow<? extends T> flow, or0 or0Var, x30 x30Var) {
        return FlowKt__ReduceKt.first(flow, or0Var, x30Var);
    }

    public static final <T> Object firstOrNull(Flow<? extends T> flow, or0 or0Var, x30 x30Var) {
        return FlowKt__ReduceKt.firstOrNull(flow, or0Var, x30Var);
    }

    public static final <T> Flow<T> flowOf(T... tArr) {
        return FlowKt__BuildersKt.flowOf((Object[]) tArr);
    }

    public static final <T> Flow<T> merge(Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.merge(flow);
    }

    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t, ar0 ar0Var) {
        return FlowKt__MigrationKt.onErrorReturn(flow, t, ar0Var);
    }

    public static final <T> Flow<T> publish(Flow<? extends T> flow, int i) {
        return FlowKt__MigrationKt.publish(flow, i);
    }

    public static final <T> Flow<T> replay(Flow<? extends T> flow, int i) {
        return FlowKt__MigrationKt.replay(flow, i);
    }

    public static final <T> Flow<T> startWith(Flow<? extends T> flow, Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.startWith((Flow) flow, (Flow) flow2);
    }

    public static final <T> StateFlow<T> stateIn(Flow<? extends T> flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, T t) {
        return FlowKt__ShareKt.stateIn(flow, coroutineScope, sharingStarted, t);
    }

    public static final <T> void subscribe(Flow<? extends T> flow, or0 or0Var) {
        FlowKt__MigrationKt.subscribe(flow, or0Var);
    }

    public static final Flow<Integer> asFlow(e31 e31Var) {
        return FlowKt__BuildersKt.asFlow(e31Var);
    }

    public static final <T1, T2, T3, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, qr0 qr0Var) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, qr0Var);
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, rr0 rr0Var) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, flow4, rr0Var);
    }

    public static final <T1, T2, T3, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, rr0 rr0Var) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, rr0Var);
    }

    public static final <T> Flow<T> merge(Flow<? extends T>... flowArr) {
        return FlowKt__MergeKt.merge(flowArr);
    }

    public static final <T> void subscribe(Flow<? extends T> flow, or0 or0Var, or0 or0Var2) {
        FlowKt__MigrationKt.subscribe(flow, or0Var, or0Var2);
    }

    public static final Flow<Long> asFlow(xd1 xd1Var) {
        return FlowKt__BuildersKt.asFlow(xd1Var);
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, rr0 rr0Var) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, rr0Var);
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, sr0 sr0Var) {
        return FlowKt__MigrationKt.combineLatest(flow, flow2, flow3, flow4, flow5, sr0Var);
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, sr0 sr0Var) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, sr0Var);
    }

    public static final <T> Flow<T> asFlow(rm2 rm2Var) {
        return FlowKt__BuildersKt.asFlow(rm2Var);
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, sr0 sr0Var) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, flow5, sr0Var);
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, tr0 tr0Var) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, flow5, tr0Var);
    }

    public static final <T> Flow<T> asFlow(Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.asFlow(iterable);
    }

    public static final <T> Flow<T> asFlow(Iterator<? extends T> it) {
        return FlowKt__BuildersKt.asFlow(it);
    }

    public static final <T> Flow<T> asFlow(BroadcastChannel<T> broadcastChannel) {
        return FlowKt__ChannelsKt.asFlow(broadcastChannel);
    }

    public static final Flow<Integer> asFlow(int[] iArr) {
        return FlowKt__BuildersKt.asFlow(iArr);
    }

    public static final Flow<Long> asFlow(long[] jArr) {
        return FlowKt__BuildersKt.asFlow(jArr);
    }

    public static final <T> Flow<T> asFlow(T[] tArr) {
        return FlowKt__BuildersKt.asFlow(tArr);
    }
}
