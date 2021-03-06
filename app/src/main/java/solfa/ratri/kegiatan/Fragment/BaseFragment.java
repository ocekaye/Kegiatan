package solfa.ratri.kegiatan.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import solfa.ratri.kegiatan.BaseActivity;

/**
 * Created by Ratri on 12/9/2016.
 */
public abstract class BaseFragment extends Fragment {
    public abstract String setTitle();
    public abstract boolean enableSearch();

    @Override
    public void onResume() {
        super.onResume();
        getBaseActivity().setTitle(setTitle());
        getBaseActivity().hasSearchView(enableSearch());
    }

    protected BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }

    public void setHasSearchView(){
        getBaseActivity().hasSearchView(enableSearch());
    }
}
