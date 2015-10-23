package com.films.films.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.films.films.BaseFragmentActivity;

public abstract class BaseFragment extends Fragment
{

    protected View view;

    @SuppressWarnings("unchecked")
    protected final <T> T getParameter(String key, T defaultValue)
    {
        Bundle extras = getArguments();

        if ((extras != null) && extras.containsKey(key))
        {
            return (T) extras.get(key);
        }
        else
        {
            return defaultValue;
        }
    }

    @SuppressWarnings("unchecked")
    protected final <T> T getParent(Class<T> parentClass)
    {
        Fragment parentFragment = getParentFragment();

        if (parentClass.isInstance(parentFragment))
        {
            return (T) parentFragment;

        }
        else if (parentClass.isInstance(getActivity()))
        {
            return (T) getActivity();

        }

        return null;
    }

    public void addFragment(BaseFragment fragment, boolean addToBackStack)
    {
        BaseFragmentActivity baseFragmentActivity = getParent(BaseFragmentActivity.class);

        if (baseFragmentActivity != null)
        {
            baseFragmentActivity.addFragment(fragment, addToBackStack);
        }
    }

    protected void removeFragment()
    {
        BaseFragmentActivity baseFragmentActivity = getParent(BaseFragmentActivity.class);

        if (baseFragmentActivity != null)
        {
            baseFragmentActivity.removeFragment(this);
        }
    }

    public Context getContext()
    {
        return getActivity();
    }

}
