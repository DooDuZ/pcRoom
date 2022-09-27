package pcRoom;

import java.util.ArrayList;
import java.util.Scanner;

public class View {	
	
	Controller con = new Controller();
	
	public static void main(String[] args) {
		View view = new View();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("1. 회원가입 2. 좌석선택 3. 로그인/로그아웃 4. 매출확인 5. 시간충전");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				// 회원가입_고은시
			}else if(ch==2){
				// 좌석선택 (보류)
			}else if(ch==3){
				// 로그인/로그아웃_안태섭
			}else if(ch==4){
				// 매출확인_김원종
				System.out.println("1.일일매출확인 2.월매출확인 ");int sale=scanner.nextInt();
				if(sale==1) {
					System.out.print("확인할 날짜를 입력해주세요 :");String date=scanner.next();
						view.dayrecord(date);
				}
				else if(sale==2) {
					System.out.println("확인할 월을 입력해주세요");String date=scanner.next();
						view.M_dayrecord(date);
				}
				else {System.err.println("입력할수 없는 번호입니다");}
				
				
			}else if(ch==5){
				// 시간충전_신지웅
				view.chargeView();
				System.out.println("요금제를 선택해 주세요.");
				int sel_numb = scanner.nextInt();
				view.charge(sel_numb);
			}
		}		
	}
	
	//시간충전 메서드
	void chargeView() {
		ArrayList<priceDTO> list = new ArrayList<priceDTO>();
		list = con.priceViewer(); 
		for(priceDTO tmp : list) {
			System.out.println(tmp.getPriceNo()+"."+tmp.getPrice()+"원 \t"+tmp.getHours()+"시간");
		}
	}
	void charge(int sel_numb) {
		if(sel_numb==1) {
			//로그인 구현 후 진행
		}
	}
	//일별매출
	void dayrecord(String date) {
		dayrecordDTO dto = con.daysales(date); 
		System.out.println("날짜\t매출");
		System.out.println(dto.getdDate()+"\t"+dto.getDayIncome());
	}
	//월별매출
	void M_dayrecord(String date) {
		dayrecordDTO dto = con.M_daysales(date);
		System.out.println("월별매출\n");
		System.out.println(dto.getdDate()+"\n"+dto.getDayIncome());
	}
	
}//class E
