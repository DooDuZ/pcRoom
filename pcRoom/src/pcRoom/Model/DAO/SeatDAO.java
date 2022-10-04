package pcRoom.Model.DAO;

import java.util.ArrayList;

import pcRoom.Model.DTO.currentPcDTO;
import pcRoom.Model.DTO.membersDTO;

public class SeatDAO extends PcRoomDAO{
	//생성자
	private SeatDAO() {
		super();
	}
	static SeatDAO sDAO = new SeatDAO();
	
	public static SeatDAO getInstance() {
		return sDAO;
	}
	// 회원가입
	public boolean singUp(String memID,String memPW, String memName,String memPhone){
		String sql = "select * from members where memID = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memID);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}
			sql = "insert into members values (null,?,?,?,?,null)";
			ps = con.prepareStatement(sql);
			ps.setString(1, memID);
			ps.setString(2, memPW);
			ps.setString(3, memName);
			ps.setString(4, memPhone);
			ps.executeUpdate();
			return true;
		} catch (Exception e) { System.out.println("Dao 연동실패"+ e);}
		return false;
	}
	
	// 로그인
	public int[] login(membersDTO dto) {
		int[] memInfo = new int[2];
		String sql = "select * from members where memID = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMemID());
			rs = ps.executeQuery();
			rs.next();
			int memNo = rs.getInt(1);
			sql = "select * from PCrecord where memNo = ? and eTime is null;";
			ps = con.prepareStatement(sql);
			ps.setInt(1, memNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				memInfo[0] = -2;
				return memInfo;
			}
			sql = "select * from members where (memID, memPW) =  (? , ?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMemID());
			ps.setString(2, dto.getMemPW());
			rs = ps.executeQuery();
			if(rs.next()) {
				memInfo[0] = rs.getInt(1);
				memInfo[1] = rs.getInt(6);
				return memInfo;
			}else {
				return memInfo;
			}
		} catch (Exception e) {
			System.out.println("login DB연동 오류" + e);
		}
		return memInfo;
	}
	
	//고객 좌석 타이머 구현
	public membersDTO printTime (int SeatNo, int mNo){
		membersDTO dto = new membersDTO();
		String sql = "update currentPc set cPlay=true where pcNo = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, SeatNo);			
			ps.executeUpdate();
			sql="insert into PCrecord values(null, ?, now(), null, ?);";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mNo);
			ps.setInt(2, SeatNo);
			ps.executeUpdate();
			sql="select memID, memTime from members where memNo = ? ";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new membersDTO(mNo, rs.getString(1), rs.getInt(2));
			}
			return dto;
		} catch (Exception e) {
			System.out.println("좌석 타이머 db 오류"+e);
		}
		return dto;
	}
	
	//줄어든 시간 DB에 저장

	public void setDB(int memNo, int memTime) {
		String sql = "update members set memTime=? where memNo=? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, memTime);
			ps.setInt(2, memNo);
			ps.executeUpdate();
			if(memTime==0) {
				sql = "select * from PCrecord where memNo = ? and eTime is null;";
				ps = con.prepareStatement(sql);
				ps.setInt(1, memNo);
				rs = ps.executeQuery();
				rs.next();
				saveLogout(rs.getInt(2));
			}
		} catch (Exception e) {
			System.out.println("시간차감 DB 오류"+e);
		}
	}
	
	// 로그아웃 시간 저장 및 currentPC 정보 변경
	public void saveLogout(int SeatNo) {
		String sql = "update PCrecord set eTime=now() where pcNo = ? and eTime is null ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, SeatNo);
			ps.executeUpdate();
			sql = "update currentPc set cPlay=false where pcNo = ? ;";
			ps = con.prepareStatement(sql);
			ps.setInt(1, SeatNo);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("종료시간 저장 DB오류"+e);
		}
	}
}