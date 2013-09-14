package com.austry.hhschool.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.austry.hhschool.R;
import com.austry.hhschool.activities.ResultActivity;


/**
 * Created by tt on 12.09.13.
 */
public class FeedbackDialogFragment extends DialogFragment {
    private Intent data;

    public FeedbackDialogFragment(Intent data) {
        this.data = data;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(data.getStringExtra(ResultActivity.FEEDBACK_MESSAGE.toString()))
               .setPositiveButton(R.string.feedback_dialog_positive_button_text,null)
               .setTitle(R.string.feedback_dialog_title_text);
        return builder.create();

    }
}
