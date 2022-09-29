package pcRoom.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pcRoom.Model.DTO.dayrecordDTO;

public class PcRoomAdminDAO {

	private static Connection con;				// db 연동 인터페이스
	private static PreparedStatement ps;		// db 조작 인터페이스
	private static ResultSet rs;				// db 쿼리 조작 인터페이스
	
	//생성자
	private PcRoomAdminDAO() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pcroom",
					"root", 
					"1234");
		} catch (Exception e) {
			System.out.println("DB연동 실패"+e);
		}
	}
	
	private static PcRoomAdminDAO praDao = new PcRoomAdminDAO();
	
	public static PcRoomAdminDAO getinstance(){
		return praDao;
	}
	
	//매출확인 
	public dayrecordDTO daysales(String date) {
		dayrecordDTO dto = new dayrecordDTO();
		String sql="select*from dayrecord where dDate = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, date);
			rs = ps.executeQuery();
			rs.next();
			dto = new dayrecordDTO(rs.getInt(1),rs.getString(2),rs.getInt(3));
			return dto;
		} catch (Exception e) {System.out.println("DB오류"+e);}
		return dto;
	}
	//월매출확인 
	public dayrecordDTO M_daysales(String date) {
		dayrecordDTO dto = new dayrecordDTO();
		String sql = "select sum(dayincome) from dayrecord where substring(dDate,1,6) = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, date);
			rs = ps.executeQuery();
			rs.next();
			dto = new dayrecordDTO(rs.getInt(1));
			return dto;
		} catch (Exception e) {System.out.println("DB오류"+e);}
		return dto;
	}
}
