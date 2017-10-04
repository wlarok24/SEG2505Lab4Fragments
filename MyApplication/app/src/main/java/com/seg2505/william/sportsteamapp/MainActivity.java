package com.seg2505.william.sportsteamapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageNameFragment fragment;
    private static final String TAG_RETAINED_FRAGMENT = "ImageNameFragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Draw imageName
        /*
        Using google documentation on fragments
        https://developer.android.com/guide/topics/resources/runtime-changes.html  
         */
        // find the retained fragment on activity restarts
        FragmentManager fm = getFragmentManager();
        fragment = (ImageNameFragment) fm.findFragmentByTag(TAG_RETAINED_FRAGMENT);

        // create the fragment and data the first time
        if (fragment == null) {
            // add the fragment
            fragment = new ImageNameFragment();
            fm.beginTransaction().add(fragment, TAG_RETAINED_FRAGMENT).commit();
            // load data from a data source or perform any calculation
            fragment.setData("ic_logo00");
        }
        ImageView avatarImage = (ImageView) findViewById(R.id.TeamImage);
        int resID = getResources().getIdentifier(fragment.getData(), "drawable",  getPackageName());
        avatarImage.setImageResource(resID);
    }

    public void OnOpenInGoogleMaps (View view) {
        EditText teamAddress = (EditText) findViewById(R.id.locationField);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivityForResult (intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;
        ImageView avatarImage = (ImageView) findViewById(R.id.TeamImage);

        String drawableName = "ic_logo_00"; //4
        switch (data.getIntExtra("imageID", R.id.teamlogo00)) {//Figuring out the correct image
            case R.id.teamlogo00: //Default case
                drawableName = "ic_logo00";
                break;
            case R.id.teamlogo01:
                drawableName = "ic_logo01";
                break;
            case R.id.teamlogo02:
                drawableName = "ic_logo02";
                break;
            case R.id.teamlogo03:
                drawableName = "ic_logo03";
                break;
            case R.id.teamlogo04:
                drawableName = "ic_logo04";
                break;
            case R.id.teamlogo05:
                drawableName = "ic_logo05";
                break;
            case R.id.teamlogo06:
                drawableName = "ic_logo06";
                break;
            case R.id.teamlogo07:
                drawableName = "ic_logo07";
                break;
            case R.id.teamlogo08:
                drawableName = "ic_logo08";
                break;
            default:
                drawableName = "ic_logo00";
                break;
        } //27
        fragment.setData(drawableName);
        int resID = getResources().getIdentifier(drawableName, "drawable",  getPackageName());
        avatarImage.setImageResource(resID);
    }
}
