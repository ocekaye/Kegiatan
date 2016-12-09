package solfa.ratri.kegiatan;

import android.content.Intent;
import android.os.Bundle;

import solfa.ratri.kegiatan.Fragment.BaseFragment;
import solfa.ratri.kegiatan.Fragment.FragmentAdd;
import solfa.ratri.kegiatan.Fragment.FragmentDetail;
import solfa.ratri.kegiatan.Fragment.FragmentLokasi;
import solfa.ratri.kegiatan.Fragment.MainActivityFragment;

public class MainActivity extends BaseActivity {
    private boolean isEnableBackButton = false;

    @Override
    protected boolean showBackButton() {
        return isEnableBackButton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        if (i != null && i.getExtras() != null)
            getSupportFragmentManager().beginTransaction().replace(R.id.container, getFragment(i)).commit();
        else getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainActivityFragment()).commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(showBackButton());
        getSupportActionBar().setDisplayShowHomeEnabled(showBackButton());
    }

    private BaseFragment getFragment(Intent i){
        int fragmentType = i.getExtras().getInt(EXTRA_FRAGMENT_TYPE, FRAGMENT_HOME);
        switch (fragmentType){
            case FRAGMENT_HOME:
                isEnableBackButton = false;
                return new MainActivityFragment();
            case FRAGMENT_ADD:
                isEnableBackButton = true;
                return new FragmentAdd();
            case FRAGMENT_LOKASI:
                isEnableBackButton = true;
                return new FragmentLokasi();
            case FRAGMENT_DETAIL:
                isEnableBackButton = true;
                return new FragmentDetail();
            default:
                isEnableBackButton = false;
                return new MainActivityFragment();
        }
    }
}
