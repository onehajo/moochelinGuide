package edu.kh.moochelinGuide.comment.controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.comment.service.CommentService;

@WebServlet("/comment/list")
public class CommentListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
            // 쿼리스트링 영화번호
//            int movieNo = Integer.parseInt(req.getParameter("movieNo"));
            int movieNo = 12;
            
            
            int cp = 1;
            
            if(req.getParameter("cp") != null) {
                
                cp = Integer.parseInt(req.getParameter("cp"));
                
            }
            
            
            CommentService service = new CommentService();
            
            // 게시판 종류, 페이지네이션, 게시글 리스트
            // ** 게시글 리스트
            // 1페이지에 좋아요 top3 세개 출력
            // 2페이지부터 최신순인데...  다섯개? 여섯개?씩 출력할까? 세개 출력하면 뭔가 구려보임...
            
            Map<String, Object> map = service.selectComentList(movieNo,cp);
            
            //request 범위로 map을 세팅
            req.setAttribute("map", map);
            
            System.out.println(map);
            
            
            
            String path = "/WEB-INF/views/comment/comment_detail.jsp";
            
            RequestDispatcher dispatcher = req.getRequestDispatcher(path);
            
            dispatcher.forward(req, resp);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
