package solfa.ratri.kegiatan;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import solfa.ratri.kegiatan.Fragment.BaseFragment;
import solfa.ratri.kegiatan.Fragment.MainActivityFragment;

/**
 * Created by Ratri on 12/9/2016.
 */
public abstract class BaseActivity extends AppCompatActivity{
    public static final int FRAGMENT_HOME = 0;
    public static final int FRAGMENT_ADD = 1;
    public static final int FRAGMENT_LOKASI = 2;
    public static final int FRAGMENT_DETAIL = 3;

    public static final String EXTRA_FRAGMENT_TYPE = "fragmentType";
    private SearchView mSearchView;
    private MenuItem mSearchMenuItem;
    protected BaseFragment fragment;

    protected abstract boolean showBackButton();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().addOnBackStackChangedListener(backStackChangedListener);
    }

    private FragmentManager.OnBackStackChangedListener backStackChangedListener = new FragmentManager.OnBackStackChangedListener() {
        @Override
        public void onBackStackChanged() {
            if (getSupportFragmentManager().getBackStackEntryCount()>1){
                fragment = (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.container);
                fragment.setTitle();
                fragment.setHasSearchView();
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mSearchMenuItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(mSearchMenuItem);
        mSearchView.setSubmitButtonEnabled(true);
        if (fragment != null) fragment.setHasSearchView();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
         if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setOnBackButtonEnable() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void setOnBackButtonDisble() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case LocationHelper.LOCATION_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    LocationHelper.getLocation(this);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (mSearchView!=null && !mSearchView.isIconified() && mSearchMenuItem!=null){
            mSearchMenuItem.collapseActionView();
        }
        super.onBackPressed();
    }

    public void hasSearchView(boolean visible){
        if (mSearchMenuItem != null) mSearchMenuItem.setVisible(visible);
    }

    public void setSeacrhListener(SearchView.OnQueryTextListener searchListenet){
        mSearchView.setOnQueryTextListener(searchListenet);
    }

    public void startFragment(BaseFragment fragment){
        if (fragment instanceof MainActivityFragment)
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        else getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }
}
