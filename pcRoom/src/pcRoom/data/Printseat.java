package pcRoom.data;


import java.util.ArrayList;
import pcRoom.Controller.KioskAdminController;
import pcRoom.Controller.KioskUserController;
import pcRoom.Model.DTO.currentPcDTO;

public class Printseat implements Runnable{
	KioskUserController con = new KioskUserController();
	KioskAdminController conAd = new KioskAdminController();
	boolean OnOff = true ;

		@Override
		public void run() {
			
			while(OnOff) {
				for(int i = 0 ; i<5 ; i++) {
					System.out.println("");
				}
				System.out.println("1. 회원가입 2. 좌석선택 3. 로그인/로그아웃 4. 매출확인 5. 시간충전");
				ArrayList<currentPcDTO> list = new ArrayList<>();
				list = con.printSeat();
				System.out.println();
				int count=0;
				for( currentPcDTO tmp : list) {
					count++;
					if(tmp.iscPlay()) {
						System.out.print("[X]");
					}else {
						System.out.print("[ ]");
					}
					if(count%5==0) {
						System.out.println("");
					}
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("thread오류"+e);
				}
				
			}		
		}
		
	}
