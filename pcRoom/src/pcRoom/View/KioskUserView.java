package pcRoom.View;

import java.util.ArrayList;
import java.util.Scanner;
import pcRoom.Controller.KioskAdminController;
import pcRoom.Controller.KioskUserController;
import pcRoom.Model.DTO.dayrecordDTO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.Model.DTO.priceDTO;
import pcRoom.data.Printseat;

public class KioskUserView {

	KioskUserController con = new KioskUserController();
	KioskAdminController conAd = new KioskAdminController();
	boolean OnOff = true ;

	public static void main(String[] args) {

		KioskUserView view = new KioskUserView();
		Scanner scanner = new Scanner(System.in);
		
		// 좌석출력 메서드 시작
		Printseat print = new Printseat();
		Thread thread = new Thread(print);
		thread.start();
		
		while (true) {
			int memNo; // 로그인 시 로그인 대상 정보 저장
			// 0 입력시 관리자모드 / 출력은 안할 예정
			int start = scanner.nextInt();
			if (start == 1) {
				System.out.print("아이디 : ");
				String memID = scanner.next();
				System.out.print("비밀번호 : ");
				String memPW = scanner.next();
				memNo = view.login(memID, memPW);
				if (memNo > 0) {
					System.out.println("======요금제 선택=======");
					view.chargeView();
					System.out.println("요금제를 선택해 주세요.");
					int ch = scanner.nextInt();
					System.out.println("금액을 투입해 주세요.");
					int payment = scanner.nextInt();
					view.charge(memNo, ch, payment);
				} else {
					continue;
				}
			} else if (start == 0) {
				while (true) {
					System.out.println("\t\t============현 화면은 관리자모드 입니다============");
					System.out.println("\t1.매출확인\t2.회원정보검색\t 3.좌석 선택\t4.요금제 등록/삭제");
					int ch = scanner.nextInt();
					if (ch == 1) {
						while (true) {
							System.out.println("1.일일매출확인 2.월매출확인 ");
							int sale = scanner.nextInt();
							if (sale == 1) {
								System.out.print("확인할 날짜를 입력해주세요 :");
								String date = scanner.next();
								view.dayrecord(date);
								break;
							} // if sale1 E
							else if (sale == 2) {
								System.out.println("확인할 월을 입력해주세요");
								String date = scanner.next();
								view.M_dayrecord(date);
								break;
							} // if sale2 E
						} // while E
					} // if ch1 E

					if (ch == 2) {
						System.out.println("검색할 회원 아이디를 입력해주세요.");
						String search = scanner.next();
						view.memberSearch(search);
						break;
					}
					if (ch == 3) {
					}
					if (ch == 4) {
						System.out.println("1.요금제 등록 2.요금제 삭제");
						int price = scanner.nextInt();
						if (price == 1) {
						System.out.println("입력할 요금을 입력하세요 ");int money=scanner.nextInt();
						System.out.println("입력한 요금에 시간을 입력해주세요");int time = scanner.nextInt();
						view.inputPrice(money, time);
						} 
						else if (price == 2) {
							
						} else {
							System.out.println("선택할수 없는 항목입니다");
						} // else E
					} // if ch4 E
				} // 관리자 while E
			} // else if (0) E
		} // 전체 while E
	} // main end

	// System.out.println("1. 회원가입 2. 좌석선택 3. 로그아웃 4. 매출확인 5. 시간충전");
	// System.out.println("2. 로그아웃 ");
	/*
	 * 관리자 메뉴에 옮길 예정 else if(ch==4){ // 매출확인_김원종
	 * System.out.println("1.일일매출확인 2.월매출확인 ");int sale=scanner.nextInt();
	 * if(sale==1) { System.out.print("확인할 날짜를 입력해주세요 :"); String
	 * date=scanner.next(); view.dayrecord(date); } else if(sale==2) {
	 * System.out.println("확인할 월을 입력해주세요"); String date=scanner.next();
	 * view.M_dayrecord(date); } else {System.err.println("입력할수 없는 번호입니다");}
	 * 
	 * 
	 * }else if(ch==5){ // 시간충전_신지웅 view.chargeView();
	 * System.out.println("요금제를 선택해 주세요."); int sel_numb = scanner.nextInt();
	 * view.charge(sel_numb); }
	 */
	
	// 로그인 메서드
	int login(String memID, String memPW) {
		int result = con.login(memID, memPW);
		if (result != 0) {
			System.out.println("로그인에 성공했습니다.");
			return result;
		} else {
			System.out.println("로그인에 실패했습니다 다시 입력해주세요.");
			return 0;
		}
	}

	// 시간충전 메서드
	void chargeView() {
		ArrayList<priceDTO> list = new ArrayList<priceDTO>();
		list = con.priceViewer();
		for (priceDTO tmp : list) {
			System.out.println(tmp.getPriceNo() + "." + tmp.getPrice() + "원 \t" + tmp.getHours() + "시간");
		}
	}

	void charge(int memNo, int ch, int payment) {
		boolean result = con.charge(ch, payment, memNo);
		if (result) {
			System.out.println("충전 완료");
		} else {
			System.out.println("[충전 실패] 금액이 부족합니다.");
		}
	}

	// 일별매출
	void dayrecord(String date) {
		dayrecordDTO dto = conAd.daysales(date);
		System.out.println("날짜\t매출");
		System.out.println(dto.getdDate() + "\t" + dto.getDayIncome());
	}

	// 월별매출
	void M_dayrecord(String date) {
		dayrecordDTO dto = conAd.M_daysales(date);
		System.out.println("월별매출\n");
		System.out.println(date + " : " + dto.getDayIncome());
	}

	// 회원검색
	void memberSearch(String search) {
		membersDTO dto = conAd.memberSearch(search);
		System.out.println("회원정보\n");
		System.out.println("회원번호 :" + dto.getMemNo() + "\n" + "회원이름 :" + dto.getMemID() + "\n" + "회원비밀번호 :"
				+ dto.getMemPW() + "\n" + "회원전화번호 :" + dto.getMemPhone() + "\n" + "회원잔여시간 :" + dto.getMemTime());
	}

	//요금제 추가 
	void inputPrice(int money , int time) {
		boolean result = conAd.inputPrice(money, time);
		System.out.println("요금등록성공");
		if(result==false) {System.out.println("실패");}	
	}
	
	//요금제 삭제 
	
	
	
	
	
	
	
	
	
}// class E