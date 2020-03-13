package com.dy.qxjhutil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SpanUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.activity.AboutUsActivity;
import com.dy.qxjhutil.activity.hx.HxList2Activity;
import com.dy.qxjhutil.activity.map.MapListActivity;
import com.dy.qxjhutil.activity.wx.WxDefaultActivity;
import com.dy.qxjhutil.activity.wx.WxListActivity;
import com.dy.qxjhutil.adapter.WxDefaultQxAdapter;
import com.dy.qxjhutil.adapter.WxSjListAdapter;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.constant.NameModel;
import com.dy.qxjhutil.constant.WxDefaultUtil;
import com.dy.qxjhutil.model.MapModel;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.lzf.easyfloat.EasyFloat;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.interfaces.OnInvokeView;

import java.util.ArrayList;
import java.util.Arrays;

import io.realm.Realm;
import io.realm.Sort;


public class MainActivity extends BaseActivity implements View.OnClickListener {

//    private RecyclerView mRecyclerView;
//    private BaseQuickAdapter<String, BaseViewHolder> mAdapter;

//    private ViewPager mViewPager;
//    private TabLayout tabLayout;

    //    QMUITopBarLayout mTopBar;
//    QMUITabSegment mTabSegment;
//    ViewPager mContentViewPager;
    Realm mRealm;

    private Button btn_01, btn_02, btn_03, btn_04, btn_05, btn_06, btn_07, btn_08, btn_09, btn_about;

    private String[] strTitle1 = {NameModel.MAP_NAME_1, NameModel.MAP_NAME_2, NameModel.MAP_NAME_3, NameModel.MAP_NAME_4, NameModel.MAP_NAME_5, NameModel.MAP_NAME_6};
    private String[] strTitle3 = {NameModel.Parent_2, NameModel.Parent_3, NameModel.Parent_4, NameModel.Parent_5};

