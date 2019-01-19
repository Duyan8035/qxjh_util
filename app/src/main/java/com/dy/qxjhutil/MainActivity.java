package com.dy.qxjhutil;

import android.os.Bundle;

import com.dy.qxjhutil.activity.Edit1Activity;
import com.dy.qxjhutil.activity.Test1Activity;
import com.dy.qxjhutil.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private static final String ACT_TYPE_1 = "行业选股";
    private static final String ACT_TYPE_2 = "地区选股";
    private static final String ACT_TYPE_3 = "模型选股";

//    private RecyclerView mRecyclerView;
//    private BaseQuickAdapter<ActivityMode, BaseViewHolder> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mRecyclerView = findViewById(R.id.act_main_rv);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//
//        mAdapter = new BaseQuickAdapter<ActivityMode, BaseViewHolder>(R.layout.item_text) {
//            @Override
//            protected void convert(BaseViewHolder helper, ActivityMode item) {
//                helper.setText(R.id.item_text, item.name);
//
//            }
//        };
//        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startActivity(new Intent(mContext, mAdapter.getData().get(position).getClassname()));
//            }
//        });
//        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setNewData(Arrays.asList(ActivityMode.values()));
    }

    enum ActivityMode {
        //首页
        ACT_1(Test1Activity.class, ACT_TYPE_1),
        ACT_2(Edit1Activity.class, ACT_TYPE_2),
        ACT_3(MainActivity.class, ACT_TYPE_3),;

        public Class classname;
        public String name;

        ActivityMode(Class className, String name) {
            this.classname = className;
            this.name = name;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public Class getClassname() {
            return classname;
        }
    }
}
