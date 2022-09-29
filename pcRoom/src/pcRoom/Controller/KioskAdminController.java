package pcRoom.Controller;

import pcRoom.Model.DAO.PcRoomAdminDAO;
import pcRoom.Model.DAO.PcRoomUserDAO;
import pcRoom.Model.DTO.dayrecordDTO;

public class KioskAdminController {
	
	//일매출
	public dayrecordDTO daysales(String date) {
		return PcRoomAdminDAO.getinstance().daysales(date);	
		
	}
	//월매출
	public dayrecordDTO M_daysales(String date) {
		return PcRoomAdminDAO.getinstance().M_daysales(date);
	}
}
