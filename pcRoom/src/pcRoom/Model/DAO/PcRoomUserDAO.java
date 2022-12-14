package pcRoom.Model.DAO;

import java.util.ArrayList;
import pcRoom.Model.DTO.currentPcDTO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.Model.DTO.priceDTO;


public class PcRoomUserDAO extends PcRoomDAO{

	private PcRoomUserDAO() {
		super();
	}
	
	// 메서드 작성
	private static PcRoomUserDAO pcdao = new PcRoomUserDAO();  // 싱글톤 DAO 객체 [ 1. 생성자를 private  2.정적 객체 ]
	
	public static PcRoomUserDAO getInstance() {
		return pcdao;
	}	
	// 좌석 화면 출력 메서드
	public ArrayList<currentPcDTO> printSeat () {
		ArrayList<currentPcDTO> list = new ArrayList<currentPcDTO>();
		// 현재 pc정보를 저장할 수 있는 DTO를 자료형으로 사용하는 ArrayList 생성
		String sql = "select * from currentPc;";	// 현재 pc정보 호출
		try {
			ps = con.prepareStatement(sql); 
			rs = ps.executeQuery();	// 쿼리조작
			while(rs.next()) {	// sql문의 결과값이 있으면 값이 없을 때 까지
				currentPcDTO dto = new currentPcDTO(rs.getInt(1), rs.getBoolean(2));
				// dto에 정보 저장
				list.add(dto); //ArrayList에 dto를 저장
			}
			return list; // list를 반환
		} catch (Exception e) {
			System.out.println("좌석출력 DB 오류" + e);
		}
		return list;
	}
	// 로그인 [안태섭]완료
	public int login (membersDTO dto) {
		String sql ="SELECT * FROM members WHERE memID = ? AND memPW = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getMemID() ); // 첫 번째 ? 에 memID 대입
			ps.setString( 2 , dto.getMemPW() ); // 두 번째 ? 에 memPW 대입
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1); // 로그인 성공
			} else {
				return 0;	// 데이터베이스에 회원 정보 X
			}
		} catch (Exception e) {System.out.println("데이터베이스 오류"+e);}
		return 0;
	} // LOGIN END
	
	// 요금제 출력 메서드
	public ArrayList<priceDTO> priceViewer(){
		ArrayList<priceDTO> list = new ArrayList<priceDTO>();
		String sql = "select * from priceTable;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				priceDTO dto = new priceDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				list.add(dto);				
			}
			return list;
		} catch (Exception e) {
			System.out.println("DB오류"+e);
		}
		return list;
	}
	// 요금제 충전 메서드
	public int charge(int ch, int payment, int memNo) {
		String sql = "select memTime from members where memNo = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, memNo);
			rs = ps.executeQuery();
			rs.next();
			int memtime  = rs.getInt(1);
			sql = "select * from priceTable where pNo = ?;";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ch);
			rs = ps.executeQuery();
			rs.next();
			if(rs.getInt(2)<=payment) {
				sql = "update members set memTime = ? where memNo= ?;";
				ps = con.prepareStatement(sql);
				ps.setInt(1, memtime+(rs.getInt(3)*60)); // 이전 시간 값에 덮어쓰기 되는 상태. 추가 변수 선언 필요.
				ps.setInt(2, memNo);
				ps.executeUpdate();
				sql = "insert into dayRecord values (null, now(), ?);";
				ps = con.prepareStatement(sql);					
				ps.setInt(1, rs.getInt(2));
				ps.executeUpdate();
				return (payment-rs.getInt(2));
			}					
		} catch (Exception e) {
			System.out.println("DB오류"+e);
		}
		return -1;
	}	
}//class E
