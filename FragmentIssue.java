package com.example.razzle.govote;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.EditText;

public class FragmentIssue extends Fragment implements View.OnClickListener {

    private View mRootView;
    private FragmentIssueInterface mCallback;
    private TextView mButton;
    private TextView mIssue;
    private TextView mDescription;
    private Issue mIssueObject;
    private String mType;

    public FragmentIssue(String type) { mType = type; }

    public static FragmentIssue newInstance(String type) {
        return new FragmentIssue(type);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentIssueInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentWarmInterface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_issue, container, false);
        mIssue = mRootView.findViewById(R.id.issue);
        mIssue.setText("Edit your " + mType.toLowerCase() + "!");
        mDescription = mRootView.findViewById(R.id.description);
        //mButton = (TextView) mRootView.findViewById(R.id.submitwarm);
        mIssueObject = new Issue(mType, "Some description", 0);
        //mButton.setOnClickListener(this);
        return mRootView;
    }

    @Override
    public void onClick(View v) {
        //mCallback.swipe(0);

        Log.i("potato", mType);
    }

    public interface FragmentIssueInterface {
        void swipe(int i);
    }
}