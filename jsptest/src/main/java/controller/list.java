package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Dao.BoardDao;
import model.Dto.BoardDto;

/**
 * Servlet implementation class list
 */
@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public list() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.getlsit();
		System.out.println("list"+list);
		JSONArray array = new JSONArray();
		for(int i=0 ; i<list.size() ;i++) {
			JSONObject object = new JSONObject();
			object.put("bno", list.get(i).getBno());
			object.put("btitle", list.get(i).getBtitle());
			object.put("bcontent", list.get(i).getBcontent());
			object.put("bpassword", list.get(i).getBpassword());
			object.put("bwriter", list.get(i).getBwriter());
			object.put("bdate", list.get(i).getBdate());
			object.put("bview", list.get(i).getBview());
			array.add(object);
		
		}
		System.out.println("서블릿"+array);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
