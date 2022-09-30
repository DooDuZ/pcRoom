package pcRoom.Controller;

import pcRoom.Model.DAO.SeatDAO;
import pcRoom.Model.DTO.membersDTO;

public class SeatController {	
	//회원가입
	public boolean singUp(String memID,String memPW,String memPhone) {
		return SeatDAO.getInstance().singUp(memID, memPW , memPhone);
	}
	
	//로그인
	public int login(String ID, String PW) {
		membersDTO dto = new membersDTO(ID, PW);
		return SeatDAO.getInstance().login(dto);
	}	
}
