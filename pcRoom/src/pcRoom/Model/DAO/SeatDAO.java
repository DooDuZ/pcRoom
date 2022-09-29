package pcRoom.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pcRoom.Model.DTO.membersDTO;

public class SeatDAO {
	private Connection con;				// db 연동 인터페이스
	private PreparedStatement ps;		// db 조작 인터페이스
	private ResultSet rs;				// db 쿼리 조작 인터페이스
	
	
	//생성자
	
	private SeatDAO() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pcroom",
					"root", 
					"1234");
		} catch (Exception e) {
			System.out.println("DB연동 실패"+e);
		}
	}
	
	
	static SeatDAO sDAO = new SeatDAO();
	
	public static SeatDAO getInstance() {
		return sDAO;
	}
	
	public boolean login(membersDTO dto) {
		String sql = "select * from members where (memID, memPW) =  (? , ?) ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMemID());
			ps.setString(2, dto.getMemPW());
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}			
		} catch (Exception e) {
			System.out.println("login DB연동 오류" + e);
		}
		return false;
	}	
}
