package pcRoom.Model.DAO;

import java.util.ArrayList;

import pcRoom.Model.DTO.dayrecordDTO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.Model.DTO.pcListDTO;
import pcRoom.Model.DTO.priceDTO;


public class PcRoomAdminDAO extends PcRoomDAO{

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
			System.out.println("매출확인 오류발생" + e);
		}
		return dto;
	}

	// 월매출확인
	public dayrecordDTO M_daysales(String date) {
		dayrecordDTO dto = new dayrecordDTO();
		String sql = "select sum(dayIncome) from dayRecord where month(dDate)= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, date);
			rs = ps.executeQuery();
			rs.next();
			dto = new dayrecordDTO(rs.getInt(1));
			return dto;
		} catch (Exception e) {
			System.out.println("월매출확인 오류발생" + e);
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
			dto = new membersDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getInt(6));
			return dto;
		} catch (Exception e) {
			System.out.println("회원검색 오류발생" + e);
		}
		return dto;
	}
	
	
	//좌석 정보 확인 
	public pcListDTO Information(int num ) {
		pcListDTO dto = new pcListDTO();
		String sql="select* from pcList where pcNo=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			rs.next();
			dto = new pcListDTO(rs.getInt(1), rs.getBoolean(2), rs.getInt(3), rs.getString(4),rs.getString(5));
			return dto;
		} catch (Exception e) {
			System.out.println("좌석검색 오류발생" + e);
		} return dto;
	}
	

	// 요금제 출력
	public ArrayList<priceDTO> showPrice() {
		ArrayList<priceDTO> list = new ArrayList<>();
		String sql = "select *from  priceTable";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				priceDTO dto = new priceDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("요금출력 오류발생" + e);
		}
		return list;
	}

	// 요금제등록
	public boolean inputPrice(int money, int time) {
		String sql = "insert into priceTable values(null,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setInt(2, time);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("요금제등록 오류발생" + e);
		}
		return false;
	}

	// 요금제 삭제
	public boolean deletePrice(int price_num) {
		String sql = "DELETE FROM priceTable  WHERE pNo=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, price_num);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("요금제 삭제 오류" + e);
		}
		return false;
	}
}
