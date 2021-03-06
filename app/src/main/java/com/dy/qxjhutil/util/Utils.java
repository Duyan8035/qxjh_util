package com.dy.qxjhutil.util;

import android.text.TextUtils;

import androidx.annotation.Nullable;

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
            if (!TextUtils.isEmpty(obtain) && obtain.length() > 0) {
                spanUtils.appendLine((trend > 0 ? "守+" : "混") + trend).setForegroundColor(trend > 0 ? ColorModel.color_守序 : ColorModel.color_混乱);
            } else {
                spanUtils.append((trend > 0 ? "守+" : "混") + trend).setForegroundColor(trend > 0 ? ColorModel.color_守序 : ColorModel.color_混乱);
            }
        }
        if (good != 0) {
            if (!TextUtils.isEmpty(obtain) && obtain.length() > 0) {
                spanUtils.appendLine((good > 0 ? "善+" : "恶") + good).setForegroundColor(good > 0 ? ColorModel.color_善 : ColorModel.color_恶);
            } else {
                spanUtils.append((good > 0 ? "善+" : "恶") + good).setForegroundColor(good > 0 ? ColorModel.color_善 : ColorModel.color_恶);
            }
        }
        if (!TextUtils.isEmpty(obtain) && obtain.length() > 0) {
            spanUtils.append(obtain).setFontProportion(0.8f);
        }
        return spanUtils.create();
    }

    public static CharSequence getTrend(int minTrend) {
        SpanUtils spanUtils = new SpanUtils();
        if (minTrend < 0) {
            spanUtils.append("混乱小于等于" + minTrend).setForegroundColor(ColorModel.color_混乱);
        } else if (minTrend == 0) {
            spanUtils.append("中立 -1~1").setForegroundColor(ColorModel.TYPE_COLOR_DEFAULT);
        } else {
            spanUtils.append("守序大于等于" + minTrend).setForegroundColor(ColorModel.color_混乱);
        }
        return spanUtils.create();
    }

    public static CharSequence getGood(int minTrend) {
        SpanUtils spanUtils = new SpanUtils();
        if (minTrend < 0) {
            spanUtils.append("邪恶小于等于" + minTrend).setForegroundColor(ColorModel.color_恶);
        } else if (minTrend == 0) {
            spanUtils.append("中立 -1~1").setForegroundColor(ColorModel.TYPE_COLOR_DEFAULT);
        } else {
            spanUtils.append("善良大于等于" + minTrend).setForegroundColor(ColorModel.color_善);
        }
        return spanUtils.create();
    }

    public static CharSequence getFloatQx(int qx, int se) {
        SpanUtils spanUtils = new SpanUtils();
        if (qx < 0) {
            spanUtils.append("混" + qx);
        } else if (qx == 0) {
            spanUtils.append("中立");
        } else {
            spanUtils.append("守" + qx);
        }
        if (se < 0) {
            spanUtils.append("恶" + se);
        } else if (se == 0) {
            spanUtils.append("中立");
        } else {
            spanUtils.append("善" + se);
        }
        return spanUtils.create();
    }

    public static CharSequence getKfValue(String cost, String value) {
        SpanUtils spanUtils = new SpanUtils();
        if (!TextUtils.isEmpty(cost) && cost.length() > 0) {
            spanUtils.appendLine("费用：" + cost);
        }
        spanUtils.append(value);
//        if (minTrend < 0) {
//            spanUtils.append("邪恶小于等于" + minTrend).setForegroundColor(ColorModel.color_恶);
//        } else if (minTrend == 0) {
//            spanUtils.append("中立 -1~1").setForegroundColor(ColorModel.TYPE_COLOR_DEFAULT);
//        } else {
//            spanUtils.append("善良大于等于" + minTrend).setForegroundColor(ColorModel.color_善);
//        }
        return spanUtils.create();
    }
}
