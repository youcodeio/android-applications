package team.io.youcodeio.services;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import team.io.youcodeio.model.channel.Channel;
import team.io.youcodeio.model.search.Search;
import team.io.youcodeio.model.search.VideoFromSearch;

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

    @GET("/channels/{channel_id}/lastVideos")
    Observable<List<Search>> getChannelLatestVideos(@Path("channel_id") String channelId);

    @GET("/search")
    Observable<List<Search>> launchSearch(@Query("query") String query);
}
