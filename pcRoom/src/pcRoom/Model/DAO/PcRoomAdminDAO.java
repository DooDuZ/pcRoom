package pcRoom.Model.DAO;

import java.util.ArrayList;

import pcRoom.Model.DTO.dayrecordDTO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.Model.DTO.PcRecord;
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
		String sql = "select sum(dayIncome) from dayRecord where substring(dDate, 1, 10) = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, date);
			rs = ps.executeQuery();
			rs.next();
			dto = new dayrecordDTO(rs.getInt(1));
			return dto;
		} catch (Exception e) {
			System.out.println("매출확인 오류발생" + e);
		}
		return dto;
	}

	// 월매출확인
	public dayrecordDTO M_daysales(String date) {
		dayrecordDTO dto = new dayrecordDTO();
		String sql = "select sum(dayIncome) from dayRecord where substring(dDate, 1, 7) = ?;";
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
		String sql = "select * from members where memId=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, search);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new membersDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getInt(6));
				return dto;
			}
		} catch (Exception e) {
			System.out.println("회원검색 오류발생" + e);
		}
		return dto;
	}
	
	
	//좌석 정보 확인 
	public PcRecord Information(int num ) {
		PcRecord dto = new PcRecord();
		String sql="select * from currentPc where pcNo=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			rs.next();
			if(rs.getBoolean(2)) {
				sql="select * from pcrecord where pcNo=? and eTime is null";
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);
				rs = ps.executeQuery();
				if(rs.next()) {
					dto = new PcRecord(rs.getInt(5), rs.getString(3), rs.getString(4), rs.getInt(2), null);
				}

				sql="select memID from members where memNo= ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, dto.getMemNo());
				rs = ps.executeQuery();
				if(rs.next()) {
					dto.setmemID(rs.getString(1));
				}

			}else {
				dto.setMemNo(-1);
			}
			return dto;
		} catch (Exception e) {
			System.out.println("좌석검색 오류발생" + e);
		} return dto;
	}
	

	// 요금제 출력
	public ArrayList<priceDTO> showPrice() {
		ArrayList<priceDTO> list = new ArrayList<>();
		String sql = "select *from priceTable";
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
