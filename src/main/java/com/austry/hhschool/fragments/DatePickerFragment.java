package com.austry.hhschool.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.austry.hhschool.R;

import java.util.Calendar;

/**
 * Created by tt on 31.08.13.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener  {


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {

        TextView vs = (TextView) getActivity().findViewById(R.id.dateTextView);
        StringBuilder sb = new StringBuilder();
        sb.append(datePicker.getDayOfMonth());
        sb.append(".");
        sb.append(datePicker.getMonth()+1);
        sb.append(".");
        sb.append(datePicker.getYear());
        vs.setText(sb.toString());


    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        return new DatePickerDialog(getActivity() ,this ,year ,month ,day);

    }
}
