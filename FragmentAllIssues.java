package com.example.razzle.govote;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentAllIssues extends Fragment implements View.OnClickListener{

    private View mRootView;
    private FragmentAllIssuesInterface mCallback;

    private TextView mAbortionTextView;
    private TextView mEducationTextView;
    private TextView mGunPolicyTextView;
    private TextView mLGBTQTextView;
    private TextView mTaxReformTextView;

    public FragmentAllIssues() {
    }

    public static FragmentAllIssues newInstance() {
        return new FragmentAllIssues();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentAllIssuesInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentOneInterface");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_all_issues, container, false);

        mAbortionTextView = mRootView.findViewById(R.id.tvAbortion);
        mAbortionTextView.setOnClickListener(this);

        mEducationTextView = mRootView.findViewById(R.id.tvEducation);
        mEducationTextView.setOnClickListener(this);

        mGunPolicyTextView = mRootView.findViewById(R.id.tvGunPolicy);
        mGunPolicyTextView.setOnClickListener(this);

        mLGBTQTextView = mRootView.findViewById(R.id.tvLGBTQ);
        mLGBTQTextView.setOnClickListener(this);

        mTaxReformTextView = mRootView.findViewById(R.id.tvTaxReform);
        mTaxReformTextView.setOnClickListener(this);

        return mRootView;
    }

    @Override
    public void onClick(View v) {
        if(v.equals(mRootView.findViewById(R.id.tvAbortion)))
            mCallback.swipe(10);
        if(v.equals(mRootView.findViewById(R.id.tvEducation)))
            mCallback.swipe(11);
        if(v.equals(mRootView.findViewById(R.id.tvGunPolicy)))
            mCallback.swipe(12);
        if(v.equals(mRootView.findViewById(R.id.tvLGBTQ)))
            mCallback.swipe(13);
        if(v.equals(mRootView.findViewById(R.id.tvTaxReform)))
            mCallback.swipe(14);
    }


    public interface FragmentAllIssuesInterface {
        void swipe(int i);
    }
}