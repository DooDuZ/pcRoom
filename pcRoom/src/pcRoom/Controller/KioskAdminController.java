package pcRoom.Controller;

import pcRoom.Model.DAO.PcRoomAdminDAO;
import pcRoom.Model.DTO.dayrecordDTO;
import pcRoom.Model.DTO.membersDTO;

public class KioskAdminController {

	// 일매출
	public dayrecordDTO daysales(String date) {
		return PcRoomAdminDAO.getinstance().daysales(date);

	}

	// 월매출
	public dayrecordDTO M_daysales(String date) {
		return PcRoomAdminDAO.getinstance().M_daysales(date);
	}

	// 회원검색
	public membersDTO memberSearch(String search) {
		return PcRoomAdminDAO.getinstance().memberSearch(search);
	}
}
