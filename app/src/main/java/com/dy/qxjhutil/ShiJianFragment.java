package com.dy.qxjhutil;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by hbysd on 2019/1/20.
 */

public class ShiJianFragment extends Fragment {


    public static ShiJianFragment newInstance() {
        Bundle args = new Bundle();
        ShiJianFragment fragment = new ShiJianFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
