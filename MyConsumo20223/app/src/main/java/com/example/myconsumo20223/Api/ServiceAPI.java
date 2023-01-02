package com.example.myconsumo20223.Api;
import com.example.myconsumo20223.Model.Producto;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface ServiceAPI {
    @GET("producto")
    public abstract Call<List<Producto>> listProduct();
    @POST("producto/agregar")
    public abstract Call<Producto> addProducto(@Body Producto obj);
    @PUT("producto/modificar")
    public abstract Call<Producto> modifyProducto(@Body Producto obj);
    @DELETE("producto/eliminar/{id}")
    public abstract Call<Producto> removeProducto(@Path("id") int id);
}