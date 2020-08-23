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

import com.web.DAOs.FruitsDAO;
import com.web.models.Fruits;

@Path("/")
public class FruitsEndpoints {

	// With GET give all the items of fruits to the client
	@GET
	@Path("list/fruits")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listFruits() {
		String resultJSON = "";
		Gson gson = new Gson();
		ArrayList<Fruits> list = new ArrayList<Fruits>();
		list = new FruitsDAO().listFruitsDAO();
		resultJSON = gson.toJson(list);
		return Response.status(200).entity(resultJSON).build();
	}

	// With GET give the given item of fruits to the client
	@GET
	@Path("fruit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response giveFruit(@PathParam("id") int id) {
		String resultJSON = "";
		Gson gson = new Gson();
		Fruits f = new Fruits();
		f = new FruitsDAO().findFruitDAO(id);
		resultJSON = gson.toJson(f);
		return Response.status(200).entity(resultJSON).build();
	}

	// With POST insert an item to the database
	@POST
	@Path("add/fruit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertFruit(final String into) {
		boolean success = false;
		String resultJSON = "";
		Gson gson = new Gson();
		Fruits f = gson.fromJson(into, Fruits.class);
		resultJSON = gson.toJson(f);
		success = new FruitsDAO().insertFruitDAO(f);
		if (success) {
			return Response.status(200).entity(resultJSON).build();
		} else {
			return Response.status(400).build();
		}
	}

	// With DELETE remove a given fruit by Id
	@DELETE
	@Path("delete/fruit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFruit(@PathParam("id") int id) {
		Fruits fruitToDelete = new Fruits();
		fruitToDelete = new FruitsDAO().findFruitDAO(id);
		Fruits f = new Fruits();
		f = new FruitsDAO().deleteFruitDAO(id);
		System.out.println("Fruit deleted" + f);
		if (fruitToDelete.getId() != 0) {
			return Response.status(200).build();
		} else {
			return Response.status(400).build();
		}

	}

	// With PUT modify the name of a given fruit by Id
	@PUT
	@Path("update/name/fruit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFruitName(@PathParam("id") int id, final String into) {
		boolean success = false;
		// Update the item
		Gson gson = new Gson();
		Fruits f = gson.fromJson(into, Fruits.class);
		success = new FruitsDAO().updateFruitNameDAO(id, f.getName());
		// Get the updated item
		String updatedJSON = "";
		Gson gson2 = new Gson();
		Fruits f1 = new Fruits();
		f1 = new FruitsDAO().findFruitDAO(id);
		updatedJSON = gson2.toJson(f1);
		if (success) {
			return Response.status(200).entity(updatedJSON).build();
		} else {
			return Response.status(400).build();
		}
	}

	// With PUT modify the description of a given fruit by Id
	@PUT
	@Path("update/description/fruit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFruitDescription(@PathParam("id") int id, final String into) {
		boolean success = false;
		// Update the item
		Gson gson = new Gson();
		Fruits f = gson.fromJson(into, Fruits.class);
		success = new FruitsDAO().updateFruitDescriptionDAO(id, f.getDescription());
		// Get the updated item
		String updatedJSON = "";
		Gson gson2 = new Gson();
		Fruits f1 = new Fruits();
		f1 = new FruitsDAO().findFruitDAO(id);
		updatedJSON = gson2.toJson(f1);
		if (success) {
			return Response.status(200).entity(updatedJSON).build();
		} else {
			return Response.status(400).build();
		}
	}
}
