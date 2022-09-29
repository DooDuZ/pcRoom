package pcRoom;

import java.util.ArrayList;

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
	//월매출 
	dayrecordDTO M_daysales(String date) {
		return pcroomDAO.getInstance().M_daysales(date);
	}
	//회원검색 
	membersDTO memberSearch(String search) {
		return pcroomDAO.getInstance().memberSearch(search);
	 }
	
	
}//class E
