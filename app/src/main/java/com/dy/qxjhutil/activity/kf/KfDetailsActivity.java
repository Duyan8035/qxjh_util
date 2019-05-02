package com.dy.qxjhutil.activity.kf;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.KungFuModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.dy.qxjhutil.util.Utils;

public class KfDetailsActivity extends BaseActivity {

    private ImageView img;
    private TextView tv_name, tv_value, tv_value2;

    private String name;
    private KungFuModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kf_details);
        name = getIntent().getStringExtra("name");

        initView();

        if (!TextUtils.isEmpty(name) && name.length() > 0) {
            mModel = RealmHelper.getInstance(mContext).where(KungFuModel.class).equalTo("name", name).findFirst();
            if (mModel != null) {
                initData();
            } else {
                tv_name.setText("暂无数据");
                ToastUtils.showLong("暂无数据");
            }
        } else {
            tv_name.setText("暂无数据");
            ToastUtils.showLong("暂无数据");
        }


    }

    private void initData() {
        tv_name.setText(mModel.getName());
        img.setImageResource(mModel.getImg());
        tv_value.setText(Utils.getKfValue(mModel.getCost(), mModel.getDesc()));
    }

    private void initView() {
        img = findViewById(R.id.act_kf_details_img);
        tv_name = findViewById(R.id.act_kf_details_name);
        tv_value = findViewById(R.id.act_kf_details_value);
        tv_value2 = findViewById(R.id.act_kf_details_value2);
    }
}
