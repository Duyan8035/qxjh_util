package com.dy.qxjhutil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.activity.WxDefaultActivity;
import com.dy.qxjhutil.activity.WxListActivity;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.data.WxDefaultModel;

import java.util.Arrays;

import io.realm.Realm;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private BaseQuickAdapter<String, BaseViewHolder> mAdapter;

//    private ViewPager mViewPager;
//    private TabLayout tabLayout;

    //    QMUITopBarLayout mTopBar;
//    QMUITabSegment mTabSegment;
//    ViewPager mContentViewPager;
    Realm mRealm;

    private String[] strings = {"初始", "列表", "地区", "资料", "其他"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Realm.init(this);
        mRealm = Realm.getDefaultInstance();

        initData();

        mRecyclerView = findViewById(R.id.act_main_rv);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));

        mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_text) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.item_text, item);
            }
        };
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(mContext, WxDefaultActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(mContext, WxListActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setNewData(Arrays.asList(strings));
    }

    /**
     * 第一次进入时，初始化整个数据
     */
    private void initData() {
//        if (MMKV.defaultMMKV().getBoolean("is_one", true)) {
//            MMKV.defaultMMKV().putBoolean("is_one", false);
        new WxDefaultModel().initData(mContext);
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
