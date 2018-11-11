package com.example.razzle.govote;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity implements FragmentWelcome.FragmentWelcomeInterface,
        FragmentIssue.FragmentIssueInterface, FragmentAllIssues.FragmentAllIssuesInterface,
        FragmentNavigate.FragmentNavigateInterface, FragmentSurvey.FragmentSurveyInterface {
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    //Strings
    private String mLocation;

    //Strings with default workouts
    //private Workout warmupObject;
    //private Workout cardioObject;
    //private Workout workoutObject;
    //private Workout stretchObject;

    //Fragments
    private FragmentWelcome mWelcomeFrag = FragmentWelcome.newInstance();
    private FragmentAllIssues mAllIssuesFrag = FragmentAllIssues.newInstance();
    private FragmentIssue mAbortionFrag = FragmentIssue.newInstance("Abortion");
    private FragmentIssue mEducationFrag = FragmentIssue.newInstance("Education");
    private FragmentIssue mGunPolicyFrag = FragmentIssue.newInstance("Gun Policy");
    private FragmentIssue mLGBTQFrag = FragmentIssue.newInstance("LGBTQ");
    private FragmentIssue mTaxReformFrag = FragmentIssue.newInstance("Tax Reform");
    private FragmentNavigate mNavigateFrag = FragmentNavigate.newInstance();
    private FragmentNavigate mCandidateFrag = FragmentNavigate.newInstance();
    private FragmentSurvey mSurveyQ1 = FragmentSurvey.newInstance("Abortion", "Do you support pro-life or pro-choice?", "Pro-life", "Pro-choice", 3);
    private FragmentSurvey mSurveyQ2 = FragmentSurvey.newInstance("Education", "Do you support more funding for public education?", "Yes", "No", 4);
    private FragmentSurvey mSurveyQ3 = FragmentSurvey.newInstance("Gun policy", "Do you support more or less gun restriction?", "Less Gun Restriction", "More Gun Restriction", 5);
    private FragmentSurvey mSurveyQ4 = FragmentSurvey.newInstance("LGBTQ", "Do you support marriage rights for the LGBTQ community?", "Yes", "No", 6);
    private FragmentSurvey mSurveyQ5 = FragmentSurvey.newInstance("Tax Reform", "Do you support tax cuts or tax raises for lower and middle class citizens?", "Tax cuts", "Tax Raises", 7);


    //SharedPreferences
    private SharedPreferences mSettings;
    SharedPreferences.Editor editor;
    Gson mGson;

    private ArrayList<Integer> arr = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Map<String, ArrayList<String>> virginiaReps = new TreeMap<String, ArrayList<String>>();
        ArrayList<String> district1 =
                new ArrayList<String>() {
                    {add("Robert Wittman"); add("Vangie Williams");}};
        ArrayList<String> district2 =
                new ArrayList<String>() {
                    {add("Scott Taylor"); add("Elaine Luria");}};
        ArrayList<String> district3 =
                new ArrayList<String>() {
                    {add("Bobby Scott");}};
        ArrayList<String> district4 =
                new ArrayList<String>() {
                    {add("Donald McEachin"); add("Ruam McAdams"); add("Pete Wells");}};
        ArrayList<String> district5 =
                new ArrayList<String>() {
                    {add("Leslie Cockburn"); add("Denver Riggleman");}};
        ArrayList<String> district6 =
                new ArrayList<String>() {
                    {add("Jennifer Lewis"); add("Ben Cline");}};
        ArrayList<String> district7 =
                new ArrayList<String>() {
                    {add("David Brat"); add("Abigail Spanberger"); add("Joe Walton");}};
        ArrayList<String> district8 =
                new ArrayList<String>() {
                    {add("Donald Beyer"); add("Thomas Oh");}};
        ArrayList<String> district9 =
                new ArrayList<String>() {
                    {add("Morgan Griffith"); add("Anthony Flaccavento");}};
        ArrayList<String> district10 =
                new ArrayList<String>() {
                    {add("Barbara Comstock"); add("Jennifer Wextin");}};
        ArrayList<String> district11 =
                new ArrayList<String>() {
                    {add("Gerald Connolly"); add("Jeff Dove Jr."); add("Stevan Porter");}};

        virginiaReps.put("District1", district1);
        virginiaReps.put("District2", district2);
        virginiaReps.put("District3", district3);
        virginiaReps.put("District4", district4);
        virginiaReps.put("District5", district5);
        virginiaReps.put("District6", district6);
        virginiaReps.put("District7", district7);
        virginiaReps.put("District8", district8);
        virginiaReps.put("District9", district9);
        virginiaReps.put("District10", district10);
        virginiaReps.put("District11", district11);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getLocationChanges(String s){
        mLocation = s;
        updateMasterFrag();
    }

    public void updateMasterFrag(){
        Log.i("Potato", "No error calling updateMasterFrag.");
        //Log.i("Potato", warmupObject.toString());
        //myMasterFrag.setWarmupText(warmupObject.toString());
    }

    public void swipe(int i){
        mViewPager.setCurrentItem(i);
    }

    public void getAnswer(Integer i)
    {
        arr.add(i);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0: {
                    mWelcomeFrag = FragmentWelcome.newInstance(mLocation);
                    Log.i("Case", "0");
                    return mWelcomeFrag;
                }
                case 1: {
                    mNavigateFrag = FragmentNavigate.newInstance();
                    Log.i("Case", "1");
                    return mNavigateFrag;
                }
                case 2: {
                    //candidates
                    mCandidateFrag = FragmentNavigate.newInstance();
                    Log.i("Case", "2");
                    return mCandidateFrag;
                }
                case 3: {
                    //survey q1
                    mSurveyQ1 = FragmentSurvey.newInstance("Abortion", "Do you support pro-life or pro-choice?", "Pro-life", "Pro-choice", 3);
                    Log.i("Case", "3");
                    return mSurveyQ1;
                }
                case 4: {
                    //survey q2
                    mSurveyQ2 = FragmentSurvey.newInstance("Education", "Do you support more funding for public education?", "Yes", "No", 4);
                    Log.i("Case", "4");
                    return mSurveyQ2;
                }
                case 5: {
                    //survey q3
                    mSurveyQ3 = FragmentSurvey.newInstance("Gun policy", "Do you support more or less gun restriction?", "Less Gun Restriction", "More Gun Restriction", 5);
                    Log.i("Case", "5");
                    return mSurveyQ3;
                }
                case 6: {
                    //survey q4
                    mSurveyQ4 = FragmentSurvey.newInstance("LGBTQ", "Do you support marriage rights for the LGBTQ community?", "Yes", "No", 6);
                    Log.i("Case", "6");
                    return mSurveyQ4;
                }
                case 7: {
                    //survey q5
                    mSurveyQ5 = FragmentSurvey.newInstance("Tax Reform", "Do you support tax cuts or tax raises for lower and middle class citizens?", "Tax cuts", "Tax Raises", 7);
                    Log.i("Case", "7");
                    return mSurveyQ5;
                }
                case 8: {
                    mAllIssuesFrag = FragmentAllIssues.newInstance();
                    Log.i("Case", "8");
                    return mAllIssuesFrag;
                }
                case 9: {
                    mAbortionFrag = FragmentIssue.newInstance("Abortion");
                    Log.i("Case", "9");
                    return mAbortionFrag;
                }
                case 10: {
                    mEducationFrag = FragmentIssue.newInstance("Education");
                    Log.i("Case", "10");
                    return mEducationFrag;
                }
                case 11: {
                    mGunPolicyFrag = FragmentIssue.newInstance("Gun Policy");
                    Log.i("Case", "11");
                    return mGunPolicyFrag;
                }
                case 12: {
                    mLGBTQFrag = FragmentIssue.newInstance("LGBTQ");
                    Log.i("Case", "12");
                    return mLGBTQFrag;
                }
                case 13: {
                    mTaxReformFrag = FragmentIssue.newInstance("Tax Reform");
                    Log.i("Case", "13");
                    return mTaxReformFrag;
                }
                default: {
                    return null;
                }
            }
        }

        @Override
        public int getCount() {
            return 13;
        }
    }
}
