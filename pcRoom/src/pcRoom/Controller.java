package pcRoom;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
	// pricetable 호출 메서드
	ArrayList<priceDTO> priceViewer(){
		return pcroomDAO.getInstance().priceViewer();
	}
	void charge(int sel_numb) {
		if(sel_numb==1) {
			//로그인 구현 후 진행
		}
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
