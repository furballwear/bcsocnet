package com.bcsocnet;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.servlet.http.*;

public class HomeServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		session.setAttribute("emailId", emailId);
		Key loginKey = KeyFactory.createKey("emailId", emailId);
		
		Entity login = new Entity("login",loginKey);
		login.setProperty("emailId", emailId);
		//login.setProperty("password", password);
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(login);
		
	}
	
}
