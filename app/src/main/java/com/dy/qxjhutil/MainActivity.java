package com.dy.qxjhutil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.activity.WxInfoActivity;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.base.WxInfoModel;
import com.dy.qxjhutil.model.WXModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends BaseActivity {
    private static final String ACT_TYPE_1 = "善恶事件";
    private static final String ACT_TYPE_2 = "隐藏武学";
    private static final String ACT_TYPE_3 = "武侠自带善恶";

    private RecyclerView mRecyclerView;
    private BaseQuickAdapter<WXModel, BaseViewHolder> mAdapter;

//    private ViewPager mViewPager;
//    private TabLayout tabLayout;

    //    QMUITopBarLayout mTopBar;
//    QMUITabSegment mTabSegment;
//    ViewPager mContentViewPager;
    Realm mRealm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Realm.init(this);
        mRealm = Realm.getDefaultInstance();

        initData();

        mRecyclerView = findViewById(R.id.act_main_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_good) {
            @Override
            protected void convert(BaseViewHolder helper, WXModel item) {
                helper.setText(R.id.item_wx_list_name, item.getName_game())
                        .setText(R.id.item_wx_list_value, item.getTrend() == 99 ? "" : item.getTrend() + "")
                        .setText(R.id.item_wx_list_value2, item.getTrend() == 99 ? "" : item.getGood() + "")
                        .setText(R.id.item_wx_list_value3, item.getParent())
                ;
            }
        };
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, WxInfoActivity.class);
                intent.putExtra("id", mAdapter.getData().get(position).getName_game());
                startActivity(intent);
//                startActivity(new Intent(mContext, mAdapter.getData().get(position)));
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setNewData(mRealm.where(WXModel.class).findAll());
    }

    /**
     * 第一次进入时，初始化整个数据
     */
    private void initData() {
//        if (MMKV.defaultMMKV().getBoolean("is_one", true)) {
//            MMKV.defaultMMKV().putBoolean("is_one", false);
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                List<WXModel> wxModels = new ArrayList<>();
                for (int i = 0; i < WxInfoModel.stringList.length; i++) {
                    wxModels.add(new WXModel(WxInfoModel.stringList[i], WxInfoModel.trends[i], WxInfoModel.goods[i], WxInfoModel.parents[i]));
                }
                mRealm.copyToRealmOrUpdate(wxModels);
            }
        });

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
