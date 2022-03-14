package com.example.bestqr;

import android.app.Activity;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class CameraActivityTest {
    private Solo solo;

    @Rule
    public ActivityTestRule<CameraActivity> rule=
            new ActivityTestRule<>(CameraActivity.class, true, true);

    @Before
    public void setUp()throws Exception{
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), rule.getActivity());

    }

    @Test
    public void start()throws Exception{
        Activity activity = rule.getActivity();
    }

    @Test
    public void CameraTest(){
        solo.assertCurrentActivity("Wrong activity", CameraActivity.class);
        solo.clickOnButton("Scan");
        solo.clickOnImageButton(0);

    }

//    @Test
//    public void LeaderBordTest(){
//        solo.assertCurrentActivity("Wrong activity", CameraActivity.class);
//        solo.waitForFragmentById(R.id.navigation_leaderboard_main, 2000);
//
//    }
//
//    @Test
//    public void UserTest(){
//        solo.assertCurrentActivity("Wrong activity", CameraActivity.class);
//        solo.waitForFragmentByTag("User", 2000);
//    }
//
//    @Test
//    public void MapTest(){
//        solo.assertCurrentActivity("Wrong activity", CameraActivity.class);
//        solo.waitForFragmentByTag("Map", 2000);
//    }



    @After
    public void tearDown()throws Exception{
        solo.finishOpenedActivities();
    }


}