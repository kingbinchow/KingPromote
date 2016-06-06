package com.king.kingpromote.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.king.kingpromote.R;

/**
 * Created by king.zhou on 2016/5/27.
 */
public class JavaJsInteractionActivityDemo extends Activity {

    FrameLayout webViewFrameLayout;

    TextView javaCallJsTv;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_js_interaction);

        webViewFrameLayout = (FrameLayout)findViewById(R.id.fl_webView);
        javaCallJsTv = (TextView) findViewById(R.id.tv_java_call_js);

        webView = createWebView(getApplicationContext());

        webViewFrameLayout.addView(webView);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                bindListener();
            }

        });

        //loadUrl
        webView.loadUrl("file:///android_asset/js_java_interaction.html");

    }



    private void bindListener() {

        javaCallJsTv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String jsString = "javascript:sumToJava(45,12)";
                webView.loadUrl(jsString);

                testEvaluateJavascript(webView);

            }
        });
    }

    private WebView createWebView(Context context) {
        WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        //1.js call java
        //webView need addJavascriptInterface
        webView.addJavascriptInterface(new JsCallJava(),"jsCallJava");

        return webView;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void testEvaluateJavascript(WebView webView) {
        webView.evaluateJavascript("testEvaluateJavascript()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                Log.i("TB", "onReceiveValue value=" + value);
            }
        });
    }



    class JsCallJava{

        @JavascriptInterface
        public void showDialog(final String message){

            new AlertDialog.Builder(JavaJsInteractionActivityDemo.this)
                    .setTitle("alert")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage(message)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }).create().show();
//            Toast.makeText(JavaJsInteractionActivityDemo.this,message,Toast.LENGTH_LONG).show();
//            JavaJsInteractionActivityDemo.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    TextView tv = (TextView)findViewById(R.id.tv_content);
//                    tv.setText(message);
//                }
//            });



        }
        @JavascriptInterface
        public void onSumResult(String result) {
            Toast.makeText(JavaJsInteractionActivityDemo.this,result,Toast.LENGTH_LONG).show();
            Log.i("TB", "onSumResult result=" + result);
        }

    }
}