    private String[] strTitle2 = {
            "阴阳符(0,5)",
            "七伤拳(4,-4)",
            "落花流水(-5,0)",
            "空明拳(0,5)",
            "双手互搏(4,4)",
            "兰花指(0,0)",
            "灭剑-绝剑(4,-4)",
            "软剑无常(-4,4)",
            "纯阳无极功(4,4)",
            "五毒神掌(0,-5)",
            "为我独尊(-5,0)",
            "易经筋(-4,4)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRealm = RealmHelper.getInstance(mContext);

        btn_01 = findViewById(R.id.act_main_btn_01);
        btn_02 = findViewById(R.id.act_main_btn_02);
        btn_03 = findViewById(R.id.act_main_btn_03);
        btn_04 = findViewById(R.id.act_main_btn_04);
        btn_05 = findViewById(R.id.act_main_btn_05);
        btn_06 = findViewById(R.id.act_main_btn_06);
        btn_07 = findViewById(R.id.act_main_btn_07);
        btn_08 = findViewById(R.id.act_main_btn_08);
        btn_09 = findViewById(R.id.act_main_btn_09);
        btn_about = findViewById(R.id.act_main_btn_about);

        btn_01.setText(new SpanUtils().append("善恶事件列表").setShadow(7, 1, 1, 0xffffffff).create());

        initData();

//        mRecyclerView = findViewById(R.id.act_main_rv);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//
//        mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_text) {
//            @Override
//            protected void convert(BaseViewHolder helper, String item) {
//                helper.setText(R.id.item_text, item);
//            }
//        };
        findViewById(R.id.act_main_btn_01).setOnClickListener(this);
        findViewById(R.id.act_main_btn_02).setOnClickListener(this);
        findViewById(R.id.act_main_btn_03).setOnClickListener(this);
        findViewById(R.id.act_main_btn_04).setOnClickListener(this);
        findViewById(R.id.act_main_btn_05).setOnClickListener(this);
        findViewById(R.id.act_main_btn_06).setOnClickListener(this);
        findViewById(R.id.act_main_btn_07).setOnClickListener(this);
        findViewById(R.id.act_main_btn_08).setOnClickListener(this);
        findViewById(R.id.act_main_btn_09).setOnClickListener(this);
        findViewById(R.id.act_main_btn_11).setOnClickListener(this);
        findViewById(R.id.act_main_btn_about).setOnClickListener(this);

        findViewById(R.id.act_main_float).setOnClickListener(this);
        findViewById(R.id.act_main_user_img).setOnClickListener(this);


//        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                switch (position) {
//                    case 0:
//                        startActivity(new Intent(mContext, WxListActivity.class));
//                        break;
//                    case 1:
//                        startActivity(new Intent(mContext, MapListActivity.class));
//                        break;
//                    case 2:
//                        startActivity(new Intent(mContext, WxDefaultActivity.class));
//                        break;
//                    case 3:
//                    case 4:
//                    case 5:
//                        ToastUtils.showLong("还没搞完");
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });
//        mRecyclerView.setAdapter(mAdapter);
//
//        mAdapter.setNewData(Arrays.asList(strings));
//        TextView view = (TextView) View.inflate(mContext, R.layout.include_text, null);
//        view.setText("数据参考与各个攻略，有不对的地方，2群里面说一下。");
//        mAdapter.setFooterView(view);
    }

    /**
     * 第一次进入时，初始化整个数据
     */
    private void initData() {
//        if (MMKV.defaultMMKV().getBoolean("is_one", true)) {
//            MMKV.defaultMMKV().putBoolean("is_one", false);
        new WxDefaultUtil().initData(mContext);
//        mRealm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                List<WXModel> wxModels = new ArrayList<>();
//                for (int i = 0; i < WxInfoModel.stringList.length; i++) {
//                    wxModels.add(new WXModel(WxInfoModel.stringList[i], WxInfoModel.trends[i], WxInfoModel.goods[i], WxInfoModel.parents[i]));
//                }
//                mRealm.copyToRealmOrUpdate(wxModels);
//            }
//        });
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Realm instance.
        mRealm.close();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_main_btn_01:
                startActivity(new Intent(mContext, WxListActivity.class));
                break;
            case R.id.act_main_btn_02:
                startActivity(new Intent(mContext, MapListActivity.class));
                break;
            case R.id.act_main_btn_03:
                startActivity(new Intent(mContext, WxDefaultActivity.class));
                break;
            case R.id.act_main_btn_04:
//                startActivity(new Intent(mContext, KfListActivity.class));
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.taptap.com/topic/6322077")));
                break;
            case R.id.act_main_btn_05:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.taptap.com/topic/6169185")));
                break;
            case R.id.act_main_btn_06:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.taptap.com/topic/6685601")));
                break;
            case R.id.act_main_btn_07:
                break;
            case R.id.act_main_btn_08:
                break;
            case R.id.act_main_btn_09:
                break;
            case R.id.act_main_btn_11:
                startActivity(new Intent(mContext, HxList2Activity.class));
                break;
            case R.id.act_main_btn_about:
                startActivity(new Intent(mContext, AboutUsActivity.class));
                break;
            case R.id.act_main_float:
            case R.id.act_main_user_img:
                /**
                 * 打开悬浮窗
                 **/
                EasyFloat.with(MainActivity.this).setLayout(R.layout.layout_float, new OnInvokeView() {

                    RecyclerView mRv1, mRv2, mRv3;
                    /**
                     * 地图名称，隐藏武学及需求，
                     **/
                    BaseQuickAdapter<String, BaseViewHolder> mAdapter1;
                    BaseQuickAdapter<String, BaseViewHolder> mAdapter2;
                    /**
                     * 武侠名称，善恶事件，武侠倾向
                     **/
                    BaseQuickAdapter<WXModel, BaseViewHolder> mAdapterWx;
                    WxSjListAdapter mAdapteSj;
                    /**
                     * 地图产出
                     **/
                    BaseQuickAdapter<MapModel, BaseViewHolder> mAdapterMap;
                    WxDefaultQxAdapter mAdapterQx;

                    int type = 1;
                    String[] strings = new String[]{"parent", "trend", "good"};
                    Sort[] sorts = new Sort[3];
                    boolean trendSort, goodSort, parentSort;

                    int selectMap, selectWx;

                    @Override
                    public void invoke(View v) {
                        v.findViewById(R.id.float_view_icon).setOnClickListener(view1 -> {
                            v.findViewById(R.id.float_layout_group_view).setVisibility(
                                    v.findViewById(R.id.float_layout_group_view).getVisibility() ==
                                            View.VISIBLE ? View.GONE : View.VISIBLE);
                        });
                        v.findViewById(R.id.float_layout_title_tv_1).setOnClickListener(view1 -> switchTitle(1));
                        v.findViewById(R.id.float_layout_title_tv_2).setOnClickListener(view1 -> switchTitle(2));
                        v.findViewById(R.id.float_layout_title_tv_3).setOnClickListener(view1 -> switchTitle(3));

                        sorts[0] = parentSort ? Sort.ASCENDING : Sort.DESCENDING;
                        sorts[1] = goodSort ? Sort.ASCENDING : Sort.DESCENDING;
                        sorts[2] = trendSort ? Sort.ASCENDING : Sort.DESCENDING;

                        mRv1 = v.findViewById(R.id.float_layout_rv_1);
                        mRv1.setLayoutManager(new LinearLayoutManager(mContext));
                        mRv2 = v.findViewById(R.id.float_layout_rv_2);
                        mRv2.setLayoutManager(new LinearLayoutManager(mContext));
                        mRv3 = v.findViewById(R.id.float_layout_rv_3);
                        mRv3.setLayoutManager(new LinearLayoutManager(mContext));

                        mAdapter1 = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_float_tv) {
                            @Override
                            protected void convert(BaseViewHolder helper, String item) {
                                helper.setText(R.id.item_text, item)
                                        .setBackgroundColor(R.id.item_text, helper.getAdapterPosition() == selectMap ? 0xffe5e5e5 : 0xffffffff);
                            }
                        };
                        mAdapter1.setOnItemClickListener((adapter, view12, position) -> {
                            switch (type) {
                                case 1:
//                                    ToastUtils.showLong("点击了：" + mAdapter1.getItem(position));
                                    selectSjMap(position);
                                    selectMap = position;
                                    mAdapter1.notifyDataSetChanged();
                                    break;
                                case 2:
//                                    ToastUtils.showLong("点击了：" + mAdapter1.getItem(position));
                                    selectWxMap(mAdapter1.getItem(position));
                                    break;
                                case 3:
//                                    ToastUtils.showLong("点击了：" + mAdapter1.getItem(position));
                                    break;
                                default:
                                    break;
                            }
                        });
                        mAdapter2 = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_float_tv) {
                            @Override
                            protected void convert(BaseViewHolder helper, String item) {
                                helper.setText(R.id.item_text, item);
                            }
                        };
                        mAdapter2.setOnItemClickListener((adapter, view1, position) -> {
                            switch (mAdapter2.getItem(position)) {
                                case NameModel.Parent_2:
                                    getWxDefaultData();
                                    break;
                                case NameModel.Parent_3:
                                    break;
                                case NameModel.Parent_4:
                                    break;
                                case NameModel.Parent_5:
                                    break;
                                default:
                                    break;
                            }
                        });

                        mRv1.setAdapter(mAdapter1);
                        mAdapter1.setNewData(Arrays.asList(strTitle1));
                        initWx();

                        /**
                         * 武侠列表
                         **/
                        mAdapterWx = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_float_tv) {
                            @Override
                            protected void convert(BaseViewHolder helper, WXModel item) {
                                helper.setText(R.id.item_text, item.getName_game())
                                        .setBackgroundColor(R.id.item_text, helper.getAdapterPosition() == selectWx ? 0xffe5e5e5 : 0xffffffff);
                            }
                        };
                        /**
                         * 武侠点击
                         **/
                        mAdapterWx.setOnItemClickListener((adapter, view13, position) -> {
                            selectWx = position;
                            selectSjWx(mAdapterWx.getItem(position));
                            mAdapterWx.notifyDataSetChanged();
                        });

                        mRv2.setAdapter(mAdapterWx);
                        mAdapterWx.setNewData(mRealm.where(WXModel.class).equalTo("isMap1", true).findAll().sort("index"));

                        /**
                         * 善恶倾向
                         **/
//                        mAdapterQx = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_float_tv) {
//                            @Override
//                            protected void convert(BaseViewHolder helper, WXModel item) {
//                                helper.setText(R.id.item_text, item.getParent() + "-" + item.getName_game() + "-" + Utils.getFloatQx(item.getTrend(), item.getGood()));
//                            }
//                        };
                        mAdapterQx = new WxDefaultQxAdapter();
                        mAdapterQx.setOnItemClickListener((adapter, view14, position) -> {
                            startActivity(new Intent(mContext, WxDefaultActivity.class));
                        });
                        mAdapterQx.setHeaderView(View.inflate(mContext, R.layout.include_wx_default_title, null));

                        mAdapteSj = new WxSjListAdapter(new ArrayList<>());
                        mRv3.setAdapter(mAdapteSj);
                    }

                    /**
                     * 选中阵容后，确认
                     **/
                    private void getWxDefaultData() {
                    }

                    /**
                     * 选中了武学
                     **/
                    private void selectWxMap(String item) {
                        strings[1] = "trend";
                        strings[2] = "good";
                        sorts[1] = Sort.ASCENDING;
                        sorts[2] = Sort.ASCENDING;
                        sorts[0] = parentSort ? Sort.ASCENDING : Sort.DESCENDING;
                        mAdapterQx.setNewData(mRealm.where(WXModel.class)
                                .notEqualTo("trend", 99)
                                .notEqualTo("good", 99)
                                .findAll().sort(strings, sorts));

                        switch (item) {
                            case "阴阳符(0,5)":
                                strings[1] = "good";
                                strings[2] = "trend";
                                sorts[1] = Sort.ASCENDING;
                                sorts[2] = Sort.ASCENDING;
                                sorts[0] = parentSort ? Sort.ASCENDING : Sort.DESCENDING;
                                mAdapterQx.setNewData(mRealm.where(WXModel.class)
                                        .equalTo("good", 1)
                                        .notEqualTo("trend", 99)
                                        .notEqualTo("good", 99)
                                        .findAll().sort(strings, sorts));
                                break;
                            case "七伤拳(4,-4)":
                                break;
                            case "落花流水(-5,0)":
                                strings[1] = "trend";
                                strings[2] = "good";
                                sorts[1] = Sort.ASCENDING;
                                sorts[2] = Sort.ASCENDING;
                                sorts[0] = parentSort ? Sort.ASCENDING : Sort.DESCENDING;
                                mAdapterQx.setNewData(mRealm.where(WXModel.class)
                                        .equalTo("trend", -1)
                                        .notEqualTo("trend", 99)
                                        .notEqualTo("good", 99)
                                        .findAll().sort(strings, sorts));
                                break;
                            case "空明拳(0,5)":
                                break;
                            case "双手互搏(4,4)":
                                break;
                            case "兰花指(0,0)":
                                break;
                            case "灭剑-绝剑(4,-4)":
                                break;
                            case "软剑无常(-4,4)":
                                break;
                            case "纯阳无极功(4,4)":
                                break;
                            case "五毒神掌(0,-5)":
                                break;
                            case "为我独尊(-5,0)":
                                break;
                            case "易经筋(-4,4)":
                                break;
                            default:
                                break;
                        }

                    }

                    /**
                     * 地图点击武侠善恶
                     **/
                    private void selectSjWx(WXModel item) {
                        mAdapteSj.setNewData(item.getSjModels());
                    }


                    private void initWx() {
                    }

                    /**
                     *
                     *
                     * @param position*/
                    private void selectSjMap(int position) {
                        switch (position) {
                            case 0:
                                mAdapterWx.setNewData(mRealm.where(WXModel.class).equalTo("isMap1", true).findAll().sort("index"));
                                break;
                            case 1:
                                mAdapterWx.setNewData(mRealm.where(WXModel.class).equalTo("isMap2", true).findAll().sort("index"));
                                break;
                            case 2:
                                mAdapterWx.setNewData(mRealm.where(WXModel.class).equalTo("isMap3", true).findAll().sort("index"));
                                break;
                            case 3:
                                mAdapterWx.setNewData(mRealm.where(WXModel.class).equalTo("isMap4", true).findAll().sort("index"));
                                break;
                            case 4:
                                mAdapterWx.setNewData(mRealm.where(WXModel.class).equalTo("isMap5", true).findAll().sort("index"));
                                break;
                            case 5:
                                mAdapterWx.setNewData(mRealm.where(WXModel.class).equalTo("isMap6", true).findAll().sort("index"));
                                break;
                            default:
                                break;
                        }
                    }

                    /**
                     * 头部功能点击
                     **/
                    private void switchTitle(int i) {
                        type = i;
                        switch (i) {
                            /**
                             * 善恶事件查询
                             **/
                            case 1:
                                mAdapter1.setNewData(Arrays.asList(strTitle1));
                                mRv2.setAdapter(mAdapterWx);
                                mAdapteSj.setNewData(new ArrayList<>());
//                                mAdapterWx.setNewData(mReal);
                                break;
                            /**
                             * 隐藏推荐阵容or武侠
                             **/
                            case 2:
                                mAdapter1.setNewData(Arrays.asList(strTitle2));
                                mRv2.setVisibility(View.GONE);
//                                mRv2.setAdapter(mAdapter2);
//                                mAdapter2.setNewData(Arrays.asList(strTitle3));
                                mAdapteSj.setNewData(new ArrayList<>());
                                mAdapterWx.setNewData(new ArrayList<>());
                                mRv3.setAdapter(mAdapterQx);
                                break;
                            /**
                             * 地图产出
                             **/
                            case 3:
                                mAdapter1.setNewData(Arrays.asList(strTitle1));
                                mAdapteSj.setNewData(new ArrayList<>());
                                break;
                            default:
                                break;
                        }
                    }
                }).setShowPattern(ShowPattern.ALL_TIME)
                        .setDragEnable(true)
                        .setSidePattern(SidePattern.DEFAULT)
                        .setMatchParent(false, false)
                        .setLocation(100, 100)
                        .show();
                break;
            default:
                break;
        }
    }

//    enum ActivityMode {
//        //首页
//        ACT_1(Test1Activity.class, ACT_TYPE_1),
//        ACT_2(Edit1Activity.class, ACT_TYPE_2),
//        ACT_3(MainActivity.class, ACT_TYPE_3),;
//
//        public Class classname;
//        public String name;
//
//        ActivityMode(Class className, String name) {
//            this.classname = className;
//            this.name = name;
//        }
//
//        public String getName() {
//            return name == null ? "" : name;
//        }
//
//        public Class getClassname() {
//            return classname;
//        }
//    }
}
