package com.dy.qxjhutil.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.blankj.utilcode.util.SpanUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.ColorModel;
import com.dy.qxjhutil.model.SjModel;
import com.dy.qxjhutil.model.WXModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 *
 **/
public class WxListActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private BaseQuickAdapter<WXModel, BaseViewHolder> mAdapter;
    private List<WXModel> mList = new ArrayList<>();

    Realm mRealm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_list);

        mRealm = Realm.getDefaultInstance();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_sj_list) {
        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_sj_list) {
            @Override
            protected void convert(BaseViewHolder helper, WXModel item) {
                helper.setText(R.id.item_wx_sj_list_name, item.getName_game());
                if (item.getSjModels() != null && item.getSjModels().size() > 0) {
                    RecyclerView recyclerView = helper.getView(R.id.item_wx_sj_list_rv);
                    recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                    recyclerView.setAdapter(new BaseQuickAdapter<SjModel, BaseViewHolder>(R.layout.item_sj_type_1, item.getSjModels()) {
                        @Override
                        protected void convert(BaseViewHolder helper, SjModel item) {
                            if (!TextUtils.isEmpty(item.getValue_1()) && item.getValue_1().length() > 0) {
                                helper.setGone(R.id.item_wx_sj_list_value_1, true);
                                helper.setText(R.id.include_sj_value_parent_layout1_1, item.getValue_1());
                                if (!TextUtils.isEmpty(item.getBranch_11()) && item.getBranch_11().length() > 0) {
                                    helper.setText(R.id.include_sj_value_value_layout1_1, item.getBranch_11())
                                            .setGone(R.id.include_sj_value_value_layout1_1, true)
                                            .setText(R.id.include_sj_value_obtain_layout1_1, getObtain(item.getObtain_11(), item.getTrend_11(), item.getGood_11()))
                                            .setGone(R.id.include_sj_value_obtain_layout1_1, true)
                                    ;
                                } else {
                                    helper.setGone(R.id.include_sj_value_value_layout1_1, false)
                                            .setGone(R.id.include_sj_value_obtain_layout1_1, false)
                                            .setGone(R.id.include_sj_value_obtain_layout1_1, false)
                                    ;
                                }
                                if (!TextUtils.isEmpty(item.getBranch_12()) && item.getBranch_12().length() > 0) {
                                    helper.setText(R.id.include_sj_value_value_layout1_2, item.getBranch_12())
                                            .setGone(R.id.include_sj_value_value_layout1_2, true)
                                            .setText(R.id.include_sj_value_obtain_layout1_2, getObtain(item.getObtain_12(), item.getTrend_12(), item.getGood_12()))
                                            .setGone(R.id.include_sj_value_obtain_layout1_2, true)
                                    ;
                                } else {
                                    helper.setGone(R.id.include_sj_value_value_layout1_2, false)
                                            .setGone(R.id.include_sj_value_obtain_layout1_2, false)
                                            .setGone(R.id.include_sj_value_obtain_layout1_2, false);
                                }
                                if (!TextUtils.isEmpty(item.getBranch_13()) && item.getBranch_13().length() > 0) {
                                    helper.setText(R.id.include_sj_value_value_layout1_3, item.getBranch_13())
                                            .setGone(R.id.include_sj_value_value_layout1_3, true)
                                            .setText(R.id.include_sj_value_obtain_layout1_3, getObtain(item.getObtain_13(), item.getTrend_13(), item.getGood_13()))
                                            .setGone(R.id.include_sj_value_obtain_layout1_3, true)
                                    ;
                                } else {
                                    helper.setGone(R.id.include_sj_value_value_layout1_3, false)
                                            .setGone(R.id.include_sj_value_obtain_layout1_3, false)
                                            .setGone(R.id.include_sj_value_obtain_layout1_3, false);
                                }
                            } else {
                                helper.setGone(R.id.item_wx_sj_list_value_1, false);
                            }

                            if (!TextUtils.isEmpty(item.getValue_2()) && item.getValue_2().length() > 0) {
                                helper.setGone(R.id.item_wx_sj_list_value_2, true);
                                helper.setText(R.id.include_sj_value_parent_layout2_1, item.getValue_2());
                                if (!TextUtils.isEmpty(item.getBranch_21()) && item.getBranch_21().length() > 0) {
                                    helper.setText(R.id.include_sj_value_value_layout2_1, item.getBranch_21())
                                            .setGone(R.id.include_sj_value_value_layout2_1, true)
                                            .setText(R.id.include_sj_value_obtain_layout2_1, getObtain(item.getObtain_21(), item.getTrend_21(), item.getGood_21()))
                                            .setGone(R.id.include_sj_value_obtain_layout2_1, true)
                                    ;
                                } else {
                                    helper.setGone(R.id.include_sj_value_value_layout2_1, false)
                                            .setGone(R.id.include_sj_value_obtain_layout2_1, false)
                                            .setGone(R.id.include_sj_value_obtain_layout2_1, false)
                                    ;
                                }
                                if (!TextUtils.isEmpty(item.getBranch_22()) && item.getBranch_22().length() > 0) {
                                    helper.setText(R.id.include_sj_value_value_layout2_2, item.getBranch_22())
                                            .setGone(R.id.include_sj_value_value_layout2_2, true)
                                            .setText(R.id.include_sj_value_obtain_layout2_2, getObtain(item.getObtain_22(), item.getTrend_22(), item.getGood_22()))
                                            .setGone(R.id.include_sj_value_obtain_layout2_2, true)
                                    ;
                                } else {
                                    helper.setGone(R.id.include_sj_value_value_layout2_2, false)
                                            .setGone(R.id.include_sj_value_obtain_layout2_2, false)
                                            .setGone(R.id.include_sj_value_obtain_layout2_2, false);
                                }
                                if (!TextUtils.isEmpty(item.getBranch_23()) && item.getBranch_23().length() > 0) {
                                    helper.setText(R.id.include_sj_value_value_layout2_3, item.getBranch_23())
                                            .setGone(R.id.include_sj_value_value_layout2_3, true)
                                            .setText(R.id.include_sj_value_obtain_layout2_3, getObtain(item.getObtain_23(), item.getTrend_23(), item.getGood_23()))
                                            .setGone(R.id.include_sj_value_obtain_layout2_3, true)
                                    ;
                                } else {
                                    helper.setGone(R.id.include_sj_value_value_layout2_3, false)
                                            .setGone(R.id.include_sj_value_obtain_layout2_3, false)
                                            .setGone(R.id.include_sj_value_obtain_layout2_3, false);
                                }
                            } else {
                                helper.setGone(R.id.item_wx_sj_list_value_2, false);
                            }

                            if (!TextUtils.isEmpty(item.getValue_3()) && item.getValue_3().length() > 0) {
                                helper.setGone(R.id.item_wx_sj_list_value_3, true);
                                helper.setText(R.id.include_sj_value_parent_layout3_1, item.getValue_3());
                                if (!TextUtils.isEmpty(item.getBranch_31()) && item.getBranch_31().length() > 0) {
                                    helper.setText(R.id.include_sj_value_value_layout3_1, item.getBranch_31())
                                            .setGone(R.id.include_sj_value_value_layout3_1, true)
                                            .setText(R.id.include_sj_value_obtain_layout3_1, getObtain(item.getObtain_31(), item.getTrend_31(), item.getGood_31()))
                                            .setGone(R.id.include_sj_value_obtain_layout3_1, true)
                                    ;
                                } else {
                                    helper.setGone(R.id.include_sj_value_value_layout3_1, false)
                                            .setGone(R.id.include_sj_value_obtain_layout3_1, false)
                                            .setGone(R.id.include_sj_value_obtain_layout3_1, false)
                                    ;
                                }
                                if (!TextUtils.isEmpty(item.getBranch_32()) && item.getBranch_32().length() > 0) {
                                    helper.setText(R.id.include_sj_value_value_layout3_2, item.getBranch_32())
                                            .setGone(R.id.include_sj_value_value_layout3_2, true)
                                            .setText(R.id.include_sj_value_obtain_layout3_2, getObtain(item.getObtain_32(), item.getTrend_32(), item.getGood_32()))
                                            .setGone(R.id.include_sj_value_obtain_layout3_2, true)
                                    ;
                                } else {
                                    helper.setGone(R.id.include_sj_value_value_layout3_2, false)
                                            .setGone(R.id.include_sj_value_obtain_layout3_2, false)
                                            .setGone(R.id.include_sj_value_obtain_layout3_2, false);
                                }
                                if (!TextUtils.isEmpty(item.getBranch_33()) && item.getBranch_33().length() > 0) {
                                    helper.setText(R.id.include_sj_value_value_layout3_3, item.getBranch_33())
                                            .setGone(R.id.include_sj_value_value_layout3_3, true)
                                            .setText(R.id.include_sj_value_obtain_layout3_3, getObtain(item.getObtain_33(), item.getTrend_33(), item.getGood_33()))
                                            .setGone(R.id.include_sj_value_obtain_layout3_3, true)
                                    ;
                                } else {
                                    helper.setGone(R.id.include_sj_value_value_layout3_3, false)
                                            .setGone(R.id.include_sj_value_obtain_layout3_3, false)
                                            .setGone(R.id.include_sj_value_obtain_layout3_3, false);
                                }
                            } else {
                                helper.setGone(R.id.item_wx_sj_list_value_3, false);
                            }
                        }
                    });
                }
            }
        };
        recyclerView.setAdapter(mAdapter);

        initData();

    }

    private void initData() {
        mAdapter.setNewData(mRealm.where(WXModel.class).findAll());
    }

    private CharSequence getObtain(@Nullable String obtain, int trend, int good) {
        CharSequence charSequence = new StringBuffer();
        SpanUtils spanUtils = new SpanUtils();
        if (!TextUtils.isEmpty(obtain) && obtain.length() > 0) {
            spanUtils.append(obtain);
        }
        if (trend != 0) {
            spanUtils.append("" + trend).setForegroundColor(trend > 0 ? ColorModel.color_守序 : ColorModel.color_恶);

        }
        if (good != 0) {

        }

        return spanUtils.create();
    }
}
