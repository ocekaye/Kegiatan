package solfa.ratri.kegiatan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import solfa.ratri.kegiatan.Adapter.KegiatanAdapter;
import solfa.ratri.kegiatan.Adapter.KegiatanModel;
import solfa.ratri.kegiatan.BaseActivity;
import solfa.ratri.kegiatan.DB.DBHelper;
import solfa.ratri.kegiatan.MainActivity;
import solfa.ratri.kegiatan.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {
    KegiatanAdapter mAdapter;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new KegiatanAdapter(getBaseActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rvContent);
        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter.refresh();
        getBaseActivity().setOnBackButtonDisble();

        FloatingActionButton fab = (FloatingActionButton)  v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getContext(), MainActivity.class);
//                i.putExtra(BaseActivity.EXTRA_FRAGMENT_TYPE, BaseActivity.FRAGMENT_ADD);
//                startActivity(i);
                FragmentAdd lokasi = new FragmentAdd();
                lokasi.setTargetFragment(MainActivityFragment.this, 0);
                getBaseActivity().startFragment(lokasi);
            }
        });

        return v;
    }

    public void addData(KegiatanModel model){
        mAdapter.add(model, 0);
    }

    @Override
    public String setTitle() {
        return "Daftar Kegiatan";
    }

    @Override
    public boolean enableSearch() {
        return false;
    }
}
