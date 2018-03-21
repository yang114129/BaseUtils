package com.yang.baseutils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.igexin.sdk.PushManager;
import com.vondear.rxtools.RxActivityTool;
import com.vondear.rxtools.RxTool;
import com.vondear.rxtools.activity.ActivityScanerCode;
import com.vondear.rxtools.view.RxQRCode;
import com.yang.apputils.AppManager;
import com.yang.push.service.GeTuiService;
import com.yang.push.service.GetuiIntentService;

public class BUMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bumain);
        PushManager.getInstance().initialize(this.getApplicationContext(), GeTuiService.class);
        // com.getui.demo.DemoIntentService 为第三方自定义的推送服务事件接收类
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), GetuiIntentService.class);
        RxTool.init(this);

        Intent intent = new Intent(BUMainActivity.this,ActivityScanerCode.class);
        startActivity(intent);
    }
}
