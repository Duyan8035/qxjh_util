package com.dy.qxjhutil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.activity.WxInfoActivity;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.WXModel;
import com.tencent.mmkv.MMKV;

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

        initData();

        Realm.init(this);
        mRealm = Realm.getDefaultInstance();

        mRecyclerView = findViewById(R.id.act_main_rv);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));

        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_img) {
            @Override
            protected void convert(BaseViewHolder helper, WXModel item) {
                helper.setImageResource(R.id.item_qmui_img, item.getIcon())
                        .setText(R.id.item_text, item.getName_game() +
                                (TextUtils.isEmpty(item.getName()) ? "" : "(" + item.getName() + ")"))
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
        if (MMKV.defaultMMKV().getBoolean("is_one", true)) {
            MMKV.defaultMMKV().putBoolean("is_one", false);
        }
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
