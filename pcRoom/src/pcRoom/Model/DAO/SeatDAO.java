package pcRoom.Model.DAO;

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
	public boolean singUp(String memID,String memPW,String memPhone){
		String sql = "select * from members where memID = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memID);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}			
			sql = "insert into members values (null,?,?,?,null)";
			ps = con.prepareStatement(sql);
			ps.setString(1, memID);
			ps.setString(2, memPW);
			ps.setString(3, memPhone);
			ps.executeUpdate();
			return true;
		} catch (Exception e) { System.out.println("Dao 연동실패"+ e);}
		return false;
	}
	
	// 로그인
	public int login(membersDTO dto) {
		String sql = "select * from members where (memID, memPW) =  (? , ?) ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMemID());
			ps.setString(2, dto.getMemPW());
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return 0;
			}			
		} catch (Exception e) {
			System.out.println("login DB연동 오류" + e);
		}
		return 0;
	}	
}
