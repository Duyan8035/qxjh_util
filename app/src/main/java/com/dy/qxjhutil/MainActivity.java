package com.dy.qxjhutil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.SpanUtils;
import com.dy.qxjhutil.activity.AboutUsActivity;
import com.dy.qxjhutil.activity.map.MapListActivity;
import com.dy.qxjhutil.activity.wx.WxDefaultActivity;
import com.dy.qxjhutil.activity.wx.WxListActivity;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.constant.WxDefaultUtil;
import com.dy.qxjhutil.util.RealmHelper;

import io.realm.Realm;

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
        findViewById(R.id.act_main_btn_about).setOnClickListener(this);


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
            case R.id.act_main_btn_about:
                startActivity(new Intent(mContext, AboutUsActivity.class));
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
