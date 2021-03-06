package com.nevdia.atta.atta_app.Api;

import com.nevdia.atta.atta_app.Classes.Brands;
import com.nevdia.atta.atta_app.Classes.MainPartItem;
import com.nevdia.atta.atta_app.Classes.MainPartsClass;
import com.nevdia.atta.atta_app.Classes.Service;
import com.nevdia.atta.atta_app.Classes.SparePartsClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Eng.Mazen on 3/22/2018.
 */

public interface Apis {
    @POST("webApis.php")
    Call<ArrayList<Brands>> getMyBrand(@Query("retriveAllBrands") int retriveAllBrands);//this param to call funcation retriveAllBrands from webservice //
    @POST("webApis.php")
    Call<ArrayList<MainPartsClass>> getMyCats(@Query("retriveAllMainEquipmentCats") int retriveAllMainEquipmentCats);
    @POST("webApis.php")
    Call<ArrayList<SparePartsClass>> getMySpare(@Query("retriveAllSparePartsCats") int retriveAllSparePartsCats);
    @POST("webApis.php")
    Call<ArrayList<MainPartItem>> getAllMainItems(@Query("retriveAllItemsById") int retriveAllSparePartsCats, @Query("id") String id);
    @POST("webApis.php")
    Call<ArrayList<Service>> getAllServices(@Query("retriveAllMaintenanceService") int retriveAllMaintenanceService);


}
