package com.austry.hhschool.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.austry.hhschool.R;

/**
 * Created by tt on 10.09.13.
 */
public class ResultActivity extends Activity {
    public static final String FEEDBACK_MESSAGE = "com.austry.hhschool.activitys.ResultActivity.FEEDBACK_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent resivedIntent = getIntent();
        TextView fioTextView = (TextView) findViewById(R.id.fioTextView);
        TextView dateTextView = (TextView) findViewById(R.id.dateTextView);
        TextView positionTextView = (TextView) findViewById(R.id.positionTextView);
        TextView salaryTextView = (TextView) findViewById(R.id.salaryTextView);
        TextView phoneTextView = (TextView) findViewById(R.id.phoneTextView);
        TextView emailTextView = (TextView) findViewById(R.id.emailTextView);
        TextView sexTextView = (TextView) findViewById(R.id.sexTextView);

        fioTextView.setText(resivedIntent.getStringExtra(MainActivity.EXTRA_NAME_MESSAGE));
        dateTextView.setText(resivedIntent.getStringExtra(MainActivity.EXTRA_DATE_MESSAGE));
        positionTextView.setText(resivedIntent.getStringExtra(MainActivity.EXTRA_POSITION_MESSAGE));
        salaryTextView.setText(resivedIntent.getStringExtra(MainActivity.EXTRA_SALARY_MESSAGE));
        phoneTextView.setText(resivedIntent.getStringExtra(MainActivity.EXTRA_PHONE_MESSAGE));
        emailTextView.setText(resivedIntent.getStringExtra(MainActivity.EXTRA_EMAIL_MESSAGE));
        sexTextView.setText(resivedIntent.getStringExtra(MainActivity.EXTRA_SEX_MESSAGE));

    }

    public void sendResult(View v){
        TextView feedbackTextView = (TextView) findViewById(R.id.feedbackEditText);
        String feedback = feedbackTextView.getText().toString();

        Intent resultIntent = new Intent(this,MainActivity.class);
        resultIntent.putExtra(FEEDBACK_MESSAGE, feedback);

        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        setResult(RESULT_CANCELED);
    }


}
