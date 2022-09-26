package pcRoom;

import java.util.ArrayList;

public class Controller {
	
	// pricetable 호출 메서드
	ArrayList<priceDTO> priceViewer(){
		return pcroomDAO.getInstance().priceViewer();
	}
	
}
