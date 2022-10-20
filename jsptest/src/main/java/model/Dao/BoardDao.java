package model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Dto.BoardDto;

public class BoardDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest", "root", "1234");
			System.out.println("DB 연동 성공");
		} catch (Exception e) {
		}

	}
	
	public boolean write(String btitle ,String bwrite,String bcontent,String bpassword) {
		String sql = "insert into board values(null,?,?,?,?,null,null);";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bwrite);
			ps.setString(3, bcontent);
			ps.setString(4, bpassword);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("게시판오류"+e);}return false;
	}
	
	
	public ArrayList<BoardDto> getlsit(){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql ="select * from board";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6),
						rs.getInt(7));
				list.add(dto);
				System.out.println("다오"+list);
			}
			return list;
		} catch (Exception e) {System.out.println("리스트"+e);}
			return null;
	}
	
	public BoardDto getboard(int bno){
		String sql ="select * from board where bno="+bno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6),
						rs.getInt(7));
				return dto;          
			}
		} catch (Exception e) {System.out.println("리스트"+e);}
			return null;
	}
	
	
	
}