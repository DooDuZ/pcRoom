package pcRoom;

import java.util.ArrayList;
import java.util.Scanner;

public class View {	
	
	Controller con = new Controller();
	boolean logout = true;
	public static void main(String[] args) {
		
		View view = new View();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			/*
			 * 사용자 : 
			 * ㄴ 비로그인 화면 : 로그인 / 회원가입 / ID찾기 / 비밀번호 찾기
			 * ㄴ 로그인 화면 : 게임목록 / 로그아웃 / 주문(보류)
			 * 키오스크 : 
			 * ㄴ 관리자 : 매출관리 / 회원 정보 검색 / 좌석 선택 / 요금제 등록/삭제 /재고관리(보류) 
			 * ㄴ 고객 : 실시간 좌석 / 요금제 선택
			 *						ㄴ 로그인 -> 금액 입력 -> 충전 / 충전시 자동 로그아웃
			 */
			
			System.out.println("======요금제 선택=======");
			System.out.println("1. 1000원\t 1시간");
			System.out.println("2. 5000원\t 5시간");
			System.out.println("3. 10000원\t 1시간");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				// 
			}else if(ch==2){
				// 좌석선택 (보류)
			}else if(ch==3){
				// 로그인/로그아웃_안태섭 [ 미완 ]
				System.out.println("1. 로그인 2. 로그아웃 ");
				int loginbtn = scanner.nextInt();

				if( loginbtn == 1) {
					System.out.print("아이디 : "); String memID = scanner.next();
					System.out.print("비밀번호 : "); String memPW = scanner.next();
					view.login(memID , memPW);
					System.out.println(view.logout);
			
				} else if(loginbtn == 2) { 
					view.logout();
					System.out.println("로그아웃 되었습니다 안녕히 가세요");
				}
	// System.out.println("1. 회원가입 2. 좌석선택 3. 로그아웃 4. 매출확인 5. 시간충전");
	// System.out.println("2. 로그아웃 ");

			}else if(ch==4){
				// 매출확인_김원종
				System.out.println("1.일일매출확인 2.월매출확인 ");int sale=scanner.nextInt();
				if(sale==1) {
					System.out.print("확인할 날짜를 입력해주세요 :"); String date=scanner.next();
						view.dayrecord(date);
				}
				else if(sale==2) {
					System.out.println("확인할 월을 입력해주세요"); String date=scanner.next();
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
	} // main end
	
	// 로그아웃 메서드
	
	void logout() {
		logout = false;
	}
	
	// 로그인 메서드
	void login(String memID , String memPW) {		
		boolean result = con.login(memID, memPW);
		if(result == true) { 
			logout = true;
			System.out.println("로그인에 성공했습니다 즐거운 시간 되세요.");
		}else {
			System.out.println("로그인에 실패했습니다 다시 입력해주세요.");
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
		System.out.println(date+" : "+dto.getDayIncome());
	}
	
}//class E
