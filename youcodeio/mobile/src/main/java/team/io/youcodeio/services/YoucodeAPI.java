package team.io.youcodeio.services;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;
import team.io.youcodeio.model.channel.Channel;

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
}
