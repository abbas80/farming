package com.example.farming;
 import java.util.List;

 import retrofit2.Call;
 import retrofit2.http.GET;
 import retrofit2.http.Query;
 import retrofit2.http.Url;

public interface wholesensordataapi {
    @GET
    Call<List<Wholesensordatum>> getWholesensordata(@Url String url);

}
