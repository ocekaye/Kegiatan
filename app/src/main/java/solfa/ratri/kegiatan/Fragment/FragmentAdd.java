package solfa.ratri.kegiatan.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import solfa.ratri.kegiatan.BaseActivity;
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

    public FragmentAdd() {
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
}
