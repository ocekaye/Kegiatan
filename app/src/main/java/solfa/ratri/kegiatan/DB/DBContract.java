package solfa.ratri.kegiatan.DB;

import android.provider.BaseColumns;

/**
 * Created by Ratri on 12/10/2016.
 */
public class DBContract {

    public static class Kegiatan implements BaseColumns {
        public static final String TABLE_NAME = "kegiatan";
        public static final String COLUMN_NAME_NAMA = "nama";
        public static final String COLUMN_NAME_NAMA_TEMPAT = "nama_tempat";
        public static final String COLUMN_NAME_TANGGAL = "tanggal";
        public static final String COLUMN_NAME_TEMPAT = "tempat";
        public static final String COLUMN_NAME_LL = "ll";
    }
}
