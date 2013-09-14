package com.austry.hhschool.activities;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.austry.hhschool.R;
import com.austry.hhschool.fragments.DatePickerFragment;
import com.austry.hhschool.fragments.FeedbackDialogFragment;


public class MainActivity extends FragmentActivity {
    public final static String EXTRA_NAME_MESSAGE = "com.austry.hhschool.activitys.MainActivity.NAME_MESSAGE";
    public final static String EXTRA_DATE_MESSAGE = "com.austry.hhschool.activitys.MainActivity.DATE_MESSAGE";
    public final static String EXTRA_SEX_MESSAGE = "com.austry.hhschool.activitys.MainActivity.SEX_MESSAGE";
    public final static String EXTRA_POSITION_MESSAGE = "com.austry.hhschool.activitys.MainActivity.POSITION_MESSAGE";
    public final static String EXTRA_SALARY_MESSAGE = "com.austry.hhschool.activitys.MainActivity.SALARY_MESSAGE";
    public final static String EXTRA_PHONE_MESSAGE = "com.austry.hhschool.activitys.MainActivity.PHONE_MESSAGE";
    public final static String EXTRA_EMAIL_MESSAGE = "com.austry.hhschool.activitys.MainActivity.EMAIL_MESSAGE";

    private String sexSpinnerSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Spinner
        Spinner spinner = (Spinner)findViewById(R.id.sexSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sexSpinnerSelection = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }



    public void showDatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"DatePickerFragment");
    }

    public void sendSummary(View v){
        Intent resultIntent = new Intent(this,ResultActivity.class);

        TextView fioTextView = (TextView) findViewById(R.id.nameEditText);
        TextView dateTextView = (TextView) findViewById(R.id.dateTextView);
        TextView positionTextView = (TextView) findViewById(R.id.positionEditText);
        TextView salaryTextView = (TextView) findViewById(R.id.salaryEditText);
        TextView phoneTextView = (TextView) findViewById(R.id.phoneEditText);
        TextView emailTextView = (TextView) findViewById(R.id.emailEditText);


        resultIntent.putExtra(EXTRA_NAME_MESSAGE,fioTextView.getText().toString());
        resultIntent.putExtra(EXTRA_DATE_MESSAGE,dateTextView.getText().toString());
        resultIntent.putExtra(EXTRA_POSITION_MESSAGE,positionTextView.getText().toString());
        resultIntent.putExtra(EXTRA_SALARY_MESSAGE,salaryTextView.getText().toString());
        resultIntent.putExtra(EXTRA_PHONE_MESSAGE,phoneTextView.getText().toString());
        resultIntent.putExtra(EXTRA_EMAIL_MESSAGE,emailTextView.getText().toString());
        resultIntent.putExtra(EXTRA_SEX_MESSAGE,sexSpinnerSelection);


        startActivityForResult(resultIntent, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            FeedbackDialogFragment dialogFragment = new FeedbackDialogFragment(data);
            dialogFragment.show(getSupportFragmentManager(),"FeedbackAlertFragment");

        }
    }
}
