package com.dy.qxjhutil.activity.wx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dy.qxjhutil.R;
import com.dy.qxjhutil.adapter.WxDefaultQxAdapter;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.Sort;

public class WxDefaultActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    //    private BaseQuickAdapter<WXModel, BaseViewHolder> mAdapter;
    private WxDefaultQxAdapter mAdapter;
    private List<WXModel> mList = new ArrayList<>();
    private boolean trendSort, goodSort, parentSort;

    Realm mRealm;
    String[] strings = new String[]{"parent", "trend", "good"};
    Sort[] sorts = new Sort[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_default);
        mRealm = RealmHelper.getInstance(mContext);
        sorts[0] = parentSort ? Sort.ASCENDING : Sort.DESCENDING;
        sorts[1] = goodSort ? Sort.ASCENDING : Sort.DESCENDING;
        sorts[2] = trendSort ? Sort.ASCENDING : Sort.DESCENDING;

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new WxDefaultQxAdapter();
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(mContext, WxDefaultActivity.class);
            intent.putExtra("name", mAdapter.getData().get(position).getName_game());
            startActivity(intent);
        });
        recyclerView.setAdapter(mAdapter);
        TextView view = (TextView) View.inflate(mContext, R.layout.include_text, null);
        view.setText("豪侠游侠刺客资料取自残夜影大佬攻略，气宗初始由 七月上大佬提供,感谢以上大佬");
        mAdapter.setFooterView(view);

        findViewById(R.id.item_wx_list_value).setOnClickListener(this);
        findViewById(R.id.item_wx_list_value2).setOnClickListener(this);
        findViewById(R.id.item_wx_list_value3).setOnClickListener(this);
        getData();
    }

    private void getData() {
        sorts[0] = parentSort ? Sort.ASCENDING : Sort.DESCENDING;
        mAdapter.setNewData(mRealm.where(WXModel.class)
                .notEqualTo("trend", 99)
                .notEqualTo("good", 99)
                .findAll().sort(strings, sorts));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_wx_list_value:
                trendSort = !trendSort;
                strings[1] = "trend";
                strings[2] = "good";
                sorts[1] = trendSort ? Sort.ASCENDING : Sort.DESCENDING;
                sorts[2] = goodSort ? Sort.ASCENDING : Sort.DESCENDING;
                getData();
                break;
            case R.id.item_wx_list_value2:
                goodSort = !goodSort;
                strings[1] = "good";
                strings[2] = "trend";
                sorts[1] = goodSort ? Sort.ASCENDING : Sort.DESCENDING;
                sorts[2] = trendSort ? Sort.ASCENDING : Sort.DESCENDING;
                getData();
                break;
            case R.id.item_wx_list_value3:
                parentSort = !parentSort;
                sorts[1] = goodSort ? Sort.ASCENDING : Sort.DESCENDING;
                sorts[2] = trendSort ? Sort.ASCENDING : Sort.DESCENDING;
                getData();
                break;
            default:
                break;
        }
    }
}
