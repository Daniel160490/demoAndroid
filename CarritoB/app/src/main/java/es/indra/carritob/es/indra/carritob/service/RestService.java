package es.indra.carritob.es.indra.carritob.service;

import android.telecom.Call;

import java.util.List;

import es.indra.carritob.es.indra.carritob.beans.Categoria;

public interface RestService {

    String API_ROUTE = "/categoria";
    @GET(API_ROUTE)
    Call<List<Categoria>> getAllCategories();
}
}
