package com.itso.example.osgi.wab;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.itso.example.osgi.api.HelloAPI;

/**
 * Servlet implementation class HelloWABServlet
 */
@WebServlet("/hello")
public class HelloWABServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HelloAPI helloService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWABServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		helloService.sayHello();
		response.getWriter().append("Hello Nagesh in Liberty profile-Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		ServletContext context=config.getServletContext();
		BundleContext ctx=(BundleContext) context.getAttribute("osgi-bundlecontext");
		ServiceReference ref=ctx.getServiceReference(HelloAPI.class.getName());
		helloService =(HelloAPI) ctx.getService(ref);
	}

}
