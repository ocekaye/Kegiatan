package solfa.ratri.kegiatan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import solfa.ratri.kegiatan.Adapter.KegiatanModel;
import solfa.ratri.kegiatan.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentDetail extends BaseFragment {
    KegiatanModel kegiatanModel;
    TextView txtTempat, txtTanggal, txtAlamat, txtLonglat;

    public FragmentDetail(KegiatanModel kegiatanModel) {
        this.kegiatanModel = kegiatanModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        txtTempat = (TextView) v.findViewById(R.id.txt_tempat);
        txtTanggal = (TextView) v.findViewById(R.id.txt_tanggal);
        txtAlamat = (TextView) v.findViewById(R.id.txt_alamat);
        txtLonglat = (TextView) v.findViewById(R.id.txt_longlat);
        getBaseActivity().setOnBackButtonEnable();
        txtTempat.setText(kegiatanModel.getNamaTempat());
        txtTanggal.setText(kegiatanModel.getTanggal());
        txtAlamat.setText(kegiatanModel.getAlamat());
        txtLonglat.setText(kegiatanModel.getLl());

        return v;
    }

    @Override
    public String setTitle() {
        return kegiatanModel.getNama();
    }

    @Override
    public boolean enableSearch() {
        return false;
    }
}
