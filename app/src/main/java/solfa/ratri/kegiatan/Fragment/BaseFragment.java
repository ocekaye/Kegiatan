package solfa.ratri.kegiatan.Fragment;

import android.support.v4.app.Fragment;

import solfa.ratri.kegiatan.BaseActivity;

/**
 * Created by Hinata on 12/9/2016.
 */
public class BaseFragment extends Fragment {
    protected BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }
}
