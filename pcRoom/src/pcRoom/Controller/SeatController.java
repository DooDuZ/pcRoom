package pcRoom.Controller;

import pcRoom.Model.DAO.SeatDAO;
import pcRoom.Model.DTO.membersDTO;

public class SeatController {
	
	public int login(String ID, String PW) {
		membersDTO dto = new membersDTO(ID, PW);
		return SeatDAO.getInstance().login(dto);
	}	
}
