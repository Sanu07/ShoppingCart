package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.test.dao.CountryDao;



/**
 * Servlet implementation class PopulateDropdownSevlet
 */
@WebServlet("/PopulateDropdownSevlet")
public class PopulateDropdownSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateDropdownSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String getItem=request.getParameter("item");
		String getItemType=request.getParameter("itemType");
		
List<String> list=new ArrayList<String>();
		CountryDao poputeDropdown=new CountryDao();
//PopulateDropdownDao poputeDropdown=new PopulateDropdownDao();

		if(getItemType.equalsIgnoreCase("country")){
			list=poputeDropdown.getStates(getItem);
		}
		if(getItemType.equalsIgnoreCase("state")){
			list=poputeDropdown.getCity(getItem);
		}
		if(getItemType.equalsIgnoreCase("city")){
			list=poputeDropdown.getZip(getItem);
		}
		PrintWriter out=response.getWriter();
		String json=new Gson().toJson(list);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
