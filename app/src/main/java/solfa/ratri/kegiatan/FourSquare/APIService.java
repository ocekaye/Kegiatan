package solfa.ratri.kegiatan.FourSquare;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hinata on 12/9/2016.
 */
public interface APIService {
    @GET("search")
    Call<ModelApi> getLocation(@Query("client_id") String client_id, @Query("client_secret") String client_secret,
                               @Query("v") String v, @Query("radius") String radius,
                               @Query("ll") String ll);
}
