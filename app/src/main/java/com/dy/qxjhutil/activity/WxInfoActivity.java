package com.dy.qxjhutil.activity;

import com.dy.qxjhutil.base.BaseActivity;

public class WxInfoActivity extends BaseActivity {
/*
    Realm mRealm;

    private RecyclerView mRecyclerView;
    private BaseQuickAdapter<Valuemodel, BaseViewHolder> mAdapter;

    private String mName;
    private WXModel wxModel;
//    private RealmList<WXModel.SJModel> sjModels = new RealmList<>();

    private List<Valuemodel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_info);
        initView();

        Realm.init(this);
        mRealm = mRealm = RealmHelper.getInstance(mContext);;

        RealmResults<WXModel> wxModels = mRealm.where(WXModel.class).equalTo("name_game", mName).findAll();
        for (int i = 0; i < wxModels.size(); i++) {
            if (wxModels.get(i).getSjModels() != null) {
                sjModels.addAll(wxModels.get(i).getSjModels());
            }
        }
        initData();
    }

    private void initData() {
        if (sjModels == null || sjModels.size() == 0) {
            ToastUtils.showLong("数据为空");
            return;
        }

        models = new ArrayList<>();
        *//**
         * 重新组装数据
         *//*
        for (int i = 0; i < sjModels.size(); i++) {
            if (sjModels.get(0).getSj_1_list().size() > 0) {

            }
            if (sjModels.get(0).getSj_12_list().size() > 0) {

            }
            if (sjModels.get(0).getSj_123_list().size() > 0) {

            }
        }
        mAdapter.setNewData(models);
    }

    private Valuemodel getValuemodel(WXModel.SJModel sjModel) {
        SpanUtils spanUtils = new SpanUtils();
        if (sjModel.getSj_se() < 0) {
            spanUtils.appendLine("恶" + sjModel.getSj_se()).setForegroundColor(ColorModel.color_恶);
        } else {
            spanUtils.appendLine("善" + sjModel.getSj_se()).setForegroundColor(ColorModel.color_善);
        }
        if (sjModel.getSj_se() < 0) {
            spanUtils.appendLine("混乱" + sjModel.getSj_qx()).setForegroundColor(ColorModel.color_混乱);
        } else {
            spanUtils.appendLine("守序" + sjModel.getSj_qx()).setForegroundColor(ColorModel.color_守序);
        }
        if (!TextUtils.isEmpty(sjModel.getSj_value())) {
            spanUtils.append(sjModel.getSj_value());
        }


        return new Valuemodel(spanUtils.create(), spanUtils.create());

    }

    private void getList(WXModel.SJModel bean) {
        models.add(getValuemodel(bean));
        if (bean.getSj_1_list().size() > 0) {
            for (int i = 0; i < bean.getSj_1_list().size(); i++) {
                getList(bean.getSj_1_list().get(i));
            }
        }
        if (bean.getSj_12_list().size() > 0) {
            for (int i = 0; i < bean.getSj_12_list().size(); i++) {
                getList(bean.getSj_12_list().get(i));
            }
        }
        if (bean.getSj_123_list().size() > 0) {
            for (int i = 0; i < bean.getSj_123_list().size(); i++) {
                getList(bean.getSj_123_list().get(i));
            }
        }
    }


    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mAdapter = new BaseQuickAdapter<Valuemodel, BaseViewHolder>(R.layout.item_sj) {
            @Override
            protected void convert(BaseViewHolder helper, Valuemodel item) {
//                helper.setImageResource(R.id.item_qmui_img, item.getIcon())
//                        .setText(R.id.item_text, item.getName_game() +
//                                (TextUtils.isEmpty(item.getName()) ? "" : "(" + item.getName() + ")"))
//                ;
            }
        };
        mRecyclerView.setAdapter(mAdapter);
    }


    class Valuemodel {
        public CharSequence key, value;

        public Valuemodel(CharSequence key, CharSequence value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Realm instance.
        mRealm.close();
    }*/
}
