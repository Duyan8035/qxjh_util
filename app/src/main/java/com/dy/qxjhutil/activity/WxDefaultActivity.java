package com.dy.qxjhutil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.data.WxDefaultModel;
import com.dy.qxjhutil.model.ColorModel;
import com.dy.qxjhutil.model.WXModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.Sort;

public class WxDefaultActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private BaseQuickAdapter<WXModel, BaseViewHolder> mAdapter;
    private List<WXModel> mList = new ArrayList<>();
    private boolean trendSort, goodSort, parentSort;

    Realm mRealm;
    String[] strings = new String[]{"parent", "trend", "good"};
    Sort[] sorts = new Sort[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_default);
        mRealm = Realm.getDefaultInstance();
        sorts[0] = parentSort ? Sort.ASCENDING : Sort.DESCENDING;
        sorts[1] = goodSort ? Sort.ASCENDING : Sort.DESCENDING;
        sorts[2] = trendSort ? Sort.ASCENDING : Sort.DESCENDING;

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_good) {
            @Override
            protected void convert(BaseViewHolder helper, WXModel item) {
                helper.setText(R.id.item_wx_list_name, item.getName_game())
                        .setText(R.id.item_wx_list_value, item.getTrend() == 99 ? "" : item.getTrend() + "")
                        .setText(R.id.item_wx_list_value2, item.getGood() == 99 ? "" : item.getGood() + "")
                        .setText(R.id.item_wx_list_value3, item.getParent())
                ;
                switch (item.getParent()) {
                    case WxDefaultModel.Parent_1:
                        helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_1);
                        break;
                    case WxDefaultModel.Parent_2:
                        helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_2);
                        break;
                    case WxDefaultModel.Parent_3:
                        helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_3);
                        break;
                    case WxDefaultModel.Parent_4:
                        helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_4);
                        break;
                    case WxDefaultModel.Parent_5:
                        helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_5);
                        break;
                    default:
                        break;
                }
                if (item.getTrend() == 0) {
                    helper.setTextColor(R.id.item_wx_list_value, ColorModel.TYPE_COLOR_DEFAULT);
                } else {
                    helper.setTextColor(R.id.item_wx_list_value, item.getTrend() > 0 ? ColorModel.TYPE_COLOR_GREEN : ColorModel.TYPE_COLOR_RED);
                }
                if (item.getGood() == 0) {
                    helper.setTextColor(R.id.item_wx_list_value2, ColorModel.TYPE_COLOR_DEFAULT);
                } else {
                    helper.setTextColor(R.id.item_wx_list_value2, item.getGood() > 0 ? ColorModel.TYPE_COLOR_GREEN : ColorModel.TYPE_COLOR_RED);
                }
                if (item.getTrend() < 0 && item.getGood() < 0) {
                    helper.setTextColor(R.id.item_wx_list_name, ColorModel.TYPE_COLOR_RED);
                } else if (item.getGood() > 0 && item.getTrend() > 0) {
                    helper.setTextColor(R.id.item_wx_list_name, ColorModel.TYPE_COLOR_GREEN);
                } else {
                    helper.setTextColor(R.id.item_wx_list_name, ColorModel.TYPE_COLOR_DEFAULT);
                }
            }
        };

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, WxInfoActivity.class);
                intent.putExtra("name", mAdapter.getData().get(position).getName_game());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);

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
