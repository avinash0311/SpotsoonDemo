package application.android.spotsoondemo;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by boobeshb on 7/20/2017.
 */

public interface ApiService {

    @GET("get/bOqqGwivkO?indent=2")
    public Call<ArrayList<CountryListArray>> getResults();
}
