package solfa.ratri.kegiatan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import solfa.ratri.kegiatan.BaseActivity;
import solfa.ratri.kegiatan.MainActivity;
import solfa.ratri.kegiatan.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        FloatingActionButton fab = (FloatingActionButton)  v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), MainActivity.class);
                i.putExtra(BaseActivity.EXTRA_FRAGMENT_TYPE, BaseActivity.FRAGMENT_ADD);
                startActivity(i);
            }
        });
        return v;
    }
}
