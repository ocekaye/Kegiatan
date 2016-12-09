package solfa.ratri.kegiatan.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import solfa.ratri.kegiatan.R;

/**
 * Created by Hinata on 12/10/2016.
 */
public class AlamatHolder extends RecyclerView.ViewHolder {
    public TextView txtNama, txtAlamat;
    public View card;
    public AlamatHolder(View itemView) {
        super(itemView);
        txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
        txtAlamat = (TextView) itemView.findViewById(R.id.txt_alamat);
        card = (View) itemView.findViewById(R.id.card);
    }
    public AlamatHolder(ViewGroup parent){
        this(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_lokasi, parent, false));
    }
}
