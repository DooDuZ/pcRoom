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
	
}
