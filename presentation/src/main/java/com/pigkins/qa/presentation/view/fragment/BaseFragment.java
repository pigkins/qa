package com.pigkins.qa.presentation.view.fragment;

import android.app.Fragment;
import android.widget.Toast;

import com.pigkins.qa.presentation.internal.di.HasComponent;

/**
 * Created by qding on 10/16/16.
 */
public class BaseFragment extends Fragment {
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((HasComponent<T>) getActivity()).getComponent());
    }
}
