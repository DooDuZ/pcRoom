package pcRoom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class pcroomDAO {
	private Connection con;				// db 연동 인터페이스
	private PreparedStatement ps;		// db 조작 인터페이스
	private ResultSet rs;				// db 쿼리 조작 인터페이스
	
	//생성자
	
	private static pcroomDAO pcdao = new pcroomDAO();  // 싱글톤 DAO 객체 [ 1. 생성자를 private  2.정적 객체 ]
	
	private pcroomDAO() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mmth",
					"root", 
					"1234");			
		} catch (Exception e) {
			System.out.println("DB연동 실패"+e);
		}	
	}
	
	// 메서드 작성
	
	
}
