package com.web.view;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import com.web.models.Meats;
import com.web.DAOs.MeatsDAO;

@Path("/")
public class MeatsEndpoints {

	// With GET give all the items of meats to the client
	@GET
	@Path("list/meats")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listMeats() {
		String resultJSON = "";
		Gson gson = new Gson();
		ArrayList<Meats> list = new ArrayList<Meats>();
		list = new MeatsDAO().listMeatsDAO();
		resultJSON = gson.toJson(list);
		return Response.status(200).entity(resultJSON).build();
	}

	// With GET give the given item of meats to the client
	@GET
	@Path("meat/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response giveFruit(@PathParam("id") int id) {
		String resultJSON = "";
		Gson gson = new Gson();
		Meats m = new Meats();
		m = new MeatsDAO().findMeatDAO(id);
		resultJSON = gson.toJson(m);
		return Response.status(200).entity(resultJSON).build();
	}

	// With POST insert an item to the database
	@POST
	@Path("add/meat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMeat(final String into) {
		boolean success = false;
		String resultJSON = "";
		Gson gson = new Gson();
		Meats f = gson.fromJson(into, Meats.class);
		resultJSON = gson.toJson(f);
		success = new MeatsDAO().insertMeatDAO(f);
		if (success) {
			return Response.status(200).entity(resultJSON).build();
		} else {
			return Response.status(400).build();
		}
	}

	// With DELETE remove a given fruit by Id
	@DELETE
	@Path("delete/meat/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMeat(@PathParam("id") int id) {
		Meats meatToDelete = new Meats();
		meatToDelete = new MeatsDAO().findMeatDAO(id);
		Meats m = new Meats();
		m = new MeatsDAO().deleteMeatDAO(id);
		System.out.println("Meat deleted" + m);
		if (meatToDelete.getId() != 0) {
			return Response.status(200).build();
		} else {
			return Response.status(400).build();
		}

	}

	// With PUT modify the name of a given meat by Id
	@PUT
	@Path("update/name/meat/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMeattName(@PathParam("id") int id, final String into) {
		boolean success = false;
		// Update the item
		Gson gson = new Gson();
		Meats m = gson.fromJson(into, Meats.class);
		success = new MeatsDAO().updateMeatNameDAO(id, m.getName());
		// Get the updated item
		String updatedJSON = "";
		Gson gson2 = new Gson();
		Meats m1 = new Meats();
		m1 = new MeatsDAO().findMeatDAO(id);
		updatedJSON = gson2.toJson(m1);
		if (success) {
			return Response.status(200).entity(updatedJSON).build();
		} else {
			return Response.status(400).build();
		}
	}

	// With PUT modify the description of a given meat by Id
	@PUT
	@Path("update/description/meat/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMeatDescription(@PathParam("id") int id, final String into) {
		boolean success = false;
		// Update the item
		Gson gson = new Gson();
		Meats m = gson.fromJson(into, Meats.class);
		success = new MeatsDAO().updateMeatDescriptionDAO(id, m.getDescription());
		// Get the updated item
		String updatedJSON = "";
		Gson gson2 = new Gson();
		Meats m1 = new Meats();
		m1 = new MeatsDAO().findMeatDAO(id);
		updatedJSON = gson2.toJson(m1);
		if (success) {
			return Response.status(200).entity(updatedJSON).build();
		} else {
			return Response.status(400).build();
		}
	} 
}
