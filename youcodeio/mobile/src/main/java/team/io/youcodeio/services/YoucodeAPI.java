package team.io.youcodeio.services;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import team.io.youcodeio.model.channel.Channel;
import team.io.youcodeio.model.search.Search;

/**
 * Created by stevenwatremez on 01/04/16.
 *
 */
public interface YoucodeAPI {

    /*****************************************************************
     * STATIC
     ****************************************************************/
    String YOUCODE_BASE_URL = "https://youcode-backend.cleverapps.io/";

    /*****************************************************************
     * API
     ****************************************************************/
    @GET("/channels")
    Observable<List<Channel>> getChannels();

    @GET("/search")
    Observable<List<Search>> launchSearch(@Query("query") String query);
}
