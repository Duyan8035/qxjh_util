package com.dy.qxjhutil.util;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.blankj.utilcode.util.SpanUtils;
import com.dy.qxjhutil.constant.ColorModel;

/**
 * Created by Dy on 2019/4/20 17
 *
 * @author Dy
 */
public class Utils {

    public static CharSequence getObtain(@Nullable String obtain, int trend, int good) {
        SpanUtils spanUtils = new SpanUtils();
        if (trend != 0) {
            spanUtils.appendLine((trend > 0 ? "守序+" : "混乱") + trend).setForegroundColor(trend > 0 ? ColorModel.color_守序 : ColorModel.color_混乱);
        }
        if (good != 0) {
            spanUtils.appendLine((good > 0 ? "善+" : "恶") + good).setForegroundColor(good > 0 ? ColorModel.color_善 : ColorModel.color_恶);
        }
        if (!TextUtils.isEmpty(obtain) && obtain.length() > 0) {
            spanUtils.append(obtain);
        }
        return spanUtils.create();
    }

    public static CharSequence getTrend(int minTrend) {
        SpanUtils spanUtils = new SpanUtils();
        if (minTrend < 0) {
            spanUtils.append("混乱 < " + minTrend).setForegroundColor(ColorModel.color_混乱);
        } else if (minTrend == 0) {
            spanUtils.append("中立 -1~1").setForegroundColor(ColorModel.TYPE_COLOR_DEFAULT);
        } else {
            spanUtils.append("守序 > +" + minTrend).setForegroundColor(ColorModel.color_混乱);
        }
        return spanUtils.create();
    }

    public static CharSequence getGood(int minTrend) {
        SpanUtils spanUtils = new SpanUtils();
        if (minTrend < 0) {
            spanUtils.append("恶 < " + minTrend).setForegroundColor(ColorModel.color_恶);
        } else if (minTrend == 0) {
            spanUtils.append("中立 -1~1").setForegroundColor(ColorModel.TYPE_COLOR_DEFAULT);
        } else {
            spanUtils.append("善 > +" + minTrend).setForegroundColor(ColorModel.color_善);
        }
        return spanUtils.create();
    }
}
