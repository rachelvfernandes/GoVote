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

public class FragmentWelcome extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private View mRootView;
    private FragmentWelcomeInterface mCallback;
    private Context mContext;
    private Spinner mLocationEdit;
    private TextView mLocationSubmit;
    private String mLocationString;
    //private TextView mWelcome;
    public FragmentWelcome() {

    }
    public FragmentWelcome(String loc) { loc = mLocationString; }
    public static FragmentWelcome newInstance() {
        return new FragmentWelcome();
    }
    public static FragmentWelcome newInstance(String loc) {
        return new FragmentWelcome(loc);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentWelcomeInterface) context;
            mContext = context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentWelcomeInterface");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        //mLocationEditText = mRootView.findViewById(R.id.editLocation);
        mLocationSubmit = mRootView.findViewById(R.id.submitLocation);
        mLocationSubmit.setOnClickListener(this);

        mCallback.getLocationChanges(mLocationString);
        //mCallback.swipe(0);

        mLocationEdit = mRootView.findViewById(R.id.editLocation);
        //String[] districts = new String[]{"District 1", "District 2", "District 3", "District 4",
         //       "District 5", "District 6", "District 7", "District 8", "District 9", "District 10", "District 11"};
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mContext, R.array.districts, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLocationEdit.setAdapter(adapter);
        mLocationEdit.setOnItemSelectedListener(this);

        //mWelcome = mRootView.findViewById(R.id.tvWelcome);

        return mRootView;
    }

    //@Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        mLocationString = parent.getItemAtPosition(pos).toString();
        mCallback.getLocationChanges(mLocationString);
        //mWelcome.setText(mLocationString);
        Log.i("Orange", "Location was received");
    }

    public void onNothingSelected(AdapterView<?> parent) {
     int i = 0;
    }
    @Override
    public void onClick(View v) {
        //String s = mLocationEdit.get
        //if(!mLocationEdit.getText().toString().equals("Location"))
            //mLocationString = mLocationEdit.getText().toString();

        mCallback.getLocationChanges(mLocationString);
        Log.i("Orange", "onItemSelected called");

        mCallback.swipe(1);

    }

    public void setLocationText(String s)
    {
        //mLocationEdit.setText(s);
    }

    public interface FragmentWelcomeInterface {
        void getLocationChanges(String s);
        void swipe(int i);

    }
}