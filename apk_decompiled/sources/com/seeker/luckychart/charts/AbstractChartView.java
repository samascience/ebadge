package com.seeker.luckychart.charts;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.seeker.luckychart.animation.ChartCoordinateportAnimatorImpl;
import com.seeker.luckychart.computator.ChartComputator;
import com.seeker.luckychart.gesture.AbstractTouchHandler;
import com.seeker.luckychart.gesture.ChartTouchHandler;
import com.seeker.luckychart.model.Coordinateport;
import com.seeker.luckychart.provider.ChartProvider;
import com.seeker.luckychart.provider.DataProvider;
import com.seeker.luckychart.render.inters.LuckyAxesRenderer;
import com.seeker.luckychart.render.inters.LuckyDataRenderer;
import com.seeker.luckychart.strategy.DefaultStrategyFactory;
import com.seeker.luckychart.strategy.doubletab.DoubleTap;
import com.seeker.luckychart.strategy.press.LongPress;
import com.seeker.luckychart.strategy.scale.Scaler;
import com.seeker.luckychart.strategy.scroll.Scroller;
import com.seeker.luckychart.utils.ChartLogger;
import javax.microedition.khronos.opengles.GL10;
import org.rajawali3d.cameras.Camera2D;
import org.rajawali3d.renderer.Renderer;
import org.rajawali3d.scene.ASceneFrameCallback;
import org.rajawali3d.view.IDisplay;
import org.rajawali3d.view.ISurface;
import org.rajawali3d.view.SurfaceView;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractChartView<ChartData extends DataProvider> extends SurfaceView implements IDisplay, ChartProvider<ChartData> {
    private static final String TAG = "AbstractChartView";
    private final Runnable ASYNTASK;
    protected LuckyAxesRenderer axesRenderer;
    protected int backgroundColor;
    protected ChartComputator chartComputator;
    private ChartCoordinateportAnimatorImpl chartCoordinateportAnimator;
    protected ChartData chartData;
    protected AbstractChartView<ChartData>.LuckyChartRenderer chartRenderer;
    protected LuckyDataRenderer dataRenderer;
    private DefaultStrategyFactory defaultStrategyFactory;
    protected FrameRenderCallback frameRenderCallback;
    protected boolean isTouchable;
    protected Context mContext;
    protected AbstractTouchHandler touchHandler;

    private static final class DummpyFrameRenderCallback implements FrameRenderCallback {
        private DummpyFrameRenderCallback() {
        }

        @Override // com.seeker.luckychart.charts.AbstractChartView.FrameRenderCallback
        public void onPrepareNextFrame(long j) {
        }
    }

    public interface FrameRenderCallback {
        void onPrepareNextFrame(long j);
    }

    public final class LuckyChartRenderer extends Renderer {
        private Camera2D camera2D;

        LuckyChartRenderer(AbstractChartView abstractChartView, Context context, ASceneFrameCallback aSceneFrameCallback) {
            this(context, false, aSceneFrameCallback);
        }

        public Camera2D getCamera2D() {
            return this.camera2D;
        }

        protected void initScene() {
            ChartLogger.vTag(AbstractChartView.TAG, "initScene() called...");
            LuckyAxesRenderer luckyAxesRenderer = AbstractChartView.this.axesRenderer;
            if (luckyAxesRenderer != null) {
                luckyAxesRenderer.initScene();
            }
            LuckyDataRenderer luckyDataRenderer = AbstractChartView.this.dataRenderer;
            if (luckyDataRenderer != null) {
                luckyDataRenderer.initScene();
            }
        }

        public void onOffsetsChanged(float f, float f2, float f3, float f4, int i, int i2) {
        }

        protected void onRender(long j, double d) {
            if (AbstractChartView.this.getRenderMode() == 1) {
                AbstractChartView.this.onAsynWorkForNextRender();
            }
            super.onRender(j, d);
            AbstractChartView.this.onAsyRenderUpdateLagWork();
        }

        public void onRenderSurfaceSizeChanged(GL10 gl10, int i, int i2) {
            super.onRenderSurfaceSizeChanged(gl10, i, i2);
            ChartLogger.vTag(AbstractChartView.TAG, "onRenderSurfaceSizeChanged() called：width = " + i + ",height = " + i2);
            if (AbstractChartView.this.chartComputator.onChartSizeChanged(i, i2)) {
                AbstractChartView.this.chartComputator.setChartFactSize(i, i2);
                LuckyAxesRenderer luckyAxesRenderer = AbstractChartView.this.axesRenderer;
                if (luckyAxesRenderer != null) {
                    luckyAxesRenderer.onChartSizeChanged();
                }
                LuckyDataRenderer luckyDataRenderer = AbstractChartView.this.dataRenderer;
                if (luckyDataRenderer != null) {
                    luckyDataRenderer.onChartSizeChanged();
                }
            }
        }

        public void onTouchEvent(MotionEvent motionEvent) {
        }

        LuckyChartRenderer(Context context, boolean z, ASceneFrameCallback aSceneFrameCallback) {
            super(context, z);
            Camera2D camera2D = new Camera2D();
            this.camera2D = camera2D;
            camera2D.setWidth(2.0d);
            this.camera2D.setHeight(1.0d);
            this.camera2D.setPosition(0.0d, 0.0d, 2.0d);
            this.camera2D.enableLookAt();
            getCurrentScene().switchCamera(this.camera2D);
            getCurrentScene().setBackgroundColor(AbstractChartView.this.backgroundColor);
            if (aSceneFrameCallback != null) {
                getCurrentScene().registerFrameCallback(aSceneFrameCallback);
            }
        }
    }

    public AbstractChartView(Context context) {
        super(context);
        this.isTouchable = false;
        this.frameRenderCallback = new DummpyFrameRenderCallback();
        this.backgroundColor = Color.parseColor("#1C1B21");
        this.ASYNTASK = new Runnable() { // from class: com.seeker.luckychart.charts.AbstractChartView.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractChartView.this.onAsynWorkForNextRender();
            }
        };
        this.mContext = context;
        initialize();
    }

    private void initialize() {
        setAntiAliasingMode(ISurface.ANTI_ALIASING_CONFIG.MULTISAMPLING);
        setSampleCount(2);
        this.chartCoordinateportAnimator = ChartCoordinateportAnimatorImpl.create(this);
        this.chartComputator = ChartComputator.create(this.mContext);
        this.chartRenderer = m64createRenderer();
        this.axesRenderer = getChartAxesRenderer();
        this.dataRenderer = getChartDataRenderer();
        this.chartComputator.setChartRenderer(this.chartRenderer);
        this.touchHandler = new ChartTouchHandler(this);
        setSurfaceRenderer(this.chartRenderer);
        this.defaultStrategyFactory = DefaultStrategyFactory.create(this);
    }

    public void applyRenderUpdate() {
        queueEvent(this.ASYNTASK);
        requestRenderUpdate();
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public void clearChartData() {
        ChartData chartdata = this.chartData;
        if (chartdata != null) {
            chartdata.clear();
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.isTouchable && this.touchHandler.computeScroll()) {
            applyRenderUpdate();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AbstractTouchHandler abstractTouchHandler = this.touchHandler;
        if (abstractTouchHandler != null) {
            abstractTouchHandler.dispatchTouchEvent(motionEvent, getParent());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ASceneFrameCallback getASceneFrameCallback() {
        return null;
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public ChartComputator getChartComputator() {
        return this.chartComputator;
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public ChartData getChartData() {
        return this.chartData;
    }

    @Override // com.seeker.luckychart.provider.RenderProvider
    public Renderer getChartGlRenderer() {
        return this.chartRenderer;
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public Context getContexter() {
        return getContext();
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public DoubleTap getDoubleTab() {
        return this.defaultStrategyFactory.getDoubleTab();
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public LongPress getLongpresser() {
        return this.defaultStrategyFactory.getLongpresser();
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public Scaler getScaler() {
        return this.defaultStrategyFactory.getScaler();
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public Scroller getScrollImpl() {
        return this.defaultStrategyFactory.getScrollImpl();
    }

    public void onAsyRenderUpdateLagWork() {
    }

    public void onAsynWorkForNextRender() {
        this.frameRenderCallback.onPrepareNextFrame(0L);
        LuckyDataRenderer luckyDataRenderer = this.dataRenderer;
        if (luckyDataRenderer != null) {
            luckyDataRenderer.onDataRender();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!this.isTouchable) {
            return false;
        }
        if (!this.touchHandler.handleTouchEvent(motionEvent, getParent())) {
            return true;
        }
        applyRenderUpdate();
        return true;
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public void setChartData(ChartData chartdata) {
        this.chartData = chartdata;
        LuckyAxesRenderer luckyAxesRenderer = this.axesRenderer;
        if (luckyAxesRenderer != null) {
            luckyAxesRenderer.onChartDataChanged();
        }
        LuckyDataRenderer luckyDataRenderer = this.dataRenderer;
        if (luckyDataRenderer != null) {
            luckyDataRenderer.onChartDataChanged();
        }
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public void setChartMaxCoordinateport(Coordinateport coordinateport) {
        this.chartComputator.setMaxCoorport(coordinateport);
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public void setChartVisibleCoordinateport(Coordinateport coordinateport) {
        this.chartComputator.setVisibleCoorport(coordinateport);
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public void setChartVisibleCoordinateportWithAnim(Coordinateport coordinateport, long j) {
        this.chartCoordinateportAnimator.cancelAnimation();
        this.chartCoordinateportAnimator.startAnimation(this.chartComputator.getVisibleCoorport(), coordinateport, j);
    }

    public void setFrameRenderCallback(FrameRenderCallback frameRenderCallback) {
        this.frameRenderCallback = frameRenderCallback;
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public void setTouchable(boolean z) {
        this.isTouchable = z;
    }

    /* JADX INFO: renamed from: createRenderer, reason: merged with bridge method [inline-methods] */
    public AbstractChartView<ChartData>.LuckyChartRenderer m64createRenderer() {
        return new LuckyChartRenderer(this, this.mContext, getASceneFrameCallback());
    }

    public AbstractChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isTouchable = false;
        this.frameRenderCallback = new DummpyFrameRenderCallback();
        this.backgroundColor = Color.parseColor("#1C1B21");
        this.ASYNTASK = new Runnable() { // from class: com.seeker.luckychart.charts.AbstractChartView.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractChartView.this.onAsynWorkForNextRender();
            }
        };
        this.mContext = context;
        initialize();
    }
}
