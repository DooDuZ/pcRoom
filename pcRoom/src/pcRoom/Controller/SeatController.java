package pcRoom.Controller;

import pcRoom.Model.DAO.SeatDAO;
import pcRoom.Model.DTO.membersDTO;

public class SeatController {
	
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
