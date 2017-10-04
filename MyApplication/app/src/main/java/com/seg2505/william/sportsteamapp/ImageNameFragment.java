package com.seg2505.william.sportsteamapp;

import android.os.Bundle;
import android.app.Fragment;

/**
 * Created by William LaRocque  on 04/10/2017.
 * Using Google documentation
 * https://developer.android.com/guide/topics/resources/runtime-changes.html  
 */

public class ImageNameFragment extends Fragment {
    private String imageName;

    // this method is only called once for this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
    }

    public void setData(String imageName) {
        this.imageName = imageName;
    }

    public String getData() {
        return imageName;
    }
}
