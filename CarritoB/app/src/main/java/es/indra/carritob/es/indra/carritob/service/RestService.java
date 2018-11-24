package es.indra.carritob.es.indra.carritob.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import es.indra.carritob.es.indra.carritob.beans.Categoria;

public interface RestService {

    String API_ROUTE = "/categoria";
    @GET(API_ROUTE)
    Call<List<Categoria>> getAllCategories();
}
