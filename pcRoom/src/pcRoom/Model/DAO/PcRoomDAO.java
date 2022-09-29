package pcRoom.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PcRoomDAO {
	
	protected static Connection con;				// db 연동 인터페이스
	protected static PreparedStatement ps;		// db 조작 인터페이스
	protected static ResultSet rs;				// db 쿼리 조작 인터페이스
	
	//생성자
		
	protected PcRoomDAO() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pcroom",
					"root", 
					"1234");
		} catch (Exception e) {
			System.out.println("DB연동 실패"+e);
		}
	}
}
