package solfa.ratri.kegiatan.Fragment;

import android.support.v4.app.Fragment;

import solfa.ratri.kegiatan.BaseActivity;

/**
 * Created by Hinata on 12/9/2016.
 */
public abstract class BaseFragment extends Fragment {
    public abstract String setTitle();

    @Override
    public void onResume() {
        super.onResume();
        getBaseActivity().setTitle(setTitle());
    }

    protected BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }
}
