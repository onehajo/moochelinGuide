package edu.kh.moochelinGuide.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/comment/*")
public class AdminCommentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
	    String contextPath = req.getContextPath();
	    String command = uri.substring(  (contextPath + "/admin/comment/").length()  );
	    
	    System.out.println("command = "+command);
	    
	    String path = "/WEB-INF/views/comment/admin-comment.jsp";
	    req.getRequestDispatcher(path).forward(req, resp);
	    
	}
	
	

}
