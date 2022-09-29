package pcRoom.Controller;

import pcRoom.Model.DAO.SeatDAO;
import pcRoom.Model.DTO.membersDTO;

public class SeatController {
	
	
	//회원가입
	public boolean singUp(String memID,String memPW,String memPhone) {
		return SeatDAO.getInstance().singUp(memID, memPW , memPhone);
	}
	
	//로그인
	public boolean login(String ID, String PW) {
		
		membersDTO dto = new membersDTO(ID, PW);
		boolean result = SeatDAO.getInstance().login(dto);
		
		if(result) {
			return true;
		}else {
			return false;
		}
	}
	
}
