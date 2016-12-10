package solfa.ratri.kegiatan.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import solfa.ratri.kegiatan.Adapter.AlamatAdapter;
import solfa.ratri.kegiatan.FourSquare.ModelApi;
import solfa.ratri.kegiatan.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentLokasi extends BaseFragment {
    RecyclerView recyclerView;
    AlamatAdapter adapter;
    LinearLayoutManager layoutManager;

    public FragmentLokasi() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new AlamatAdapter(getBaseActivity(), (FragmentAdd)getTargetFragment(), "VOWLDU5UW1MU4TK50V4GKK1315AQL5TO3LUKE2NS1ZI1HOGG", "Z0ONVIMP2TL5U2AA3O1RAFKCK2C5VYNYLMWW45R5UGLTIP2N", "400", "20130815", "-6.9213855,107.6216999");
        adapter.init();
        layoutManager = new LinearLayoutManager(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lokasi, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rvContent);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public String setTitle() {
        return "Pilih Lokasi";
    }
}
