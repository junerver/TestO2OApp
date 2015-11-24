package com.junerver.testo2oapp.utils;

/**
 * Created by Junerver on 2015/11/11.
 */
public interface HttpCallbackListener {
    //在实现时这个方法中填写返回值的处理方法
    void onFinish(String response);

    void onError(Exception e);
}
