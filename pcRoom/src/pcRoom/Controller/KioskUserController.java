package pcRoom.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import pcRoom.Model.DAO.PcRoomUserDAO;
import pcRoom.Model.DTO.dayrecordDTO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.Model.DTO.priceDTO;

public class KioskUserController {
	
	// 로그인
	public int login(String memID , String memPW) {
		membersDTO dto = new membersDTO(memID, memPW);
		return PcRoomUserDAO.getInstance().login(dto);
	}	
	// pricetable 호출 메서드
	public ArrayList<priceDTO> priceViewer(){
		return PcRoomUserDAO.getInstance().priceViewer();
	}
	// 요금제 충전 메서드
	public boolean charge(int ch, int payment, int memNo) {
		return PcRoomUserDAO.getInstance().charge(ch, payment, memNo);
	}
}//class E
