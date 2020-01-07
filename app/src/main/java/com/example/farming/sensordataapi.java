package com.example.farming;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface sensordataapi {
    @GET
    Call<List<Sensordatum>> getsensordata(@Url String url);

}
