package pcRoom.Controller;

import pcRoom.Model.DAO.SeatDAO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.data.SeatTimer;

public class SeatController {	
	
	membersDTO dto ;
	SeatTimer st = new SeatTimer();

	
	//회원가입
	public boolean singUp(String memID,String memPW,String memPhone) {
		return SeatDAO.getInstance().singUp(memID, memPW , memPhone);
	}
	
	//로그인
	public int login(String ID, String PW) {
		membersDTO dto = new membersDTO(ID, PW);
		return SeatDAO.getInstance().login(dto);
	}
	
	//고객 좌석 타이머 구현
		//view->dao정보 전송
	public membersDTO printTime(int SeatNo, int mNo) {
		return SeatDAO.getInstance().printTime(SeatNo, mNo);
	}
	
	// 시간 차감 정보 DB 전송 -> 상호 참조 시 stackOverFlow 발생
	// SeatTimer -> DAO 직접 접근
	
	//로그아웃 시간 저장 
	public void saveLogout(int SeatNo) {
		SeatDAO.getInstance().saveLogout(SeatNo);
	}

}
