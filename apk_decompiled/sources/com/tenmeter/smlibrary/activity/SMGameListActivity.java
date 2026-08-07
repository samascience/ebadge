package com.tenmeter.smlibrary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.a;
import com.bumptech.glide.e;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.adapter.GameLeisureListBannerAdapter;
import com.tenmeter.smlibrary.adapter.GameListBannerNAdapter;
import com.tenmeter.smlibrary.adapter.GameListTypeAdapter;
import com.tenmeter.smlibrary.adapter.HotListAdapter;
import com.tenmeter.smlibrary.adapter.IconListAdapter;
import com.tenmeter.smlibrary.banner.Banner;
import com.tenmeter.smlibrary.banner.adapter.BannerRoundImageAdapter;
import com.tenmeter.smlibrary.banner.holder.BannerImageHolder;
import com.tenmeter.smlibrary.banner.indicator.CircleIndicator;
import com.tenmeter.smlibrary.banner.listener.OnBannerListener;
import com.tenmeter.smlibrary.entity.SMADBean;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.listener.Consumer;
import com.tenmeter.smlibrary.listener.IADCallback;
import com.tenmeter.smlibrary.listener.IGameListBannerCallback;
import com.tenmeter.smlibrary.listener.IGameListForTypeCallback;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.listener.IIconCallback;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.utils.Utils;
import com.tenmeter.smlibrary.widget.LoadDia;
import com.tenmeter.smlibrary.widget.decoration.GridSpaceItemDecoration;
import defpackage.ac0;
import defpackage.q30;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SMGameListActivity extends Activity {
    private SMGameListParent leisureGameDatas;
    private Banner mAdBanner;
    private TextView mAdTitle;
    private ImageView mBack;
    private Banner mBannerN;
    private RecyclerView mGameRv;
    private HotListAdapter mHotAdapter;
    private LinearLayout mHotGameContainer;
    private TextView mHotName;
    private RecyclerView mHotRv;
    private IconListAdapter mIconAdapter;
    private RecyclerView mIconRv;
    private Banner mLeisureBanner;
    private LinearLayout mLeisureGameContainer;
    private TextView mLeisureMore;
    private TextView mLeisureName;
    private LoadDia mLoadDia;
    private TextView mTitle;
    private GameListTypeAdapter mTypeAdapter;

    /* JADX INFO: renamed from: com.tenmeter.smlibrary.activity.SMGameListActivity$10, reason: invalid class name */
    class AnonymousClass10 implements IADCallback {
        AnonymousClass10() {
        }

        @Override // com.tenmeter.smlibrary.listener.IADCallback
        public void onError(final String str) {
            SMGameListActivity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.10.2
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SMGameListActivity.this, str, 1).show();
                }
            });
        }

        @Override // com.tenmeter.smlibrary.listener.IADCallback
        public void onSuccessFul(final List<SMADBean> list) {
            SMGameListActivity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    List list2 = list;
                    if (list2 == null || list2.size() <= 0) {
                        SMGameListActivity.this.mAdTitle.setVisibility(8);
                        SMGameListActivity.this.mAdBanner.setVisibility(8);
                        return;
                    }
                    SMGameListActivity.this.mAdTitle.setVisibility(0);
                    SMGameListActivity.this.mAdBanner.setVisibility(0);
                    SMGameListActivity.this.mAdTitle.setText(((SMADBean) list.get(0)).getAdName());
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) SMGameListActivity.this.mAdBanner.getLayoutParams();
                    layoutParams.height = (int) ((((double) (DisplayUtil.getScreenWidth() - DisplayUtil.dp2px(44.0f))) / 664.0d) * 260.0d);
                    SMGameListActivity.this.mAdBanner.setLayoutParams(layoutParams);
                    SMGameListActivity.this.mAdBanner.setAdapter(new BannerRoundImageAdapter<SMADBean>(list) { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.10.1.2
                        @Override // com.tenmeter.smlibrary.banner.holder.IViewHolder
                        public void onBindView(BannerImageHolder bannerImageHolder, SMADBean sMADBean, int i, int i2) {
                            e eVarR = a.t(SMGameListActivity.this).r(sMADBean.getAdUrl());
                            SMGameListActivity sMGameListActivity = SMGameListActivity.this;
                            int i3 = R.drawable.default_game;
                            e eVar = (e) ((e) eVarR.V(q30.e(sMGameListActivity, i3))).i(q30.e(SMGameListActivity.this, i3));
                            ImageView imageView = bannerImageHolder.imageView;
                            ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
                            ((e) eVar.w0(new SGlideRequestListener(imageView, scaleType, scaleType)).f(ac0.d)).u0(bannerImageHolder.imageView);
                        }
                    }).setOnBannerListener(new OnBannerListener<SMADBean>() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.10.1.1
                        @Override // com.tenmeter.smlibrary.banner.listener.OnBannerListener
                        public void OnBannerClick(SMADBean sMADBean, int i) {
                            if (sMADBean.getRedirectType() == 1) {
                                SMGameListActivity.this.gameClick(sMADBean.getGame());
                                return;
                            }
                            if (sMADBean.getRedirectType() == 2) {
                                SMGameClient.getInstance().startGameListSub(sMADBean.getTag(), SMGameListActivity.this);
                                return;
                            }
                            if (sMADBean.getRedirectType() != 3 || sMADBean.getIcon() == null) {
                                return;
                            }
                            if (sMADBean.getIcon().getIconPage() == 2) {
                                SMGameListActivity.this.jumpToVip(sMADBean.getIcon());
                                return;
                            }
                            SMGameListParent sMGameListParent = new SMGameListParent();
                            sMGameListParent.setGameList(sMADBean.getIcon().getGameList());
                            sMGameListParent.setTagId(sMADBean.getIcon().getIconId());
                            sMGameListParent.setTagName(sMADBean.getIcon().getIconPageTitle());
                            SMGameClient.getInstance().startGameListSub(sMGameListParent, SMGameListActivity.this);
                        }
                    });
                    if (list.size() > 1) {
                        SMGameListActivity.this.mAdBanner.setIndicator(new CircleIndicator(SMGameListActivity.this));
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.tenmeter.smlibrary.activity.SMGameListActivity$7, reason: invalid class name */
    class AnonymousClass7 implements IGameListBannerCallback {
        AnonymousClass7() {
        }

        @Override // com.tenmeter.smlibrary.listener.IGameListBannerCallback
        public void onError(final String str) {
            SMGameListActivity.this.hideLoading();
            SMGameListActivity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.7.2
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SMGameListActivity.this, str, 1).show();
                    SMGameListActivity.this.mBannerN.setVisibility(8);
                }
            });
        }

        @Override // com.tenmeter.smlibrary.listener.IGameListBannerCallback
        public void onSuccessFul(final List<SMGameListBannerParent> list) {
            SMGameListActivity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.7.1
                @Override // java.lang.Runnable
                public void run() {
                    SMGameListActivity.this.hideLoading();
                    if (list.size() <= 0) {
                        SMGameListActivity.this.mBannerN.setVisibility(8);
                        return;
                    }
                    SMGameListActivity.this.mBannerN.setVisibility(0);
                    SMGameListActivity.this.mBannerN.setAdapter(new GameListBannerNAdapter(SMGameListActivity.this, new GameListBannerNAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.7.1.1
                        @Override // com.tenmeter.smlibrary.adapter.GameListBannerNAdapter.IGameListItemClick
                        public void itemClick(SMGameInfo sMGameInfo) {
                            SMGameListActivity.this.gameClick(sMGameInfo);
                        }
                    }, list)).setBannerGalleryEffect(0, 22, 0, 1.0f);
                    if (list.size() > 1) {
                        SMGameListActivity.this.mBannerN.setIndicator(new CircleIndicator(SMGameListActivity.this));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gameClick(SMGameInfo sMGameInfo) {
        if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
            SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(this, sMGameInfo);
        } else {
            showLoading();
            SMGameClient.getInstance().startGame(sMGameInfo, this, new IGameOpenListener() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.11
                @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                public void openResult(boolean z) {
                    SMGameListActivity.this.hideLoading();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGameTypeData() {
        SMGameClient.getInstance().getGameBannerList(new AnonymousClass7());
        SMGameClient.getInstance().getIconLists(new IIconCallback() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.8
            @Override // com.tenmeter.smlibrary.listener.IIconCallback
            public void onError(final String str) {
                SMGameListActivity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(SMGameListActivity.this, str, 1).show();
                    }
                });
            }

            @Override // com.tenmeter.smlibrary.listener.IIconCallback
            public void onSuccessFul(final List<SMIconListParent> list) {
                SMGameListActivity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SMGameListActivity.this.mIconAdapter.setData(list);
                    }
                });
            }
        });
        SMGameClient.getInstance().getTypeGameList(new IGameListForTypeCallback() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.9
            @Override // com.tenmeter.smlibrary.listener.IGameListForTypeCallback
            public void onError(final String str) {
                SMGameListActivity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(SMGameListActivity.this, str, 1).show();
                    }
                });
            }

            @Override // com.tenmeter.smlibrary.listener.IGameListForTypeCallback
            public void onSuccessFul(final List<SMGameListParent> list) {
                SMGameListActivity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (list != null) {
                            ArrayList arrayList = new ArrayList();
                            for (SMGameListParent sMGameListParent : list) {
                                if (sMGameListParent.getTagId() == 4) {
                                    SMGameListActivity.this.mHotName.setText(sMGameListParent.getTagName());
                                    SMGameListActivity.this.mHotGameContainer.setVisibility(sMGameListParent.getGameList().size() > 0 ? 0 : 8);
                                    SMGameListActivity.this.mHotAdapter.setData(sMGameListParent.getGameList());
                                } else if (sMGameListParent.getTagId() == 2) {
                                    SMGameListActivity.this.leisureGameDatas = sMGameListParent;
                                    SMGameListActivity.this.mLeisureName.setText(sMGameListParent.getTagName());
                                    SMGameListActivity.this.mLeisureMore.setText(SMGameClient.getInstance().isChina() ? "更多" : "More");
                                    SMGameListActivity.this.mLeisureGameContainer.setVisibility(sMGameListParent.getGameList().size() > 0 ? 0 : 8);
                                    SMGameListActivity.this.processLeisureGame(sMGameListParent);
                                } else {
                                    arrayList.add(sMGameListParent);
                                }
                            }
                            SMGameListActivity.this.mTypeAdapter.setData(arrayList);
                        }
                    }
                });
            }
        });
        SMGameClient.getInstance().getAD(new AnonymousClass10());
    }

    private void initData() {
        this.mTitle.setText(SMGameClient.getInstance().isChina() ? "体感游戏" : "Motion-Sensing Game");
        showLoading();
        if (SMGameClient.baseUrl.isEmpty()) {
            SMGameClient.getInstance().gamePrivate(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.6
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameListActivity.this.getGameTypeData();
                    } else {
                        SMGameListActivity.this.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SMGameListActivity.this.hideLoading();
                                Toast.makeText(SMGameListActivity.this, "data error", 1).show();
                            }
                        });
                    }
                }
            });
        } else {
            getGameTypeData();
        }
    }

    private void initView() {
        this.mAdBanner = (Banner) findViewById(R.id.ad_banner);
        this.mLeisureMore = (TextView) findViewById(R.id.tv_leisure_more);
        this.mLeisureName = (TextView) findViewById(R.id.tv_leisure_name);
        this.mHotName = (TextView) findViewById(R.id.tv_hot_title);
        this.mHotGameContainer = (LinearLayout) findViewById(R.id.ll_hot_container);
        this.mLeisureGameContainer = (LinearLayout) findViewById(R.id.ll_leisure_container);
        this.mBannerN = (Banner) findViewById(R.id.banner);
        this.mLeisureBanner = (Banner) findViewById(R.id.leisure_game_banner);
        this.mGameRv = (RecyclerView) findViewById(R.id.rv_game_list);
        this.mIconRv = (RecyclerView) findViewById(R.id.rv_icon_list);
        this.mHotRv = (RecyclerView) findViewById(R.id.rv_hot_list);
        this.mBack = (ImageView) findViewById(R.id.iv_back);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.mAdTitle = (TextView) findViewById(R.id.tv_ad_title);
        ((TextView) findViewById(R.id.rv_hot_sub_title)).setText(SMGameClient.getInstance().isChina() ? "向左滑动查看更多" : "Swipe left for more");
        this.mGameRv.setHasFixedSize(true);
        this.mGameRv.setNestedScrollingEnabled(false);
        this.mIconRv.setLayoutManager(new GridLayoutManager(this, 4));
        this.mIconRv.addItemDecoration(new GridSpaceItemDecoration(4));
        this.mHotRv.setLayoutManager(new LinearLayoutManager(this, 0, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToVip(SMIconListParent sMIconListParent) {
        Intent intent = new Intent(this, (Class<?>) SMVipGameListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("game", sMIconListParent);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLeisureGame(SMGameListParent sMGameListParent) {
        ArrayList arrayList = new ArrayList();
        if (sMGameListParent.getGameList().size() > 9) {
            arrayList.add(sMGameListParent.getGameList().subList(0, 3));
            arrayList.add(sMGameListParent.getGameList().subList(3, 6));
            arrayList.add(sMGameListParent.getGameList().subList(6, 9));
        } else if (sMGameListParent.getGameList().size() <= 3) {
            arrayList.add(sMGameListParent.getGameList());
        } else if (sMGameListParent.getGameList().size() > 6) {
            arrayList.add(sMGameListParent.getGameList().subList(0, 3));
            arrayList.add(sMGameListParent.getGameList().subList(3, 6));
            arrayList.add(sMGameListParent.getGameList().subList(6, sMGameListParent.getGameList().size() - 1));
        } else {
            arrayList.add(sMGameListParent.getGameList().subList(0, 3));
            arrayList.add(sMGameListParent.getGameList().subList(3, sMGameListParent.getGameList().size() - 1));
        }
        this.mLeisureBanner.setAdapter(new GameLeisureListBannerAdapter(this, new GameLeisureListBannerAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.12
            @Override // com.tenmeter.smlibrary.adapter.GameLeisureListBannerAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
                    SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(SMGameListActivity.this, sMGameInfo);
                } else {
                    SMGameListActivity.this.showLoading();
                    SMGameClient.getInstance().startGame(sMGameInfo, SMGameListActivity.this, new IGameOpenListener() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.12.1
                        @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                        public void openResult(boolean z) {
                            SMGameListActivity.this.hideLoading();
                        }
                    });
                }
            }
        }, arrayList)).setBannerGalleryEffect(0, 23, 0, 1.0f);
    }

    private void registerListener() {
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SMGameListActivity.this.finish();
            }
        });
        this.mGameRv.setLayoutManager(new LinearLayoutManager(this));
        IconListAdapter iconListAdapter = new IconListAdapter(this, new ArrayList(), new IconListAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.2
            @Override // com.tenmeter.smlibrary.adapter.IconListAdapter.IGameListItemClick
            public void itemClick(SMIconListParent sMIconListParent) {
                if (sMIconListParent.getIconPage() == 2) {
                    SMGameListActivity.this.jumpToVip(sMIconListParent);
                    return;
                }
                SMGameListParent sMGameListParent = new SMGameListParent();
                sMGameListParent.setGameList(sMIconListParent.getGameList());
                sMGameListParent.setTagId(sMIconListParent.getIconId());
                sMGameListParent.setTagName(sMIconListParent.getIconPageTitle());
                SMGameClient.getInstance().startGameListSub(sMGameListParent, SMGameListActivity.this);
            }
        });
        this.mIconAdapter = iconListAdapter;
        this.mIconRv.setAdapter(iconListAdapter);
        HotListAdapter hotListAdapter = new HotListAdapter(this, new ArrayList(), new HotListAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.3
            @Override // com.tenmeter.smlibrary.adapter.HotListAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                SMGameListActivity.this.gameClick(sMGameInfo);
            }
        }, (DisplayUtil.getScreenWidth() - DisplayUtil.dp2px(56.0f)) / 2);
        this.mHotAdapter = hotListAdapter;
        this.mHotRv.setAdapter(hotListAdapter);
        GameListTypeAdapter gameListTypeAdapter = new GameListTypeAdapter(this, new ArrayList(), new GameListTypeAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.4
            @Override // com.tenmeter.smlibrary.adapter.GameListTypeAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                SMGameListActivity.this.gameClick(sMGameInfo);
            }

            @Override // com.tenmeter.smlibrary.adapter.GameListTypeAdapter.IGameListItemClick
            public void itemMoreClick(SMGameListParent sMGameListParent) {
                SMGameClient.getInstance().startGameListSub(sMGameListParent, SMGameListActivity.this);
            }
        });
        this.mTypeAdapter = gameListTypeAdapter;
        this.mGameRv.setAdapter(gameListTypeAdapter);
        this.mLeisureMore.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMGameListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SMGameListActivity.this.leisureGameDatas != null) {
                    SMGameClient.getInstance().startGameListSub(SMGameListActivity.this.leisureGameDatas, SMGameListActivity.this);
                }
            }
        });
    }

    public void hideLoading() {
        LoadDia loadDia = this.mLoadDia;
        if (loadDia == null || !loadDia.isShowing()) {
            return;
        }
        this.mLoadDia.dismiss();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sm_sdk_game_list);
        Utils.setDarkStatusWhite(this, true);
        initView();
        registerListener();
        initData();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Banner banner = this.mBannerN;
        if (banner == null || banner.getVisibility() != 0) {
            return;
        }
        this.mBannerN.destroy();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Banner banner = this.mBannerN;
        if (banner == null || banner.getVisibility() != 0) {
            return;
        }
        this.mBannerN.start();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Banner banner = this.mBannerN;
        if (banner == null || banner.getVisibility() != 0) {
            return;
        }
        this.mBannerN.stop();
    }

    public void showLoading() {
        if (this.mLoadDia == null) {
            this.mLoadDia = new LoadDia(this);
        }
        if (this.mLoadDia.isShowing()) {
            return;
        }
        this.mLoadDia.show();
    }
}
