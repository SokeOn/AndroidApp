/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PeliculaDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Pelicula;
import model.cPeli;

/**
 * REST Web Service
 *
 * @author S1-PC53
 */

//http://localhost:8080/AndroidPeliculas/webresources/api/peliculas
@Path("api")
public class API {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of API
     */
    public API() {
    }

    /**
     * Retrieves representation of an instance of controller.API
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/peliculas")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "patata";
    }
    
    @GET
    @Path("/tematicas")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String tematicas () {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<String> tematicas = peliculaDAO.tematicas();
        return toArrayJSon(tematicas);
    }
    
    @GET
    @Path("/findAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll () {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        Pelicula pelicula = new Pelicula();
        ArrayList<Pelicula> peliculas = peliculaDAO.findAll(pelicula);
        return Pelicula.toArrayJSon(peliculas);
    }
    
    @GET
    @Path("/findOne/{idPelicula}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String findOne (@PathParam("idPelicula") int idPelicula) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDAO.findOne(idPelicula);
        return Pelicula.toArrayJSon(peliculas);
    }
    
    @GET
    @Path("/top10")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String top10 () {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDAO.top10();
        return Pelicula.toArrayJSon(peliculas);
    }
    
    @GET
    @Path("/filtrarTitulo/{titulo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String filtradoTitulo (@PathParam("titulo") String titulo) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDAO.filtradoTitulo(titulo);
        return Pelicula.toArrayJSon(peliculas);
    }
    
    @GET
    @Path("/filtrarTematica/{tematica}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String filtradoTematica (@PathParam("tematica") String tematica) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDAO.filtradoTematica(tematica);
        return Pelicula.toArrayJSon(peliculas);
    }
    
    @GET
    @Path("/filtrarAmbas/{titulo}/{tematica}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String filtradoTitulo (@PathParam("titulo") String titulo, @PathParam("tematica") String tematica) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDAO.filtradoAmbas(titulo, tematica);
        return Pelicula.toArrayJSon(peliculas);
    }
    
    @GET
    @Path("/puntuar/{idPelicula}/{puntuacion}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String puntuar (@PathParam("idPelicula") int idPelicula, @PathParam("puntuacion") int puntuacion) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDAO.puntuar(idPelicula, puntuacion);
        return Pelicula.toArrayJSon(peliculas);
    }
    
    
    @GET
    @Path("/historico")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String historico (String titulo) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDAO.historico();
        return Pelicula.toArrayJSon(peliculas);
    }
    
    @GET
    @Path("/peliculasCine/{idPelicula}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String peliculasCine (@PathParam("idPelicula") int idPelicula) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        ArrayList<cPeli> cPeliculas = peliculaDAO.peliculasCine(idPelicula);
        return cPeli.toArrayJSon(cPeliculas);
    }
    
    

    
    /**
     * PUT method for updating or creating an instance of API
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    public static String toArrayJSon(ArrayList<String> tematicas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(tematicas);
        //resp = "{\"data\":" + resp + "}";
        return resp;
    }
}
