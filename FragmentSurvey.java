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
public class FragmentSurvey extends Fragment implements View.OnClickListener{
    private View mRootView;
    private TextView mIssue;
    private TextView mQuestion;
    private TextView mAnswer1;
    private TextView mAnswer2;
    private Context mContext;
    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private int position;
    private FragmentSurveyInterface mCallback;
    public FragmentSurvey(String i, String q, String a1, String a2, int p)
    { s1 = i; s2 = q; s3 = a1; s4 = a2; position = p;}
    public static FragmentSurvey newInstance(String i, String q, String a1, String a2, int pos) {
        return new FragmentSurvey(i, q, a1, a2, pos);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentSurveyInterface) context;
            mContext = context;
            mAnswer1.setOnClickListener(this);
            mAnswer2.setOnClickListener(this);
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentWelcomeInterface");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        mAnswer1 = mRootView.findViewById(R.id.surveyAnswer1);

        mAnswer2 = mRootView.findViewById(R.id.surveyAnswer2);
        mAnswer2.setOnClickListener(this);

        mIssue = mRootView.findViewById(R.id.surveyIssue);

        mQuestion = mRootView.findViewById(R.id.surveyQuestion);

        mIssue.setText(s1);
        mQuestion.setText(s2);
        mAnswer1.setText(s3);
        mAnswer2.setText(s4);


        return mRootView;
    }

    @Override
    public void onClick(View v) {
        if(v.equals(mRootView.findViewById(R.id.surveyAnswer1)))
            mCallback.getAnswer(0);
        if(v.equals(mRootView.findViewById(R.id.surveyAnswer2)))
            mCallback.getAnswer(1);
        mCallback.swipe(position+1);
    }

    public interface FragmentSurveyInterface {
        void getAnswer(Integer i);
        void swipe(int i);
    }

}
