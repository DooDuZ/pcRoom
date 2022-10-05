package pcRoom.Controller;

import java.util.ArrayList;

import pcRoom.Model.DAO.PcRoomAdminDAO;
import pcRoom.Model.DTO.dayrecordDTO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.Model.DTO.PcRecord;
import pcRoom.Model.DTO.priceDTO;

public class KioskAdminController {

	// 일매출
	public dayrecordDTO daysales(String date) {
		return PcRoomAdminDAO.getinstance().daysales(date);

	}

	// 월매출
	public dayrecordDTO M_daysales(String date) {
		return PcRoomAdminDAO.getinstance().M_daysales(date);
	}
	
	// 회원리스트 출력
	public ArrayList<membersDTO> memberList() {
		return PcRoomAdminDAO.getinstance().memberList();
	}
	// 회원 삭제
	public boolean deleteMember(int memNo) {
		return PcRoomAdminDAO.getinstance().deleteMember(memNo);
	}
	
	// 회원검색
	public membersDTO memberSearch(String search) {
		return PcRoomAdminDAO.getinstance().memberSearch(search);
	}
	
	//좌석 정보 확인
	public PcRecord Information(int num ) {
		return PcRoomAdminDAO.getinstance().Information(num);
	}
	
	
	// 요금제 출력 
	 public ArrayList<priceDTO> showPrice() {
		 return PcRoomAdminDAO.getinstance().showPrice();
	 }
	
	//요금제 등록 
	public boolean inputPrice(int money,int time) {
		return PcRoomAdminDAO.getinstance().inputPrice(money, time);
	}	
	//요금제 삭제 
	public boolean deletePrice(int price_num) {
		return PcRoomAdminDAO.getinstance().deletePrice(price_num);
	}
	
}
