package com.devdream.cookall.ranking;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devdream.cookall.R;

public class CookersRankingActivityFragment extends Fragment {

    public CookersRankingActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cookers_ranking, container, false);
    }
}
