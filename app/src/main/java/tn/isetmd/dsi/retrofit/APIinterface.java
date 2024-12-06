package tn.isetmd.dsi.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tn.isetmd.dsi.retrofit.pojo.UserList;

public interface APIinterface {

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page")String page);

}
