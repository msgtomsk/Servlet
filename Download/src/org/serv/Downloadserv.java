package org.serv;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Downloadserv
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,maxFileSize = 1024 * 1024 * 10,maxRequestSize = 1024 * 1024 * 50)
public class Downloadserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Downloadserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Part part = request.getPart("docs");
		String mimetype = part.getContentType();
		System.out.println(mimetype);
		String filenme = part.getSubmittedFileName();
		System.out.println(filenme);
		PrintWriter out = response.getWriter();		
		response.setContentType(mimetype);
		response.setHeader("content-disposition","attachment; filename = \"" + filenme + "\"");
		String filepath = getServletConfig().getInitParameter("storage");
		FileInputStream fileinput = new FileInputStream(filepath + filenme);
		int i;
		while((i = fileinput.read()) != -1){			
			out.write(i);
		}
		fileinput.close();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
