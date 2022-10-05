package pcRoom.Controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import pcRoom.Model.DAO.PcRoomUserDAO;
import pcRoom.Model.DTO.currentPcDTO;
import pcRoom.Model.DTO.dayrecordDTO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.Model.DTO.priceDTO;

public class KioskUserController {
	
	// 로그인 메서드
	public int login(String memID , String memPW) {
		membersDTO dto = new membersDTO(memID, memPW);
		return PcRoomUserDAO.getInstance().login(dto);
	}	
	
	// pricetable 호출 메서드
	public ArrayList<priceDTO> priceViewer(){
		return PcRoomUserDAO.getInstance().priceViewer();
	}
	
	// 요금제 충전 메서드
	public int charge(int ch, int payment, int memNo) {
		return PcRoomUserDAO.getInstance().charge(ch, payment, memNo);
	}
	
	// 좌석 출력 메서드
	public ArrayList<currentPcDTO> printSeat () {
		return PcRoomUserDAO.getInstance().printSeat();
	}

}//class E
