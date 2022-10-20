package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.BoardDao;
import model.Dto.BoardDto;

/**
 * Servlet implementation class board
 */
@WebServlet("/board")
public class board extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	BoardDao dao = new  BoardDao();   
	String btitle = request.getParameter("btitle");String bcontent = request.getParameter("bcontent");
	String bwrite = request.getParameter("bwrite");String bpassword = request.getParameter("bpassword");
   
	BoardDto dto = new BoardDto(0, btitle, bcontent, bwrite, bpassword, bpassword, 0);
	
	boolean result = dao.write(btitle,bwrite,bcontent,bpassword);
	System.out.println(result);
	
	response.getWriter().print(result);
   
   }
   
   
    public board() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
