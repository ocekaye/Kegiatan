package solfa.ratri.kegiatan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import solfa.ratri.kegiatan.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentDetail extends BaseFragment {

    public FragmentDetail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
}
