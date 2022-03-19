package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashboardCookieServlet
 */
@WebServlet("/dashboardCookie")
public class DashboardCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		// STEP 1: Gets cookies from request
		Cookie[] coockies = request.getCookies();
		boolean isCoockieFound = false;
		
		
		// STEP 2: Iterate coockies ,and see if found cockiew with name UserId
		if(coockies!=null && coockies.length>0) {
			
			for(Cookie ck: coockies) {
				
				if(ck.getName().equals("userId")) {
					isCoockieFound = true;
					out.println("Hello "+ ck.getValue());
				}
			}
			
		}
		
		if(!isCoockieFound) {
			out.println("No UserId was found in cookie, please login and then continue");
		}
		
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
