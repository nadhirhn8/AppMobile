package tn.isetmd.dsi.retrofit.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.SerializedIr;

public class UserList {
    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer perpage;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer totalpages;
    @SerializedName("data")
    public List<Datum> data = new ArrayList<>();

    public class Datum{
        @SerializedName("id")
        public Integer id;
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("avatar")
        public String avatar;
    }
}
