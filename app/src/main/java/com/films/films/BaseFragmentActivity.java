package com.films.films;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.films.films.fragments.BaseFragment;

/**
 * Created by mauriziofolcini on 12/10/2015.
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    protected abstract int getFragmentContainerId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void addFragment(BaseFragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(getFragmentContainerId(), fragment);

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commitAllowingStateLoss();
    }

    public void replaceFragment(BaseFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(getFragmentContainerId(), fragment);
        transaction.commitAllowingStateLoss();
    }

    public void removeFragment(BaseFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commitAllowingStateLoss();

        //fragmentManager.popBackStack();

        //focusTopFragment();
    }

    protected void removeAllFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        //focusTopFragment();
    }

    protected Fragment getTopFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        return fragmentManager.findFragmentById(getFragmentContainerId());
    }

}