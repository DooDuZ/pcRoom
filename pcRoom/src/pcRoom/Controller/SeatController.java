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
		String regular = "^[A-Za-z[0-9]]{6,15}$";
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
	
	public boolean checkPhone(String Phone) {
		boolean checkNum = true;
		if(Phone.length()!=11 || !Phone.substring(0, 3).equals("010")) {			
			return false;
		}
		for(int i = 0; i<=10 ; i++) {
			int a = Phone.charAt(i);
			if(a<48 || a> 57) {
				checkNum = false;
			}
		}
		if(checkNum) {
			return true;
		}else {
			return false;
		}
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
