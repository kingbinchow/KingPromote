package com.king.kingpromote.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.king.kingpromote.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by king.zhou on 2016/6/14.
 */
public class SpeakToTextActivity  extends AppCompatActivity {

    private Button mBtnTapToSpeech;
    private TextView mTxtSpeechInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak_to_text);
        mTxtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        mBtnTapToSpeech = (Button) findViewById(R.id.btnTapToSpeech);



        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);  //通过全局包管理器及特定intent，查找系统是否有语音识别的服务程序
        if (activities.size() != 0) {
            mBtnTapToSpeech.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    promptSpeechInput();
                }
            });
        } else {
            mBtnTapToSpeech.setEnabled(false);
            mBtnTapToSpeech.setText("Recognizer not present");    //否则将BUTTON显示值修改，并设置成不可选
        }
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Say something");

        try {
            startActivityForResult(intent, 100);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Not supported",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 100: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mTxtSpeechInput.setText(result.get(0));
                }
                break;
            }

        }
    }
}