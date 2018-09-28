package com.exam.bottomappbar.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.exam.bottomappbar.R;

/**
 * Created by jinyeong on 2018-09-28.
 */

public class PlusButtonFragment extends Fragment {

    public static PlusButtonFragment newInstance() {
        return new PlusButtonFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plusbutton, container, false);
        return view;
    }

}
