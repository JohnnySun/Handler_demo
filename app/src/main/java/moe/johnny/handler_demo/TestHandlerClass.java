package moe.johnny.handler_demo;

import android.os.Handler;
import android.os.Message;

/**
 * Created by JohnnySun on 7/16/2016.
 */

public class TestHandlerClass {
    final static int MESSAGE_CLASS = 2;

    Handler mHandler;
    public TestHandlerClass(Handler mHandler) {
        this.mHandler = mHandler;
    }

    public void exec() {
        Message msg = mHandler.obtainMessage(MESSAGE_CLASS, "We handle it!");
        mHandler.sendMessage(msg);
    }
}
