package solfa.ratri.kegiatan.Adapter;

import android.view.View;
import android.view.ViewGroup;

import solfa.ratri.kegiatan.BaseActivity;
import solfa.ratri.kegiatan.DB.DBHelper;
import solfa.ratri.kegiatan.Fragment.FragmentDetail;
import solfa.ratri.kegiatan.Holder.AlamatHolder;
import solfa.ratri.kegiatan.R;

/**
 * Created by Hinata on 12/10/2016.
 */
public class KegiatanAdapter extends ListAdapter<KegiatanModel, AlamatHolder> {
    BaseActivity activity;
    DBHelper helper;

    public KegiatanAdapter(BaseActivity activity){
        this.activity = activity;
        helper = new DBHelper(activity);
    }

    @Override
    public AlamatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AlamatHolder(parent);
    }

    @Override
    public void onBindViewHolder(AlamatHolder holder, int position) {
        final KegiatanModel model = get(position);
        holder.txtNama.setText(model.getNama());
        holder.txtAlamat.setText(model.getNamaTempat());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragmentDetail(model)).addToBackStack(null).commit();
            }
        });
    }

    public void refresh(){
        clearAll();
        init();
    }

    public void init(){
        add(helper.getAllKediatan());
    }
}
