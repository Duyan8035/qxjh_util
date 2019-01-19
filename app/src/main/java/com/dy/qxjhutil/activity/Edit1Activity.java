package com.dy.qxjhutil.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.jkb.fragment.rigger.annotation.Puppet;

@Puppet(containerViewId = R.id.fragment)
public class Edit1Activity extends BaseActivity {

    private Spinner spinner1, spinner2;
    private String[] strs_01, strs_02;
    private Switch aSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit1);
        initView();

        initData();
    }

    private void initData() {



    }

    private void initView() {
        spinner1 = findViewById(R.id.act_edit1_spinner1);
        spinner2 = findViewById(R.id.act_edit1_spinner2);
        aSwitch = findViewById(R.id.act_edit1_switch1);

        strs_01 = mContext.getResources().getStringArray(R.array.array_test1_name);
        strs_02 = mContext.getResources().getStringArray(R.array.array_test1_type);


        ArrayAdapter<String> adapter_01 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strs_01);
        adapter_01.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter_01);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ArrayAdapter<String> adapter_02 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strs_02);
        adapter_02.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter_02);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    findViewById(R.id.act_edit1_edit_group).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.act_edit1_edit_group).setVisibility(View.GONE);
                }
            }
        });
    }
}
