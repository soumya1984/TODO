package com.app.restapi.todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import com.app.restapi.todo.domain.Todo;
import com.app.restapi.todo.domain.TodoList;
import com.google.gson.Gson;

public class TODOResourceImpl_Test {
	@Test
	public void testJson() {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/TODO/rest/todoService");

			List<Todo> list = new ArrayList<Todo>();
			Todo todo = new Todo(123, "clean the room pls", "priyanka",
					new Date().toString(), "OPEN", 2, "");
			Todo todo1 = new Todo(123, "clean the room pls", "priyanka",
					new Date().toString(), "OPEN", 2, "");
			list.add(todo);
			list.add(todo1);
			TodoList todoList = new TodoList();
			todoList.setTodo(list);

			String input = new Gson().toJson(todoList);
			System.out.println(input);

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Test
	public void testSendGet() {
		URL url;
		try {
			url = new URL(
					"http://localhost:8080/TODO/rest/todoService");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// print result
		// System.out.println(response.toString());

	}

}
