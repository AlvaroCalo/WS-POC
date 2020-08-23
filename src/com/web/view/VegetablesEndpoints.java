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
import com.web.models.Vegetables;
import com.web.DAOs.VegetablesDAO;

@Path("/")
public class VegetablesEndpoints {

	// With GET give all the items of vegetables to the client
	@GET
	@Path("list/vegetables")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listMeats() {
		String resultJSON = "";
		Gson gson = new Gson();
		ArrayList<Vegetables> list = new ArrayList<Vegetables>();
		list = new VegetablesDAO().listVegetablesDAO();
		resultJSON = gson.toJson(list);
		return Response.status(200).entity(resultJSON).build();
	}

	// With GET give the given item of meats to the client
	@GET
	@Path("vegetable/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response giveFruit(@PathParam("id") int id) {
		String resultJSON = "";
		Gson gson = new Gson();
		Vegetables v = new Vegetables();
		v = new VegetablesDAO().findVegetableDAO(id);
		resultJSON = gson.toJson(v);
		return Response.status(200).entity(resultJSON).build();
	}

	// With POST insert an item to the database
	@POST
	@Path("add/vegetable")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMeat(final String into) {
		boolean success = false;
		String resultJSON = "";
		Gson gson = new Gson();
		Vegetables v = gson.fromJson(into, Vegetables.class);
		resultJSON = gson.toJson(v);
		success = new VegetablesDAO().insertVegetableDAO(v);
		if (success) {
			return Response.status(200).entity(resultJSON).build();
		} else {
			return Response.status(400).build();
		}
	}

	// With DELETE remove a given fruit by Id
	@DELETE
	@Path("delete/vegetable/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMeat(@PathParam("id") int id) {
		Vegetables vegetableToDelete = new Vegetables();
		vegetableToDelete = new VegetablesDAO().findVegetableDAO(id);
		Vegetables v = new Vegetables();
		v = new VegetablesDAO().deleteVegetableDAO(id);
		System.out.println("Vegetable deleted" + v);
		if (vegetableToDelete.getId() != 0) {
			return Response.status(200).build();
		} else {
			return Response.status(400).build();
		}

	}

	// With PUT modify the name of a given meat by Id
	@PUT
	@Path("update/name/vegetable/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMeattName(@PathParam("id") int id, final String into) {
		boolean success = false;
		// Update the item
		Gson gson = new Gson();
		Vegetables v = gson.fromJson(into, Vegetables.class);
		success = new VegetablesDAO().updateVegetableNameDAO(id, v.getName());
		// Get the updated item
		String updatedJSON = "";
		Gson gson2 = new Gson();
		Vegetables v1 = new Vegetables();
		v1 = new VegetablesDAO().findVegetableDAO(id);
		updatedJSON = gson2.toJson(v1);
		if (success) {
			return Response.status(200).entity(updatedJSON).build();
		} else {
			return Response.status(400).build();
		}
	}

	// With PUT modify the description of a given meat by Id
	@PUT
	@Path("update/description/vegetable/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMeatDescription(@PathParam("id") int id, final String into) {
		boolean success = false;
		// Update the item
		Gson gson = new Gson();
		Vegetables v = gson.fromJson(into, Vegetables.class);
		success = new VegetablesDAO().updateVegetableDescriptionDAO(id, v.getDescription());
		// Get the updated item
		String updatedJSON = "";
		Gson gson2 = new Gson();
		Vegetables v1 = new Vegetables();
		v1 = new VegetablesDAO().findVegetableDAO(id);
		updatedJSON = gson2.toJson(v1);
		if (success) {
			return Response.status(200).entity(updatedJSON).build();
		} else {
			return Response.status(400).build();
		}
	}

}
