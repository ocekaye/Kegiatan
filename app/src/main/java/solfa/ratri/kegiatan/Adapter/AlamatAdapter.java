package solfa.ratri.kegiatan.Adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import solfa.ratri.kegiatan.BaseActivity;
import solfa.ratri.kegiatan.FourSquare.APIService;
import solfa.ratri.kegiatan.FourSquare.ModelApi;
import solfa.ratri.kegiatan.FourSquare.ServiceGenerator;
import solfa.ratri.kegiatan.Fragment.FragmentAdd;
import solfa.ratri.kegiatan.Holder.AlamatHolder;

/**
 * Created by Ratri on 12/10/2016.
 */
public class AlamatAdapter extends ListAdapter<ModelApi.Venues, AlamatHolder> {
    BaseActivity activity;
    String mId, mSecret, mV, mRadiu, mLl;
    APIService service;
    FragmentAdd fragmentAdd;

    public AlamatAdapter(BaseActivity activity,  FragmentAdd fragmentAdd, String id, String secret, String radius, String v, String ll){
        this.activity = activity;
        mId = id;
        mSecret = secret;
        mV = v;
        mRadiu = radius;
        mLl = ll;
        this.fragmentAdd = fragmentAdd;
        service = ServiceGenerator.createService(APIService.class);
    }

    @Override
    public AlamatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AlamatHolder(parent);
    }

    @Override
    public void onBindViewHolder(AlamatHolder holder, final int position) {
        ModelApi.Location location = get(position).getLocation();
        holder.txtNama.setText(get(position).getName());
        holder.txtAlamat.setText(location.getFullAdress());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentAdd.setLokasi(get(position));
                activity.onBackPressed();
            }
        });
    }

    public void init(){
        Call<ModelApi> call = service.getLocation(mId, mSecret, mV, mRadiu, mLl);
        call.enqueue(new Callback<ModelApi>() {
            @Override
            public void onResponse(Call<ModelApi> call, Response<ModelApi> response) {
                if (response.isSuccessful()){
                    add(response.body().getResponse().getVenues());
                } else Log.e("ERROR", "not success : "+response.raw());
            }

            @Override
            public void onFailure(Call<ModelApi> call, Throwable t) {
                Log.e("ERROR", ""+t);
            }
        });
    }

    public void search(String query){
        Call<ModelApi> call = service.searchLocation(mId, mSecret, mV, mLl, query);
        call.enqueue(new Callback<ModelApi>() {
            @Override
            public void onResponse(Call<ModelApi> call, Response<ModelApi> response) {
                if (response.isSuccessful()){
                    clearAll();
                    add(response.body().getResponse().getVenues());
                } else Log.e("ERROR", "not success : "+response.raw());
            }

            @Override
            public void onFailure(Call<ModelApi> call, Throwable t) {
                Log.e("ERROR", ""+t);
            }
        });
    }
}
