package pcRoom.Model.DAO;

import pcRoom.Model.DTO.dayrecordDTO;
import pcRoom.Model.DTO.membersDTO;

public class PcRoomAdminDAO extends PcRoomDAO{

	// 생성자
	private PcRoomAdminDAO() {
		super();
	}

	private static PcRoomAdminDAO praDao = new PcRoomAdminDAO();

	public static PcRoomAdminDAO getinstance() {
		return praDao;
	}

	// 매출확인
	public dayrecordDTO daysales(String date) {
		dayrecordDTO dto = new dayrecordDTO();
		String sql = "select*from dayrecord where dDate = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, date);
			rs = ps.executeQuery();
			rs.next();
			dto = new dayrecordDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
			return dto;
		} catch (Exception e) {
			System.out.println("DB오류" + e);
		}
		return dto;
	}

	// 월매출확인
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
		} catch (Exception e) {
			System.out.println("DB오류" + e);
		}
		return dto;
	}

	// 회원검색
	public membersDTO memberSearch(String search) {
		membersDTO dto = new membersDTO();
		String sql = "select* from members where memId=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, search);
			rs = ps.executeQuery();
			rs.next();
			dto = new membersDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			return dto;
		} catch (Exception e) {
			System.out.println("오류발생" + e);
		}
		return dto;
	}
	
	//요금제등록 
	public boolean inputPrice(int money,int time) {
		String sql="insert into priceTable values(null,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,money);
			ps.setInt(2,time);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("요금제 오류발생"+e);}
		return false;
	}
}
