package moe.johnny.handler_demo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton_thread;
    private Button mButton_class;
    private TestHandlerClass mTestHandlerClass;
    final static int MESSAGE_THREAD= 1;
    Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_THREAD:
                    mButton_thread.setText("Ok we handle it.");
                    break;
                case TestHandlerClass.MESSAGE_CLASS:
                    mButton_class.setText((String)msg.obj);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestHandlerClass = new TestHandlerClass(mHandler);

        mButton_thread = (Button) findViewById(R.id.button_thread);
        mButton_class = (Button) findViewById(R.id.button_class);

        mButton_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTestHandlerClass.exec();
            }
        });
        mButton_thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Runnable() {
                    @Override
                    public void run() {
                        Log.d("Handle:", "Thread");
                        mHandler.sendEmptyMessage(MESSAGE_THREAD);
                    }
                }.run();
            }
        });
    }
}
