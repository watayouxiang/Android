package com.watayouxiang.mykotlin._07_advancedtypes.inlineclassed;

import androidx.annotation.IntDef;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/12
 *     desc   :
 *
 * </pre>
 */
class eg_IntDef {
    public static final int WALK = 0;
    public static final int BUS = 1;
    public static final int CAR = 2;

    @IntDef({WALK, BUS, CAR})
    public @interface RouteTypeDef {

    }

    public static void setRouteType(@RouteTypeDef int routeType) {

    }

    public static void main(String[] args) {
        setRouteType(CAR);
    }

}
