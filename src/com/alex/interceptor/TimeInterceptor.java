package com.alex.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.err.println("时间拦截器生效");

//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Calendar calendar = Calendar.getInstance();
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String date = dateFormat.format(calendar.getTime());
        int time = Integer.parseInt(date);
        if (13 > time  || time > 17) {
            System.out.println("所在时间不是开放时间范围");
            return "time";
        }
        return actionInvocation.invoke();
    }
}
