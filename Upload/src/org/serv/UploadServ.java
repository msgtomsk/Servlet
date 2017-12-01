package org.serv;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.service.Service;
import org.util.Servletutil;

/**
 * Servlet implementation class Uploadserv
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,maxFileSize = 1024 * 1024 * 10,maxRequestSize = 1024 * 1024 * 50)
public class UploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part = request.getPart("docs");
		String filename = Servletutil.extract(part);
		System.out.println(filename);
		String location = getServletConfig().getInitParameter("storage");
		System.out.println(location);
		part.write(location + File.separator + filename);
		//String mimetype = getServletConfig().getInitParameter("storage");
		String mimetype = part.getContentType();
		System.out.println(mimetype);
		Service.insert( filename,location, mimetype);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
