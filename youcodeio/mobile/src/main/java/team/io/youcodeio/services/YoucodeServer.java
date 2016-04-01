package team.io.youcodeio.services;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stevenwatremez on 01/04/16.
 *
 */
public class YoucodeServer {

    /*****************************************************************
     * STATIC
     ****************************************************************/
    private static Retrofit sRetrofit;
    private static YoucodeAPI sYoucodeAPI;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    private YoucodeServer() {}

    /*****************************************************************
     * PUBLIC METHOD
     ****************************************************************/
    public static YoucodeAPI getService() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(YoucodeAPI.YOUCODE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            sYoucodeAPI = sRetrofit.create(YoucodeAPI.class);
        }
        return sYoucodeAPI;
    }
}
