package com.example.razzle.govote;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
public class FragmentNavigate extends Fragment implements View.OnClickListener{
    private View mRootView;
    private TextView mMeetCandidates;
    private TextView mFindIssues;
    private TextView mSurvey;
    private FragmentNavigateInterface mCallback;
    public FragmentNavigate() {

    }
    public static FragmentNavigate newInstance() {
        return new FragmentNavigate();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentNavigateInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentWelcomeInterface");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_navigate, container, false);

        //mLocationEditText = mRootView.findViewById(R.id.editLocation);
        mMeetCandidates = mRootView.findViewById(R.id.textView2);
        mMeetCandidates.setOnClickListener(this);

        mFindIssues = mRootView.findViewById(R.id.textView3);
        mFindIssues.setOnClickListener(this);

        mSurvey = mRootView.findViewById(R.id.textView4);
        mSurvey.setOnClickListener(this);

        return mRootView;
    }

    @Override
    public void onClick(View v) {
        if(v.equals(mRootView.findViewById(R.id.textView2)))
            mCallback.swipe(2);
        if(v.equals(mRootView.findViewById(R.id.textView3)))
            mCallback.swipe(8);
        if(v.equals(mRootView.findViewById(R.id.textView4)))
            mCallback.swipe(3);

    }

    public interface FragmentNavigateInterface {
        void swipe(int i);

    }

}
