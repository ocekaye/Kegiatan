package solfa.ratri.kegiatan.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import solfa.ratri.kegiatan.Adapter.KegiatanModel;
import solfa.ratri.kegiatan.BaseActivity;
import solfa.ratri.kegiatan.DB.DBHelper;
import solfa.ratri.kegiatan.FourSquare.ModelApi;
import solfa.ratri.kegiatan.MainActivity;
import solfa.ratri.kegiatan.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentAdd extends BaseFragment implements DatePickerDialog.OnDateSetListener {
    TextView txtAlamat;
    EditText editNama, editTime;
    Button btnAlamat, btnSave;
    ModelApi.Venues lokasi;

    DBHelper mDbHelper;

    public FragmentAdd() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDbHelper = new DBHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        txtAlamat = (TextView) v.findViewById(R.id.txt_lokasi);
        editNama = (EditText) v.findViewById(R.id.edit_name);
        editTime = (EditText) v.findViewById(R.id.date);
        btnAlamat = (Button) v.findViewById(R.id.btn_lokasi);
        btnSave = (Button) v.findViewById(R.id.btn_save);

        getBaseActivity().setOnBackButtonEnable();

        if (lokasi != null){
            txtAlamat.setText(lokasi.getName()+"\n"+lokasi.getLocation().getFullAdress());
        }
        editTime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    showDatePicker();
                }
            }
        });
        editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

        btnAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent(getContext(), MainActivity.class);
                i.putExtra(BaseActivity.EXTRA_FRAGMENT_TYPE, BaseActivity.FRAGMENT_LOKASI);
                getBaseActivity().startActivity(i);*/
                FragmentLokasi lokasi = new FragmentLokasi();
                lokasi.setTargetFragment(FragmentAdd.this, 0);
                getBaseActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, lokasi).addToBackStack(null).commit();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ll = "";
                if(lokasi != null){
                    ll = lokasi.getLocation().getLng()+","+lokasi.getLocation().getLat();
                }
                mDbHelper.inputKegiatan(editNama.getText().toString(), lokasi.getName(), editTime.getText().toString(), txtAlamat.getText().toString(), ll);
                KegiatanModel model = new KegiatanModel();
                model.setNama(editNama.getText().toString());
                model.setNamaTempat(lokasi.getName());
                model.setTanggal(editTime.getText().toString());
                model.setAlamat(txtAlamat.getText().toString());
                model.setLl(ll);
                ((MainActivityFragment) getTargetFragment()).addData(model);
                getBaseActivity().onBackPressed();
            }
        });

        return v;
    }

    private void showDatePicker(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                FragmentAdd.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getBaseActivity().getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        editTime.setText(dayOfMonth+"-"+monthOfYear+"-"+year);
    }

    public void setLokasi(ModelApi.Venues l){
        lokasi = l;
    }

    @Override
    public String setTitle() {
        return "Tambah Kegiatan";
    }
}
