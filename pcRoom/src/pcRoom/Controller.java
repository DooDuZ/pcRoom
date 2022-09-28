package pcRoom;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
	// pricetable 호출 메서드
	ArrayList<priceDTO> priceViewer(){
		return pcroomDAO.getInstance().priceViewer();
	}
	boolean charge(int ch, int payment) {
		// 진행중
	}
	//일매출
	dayrecordDTO daysales(String date) {
		return pcroomDAO.getInstance().daysales(date);	
	}
	
	dayrecordDTO M_daysales(String date) {
		return pcroomDAO.getInstance().M_daysales(date);
	}
	

	// 로그인
	boolean login(String memID , String memPW) {
		membersDTO dto = new membersDTO(memID, memPW);
		return pcroomDAO.getInstance().login(dto);
	}

}//class E
