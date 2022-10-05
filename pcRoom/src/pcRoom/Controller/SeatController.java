package pcRoom.Controller;

import java.util.regex.Pattern;

import pcRoom.Model.DAO.SeatDAO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.data.SeatTimer;

public class SeatController {	
	
	membersDTO dto ;
	SeatTimer st = new SeatTimer();

	//회원가입
	public boolean singUp(String memID,String memPW, String memName,String memPhone) {
		return SeatDAO.getInstance().singUp(memID, memPW , memName,memPhone);
	}
	
	//ID 유효성검사
	public boolean checkID(String ID) {
		String regular = "^[A-Za-z[0-9]]{8,16}$"; // 8~16글자로 길이 수정 
		boolean regex = Pattern.matches(regular, ID);
		if(!regex) {
			return false;
		}
		return true;
	}
	// 비밀번호 유효성 검사
	public boolean checkPW(String PW) {
		String regular =  "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$"; // 패턴 수정 필요
		boolean regex = Pattern.matches(regular, PW);
		if(!regex) {
			return false;
		}
		return true;
	}
	// 휴대폰번호 유효성 검사
	public boolean checkPhone(String Phone) {
		String regular =  "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$"; // 패턴 수정 필요
		boolean regex = Pattern.matches(regular, Phone);
		if(!regex) {
			return false;
		}
		return true;
	}
	
	//로그인
	public int login(String ID, String PW) {
		membersDTO dto = new membersDTO(ID, PW);
		int[] memInfo = SeatDAO.getInstance().login(dto);
		if(memInfo[0]==-2) {
			return memInfo[0];
		}else if(memInfo[1]>1) {
			return memInfo[0];
		}else {
			return -1;
		}
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
