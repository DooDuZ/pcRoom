package pcRoom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class pcroomDAO {
	
	private Connection con;				// db 연동 인터페이스
	private PreparedStatement ps;		// db 조작 인터페이스
	private ResultSet rs;				// db 쿼리 조작 인터페이스
	
	//생성자
	
	private pcroomDAO() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pc_room",
					"root", 
					"1234");
		} catch (Exception e) {
			System.out.println("DB연동 실패"+e);
		}
	}
	
	// 메서드 작성
	public static pcroomDAO getInstance() {
		return pcdao;
	}
	
	private static pcroomDAO pcdao = new pcroomDAO();  // 싱글톤 DAO 객체 [ 1. 생성자를 private  2.정적 객체 ]
	
	// 로그인 [안태섭] 미완
	public boolean login (membersDTO dto) {
		String sql ="SELECT * FROM members WHERE memID = ? AND memPW = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getMemID() ); // 첫 번째 ? 에 memID 대입
			ps.setString( 2 , dto.getMemPW() ); // 두 번째 ? 에 memPW 대입
			rs = ps.executeQuery();
			if(rs.next()) {
				return true; // 로그인 성공
			} else {
				return false;	// 데이터베이스에 회원 정보 X
			}
		} catch (Exception e) {System.out.println("데이터베이스 오류");}
		return false;
	} // LOGIN END
	
	// 요금제 출력 메서드
	ArrayList<priceDTO> priceViewer(){
		ArrayList<priceDTO> list = new ArrayList<priceDTO>();
		String sql = "select * from pricetable;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				priceDTO dto = new priceDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				list.add(dto);				
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	void charge(int sel_numb) {
		if(sel_numb==1) {
			//로그인 구현 후 진행
		}
	}

	//매출확인 
	dayrecordDTO daysales(String date) {
		dayrecordDTO dto = new dayrecordDTO();
		String sql="select*from dayrecord where dDate = ?";
		System.out.println("여기-1");
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
	dayrecordDTO M_daysales(String date) {
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
	
}//class E
