package pcRoom.View;

import java.util.ArrayList;
import java.util.Scanner;
import pcRoom.Controller.KioskAdminController;
import pcRoom.Controller.KioskUserController;
import pcRoom.Model.DTO.dayrecordDTO;
import pcRoom.Model.DTO.membersDTO;
import pcRoom.Model.DTO.pcListDTO;
import pcRoom.Model.DTO.priceDTO;
import pcRoom.data.Printseat;

public class KioskUserView {

	KioskUserController con = new KioskUserController();
	KioskAdminController conAd = new KioskAdminController();

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
			} else if (start == 0 ) {
				if(print.isState()) {
					print.setState(false);
				}
				while (true) {
					System.out.println("============현 화면은 관리자모드 입니다============");
					System.out.println("1.매출확인 2.회원정보검색 3.좌석 선택 4.요금제 등록/삭제 5.돌아가기");
					int ch = scanner.nextInt();
					if (ch == 1) {
						while (true) {
							System.out.println("1.일일매출확인 2.월매출확인 3.돌아가기 ");
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
							else if(sale==3) {
								break;
							}
						} // while E
					} // if ch1 E
					if (ch == 2) {
						System.out.println("검색할 회원 아이디를 입력해주세요.");
						System.out.println("전 화면으로 돌아가시려면 뒤로가기라고 입력해주세요.");
						String search = scanner.next(); 
						if(search.equals("뒤로가기")) {continue;}
						view.memberSearch(search);
					}
					if (ch == 3) {
						System.out.println("확인할 자리의 번호를 입력해 주세요");
						System.out.println("전 화면으로 돌아가시려면 0번을 입력해주세요.");
						int num = scanner.nextInt();
						if(num==0) {continue;}
						view.Information(num);
					}
					if (ch == 4) {
						view.showPrice();
						System.out.println("1.요금제 등록 2.요금제 삭제 3.뒤로가기");
						int price = scanner.nextInt();
						if (price == 1) {
							System.out.println("입력할 요금을 입력하세요 ");
							int money = scanner.nextInt();
							System.out.println("입력한 요금에 시간을 입력해주세요");
							int time = scanner.nextInt();
							view.inputPrice(money, time);
						} else if (price == 2) {
							System.out.println("삭제할 요금제를 선택하세요");
							int price_num = scanner.nextInt();
							view.deletePrice(price_num);
						}else if( price==3) {
							continue;
						}
						else {
							System.out.println("선택할수 없는 항목입니다");
						} // else E
					} // if ch4 E
					if(ch==5) {
						break;
					}					
				}// 관리자 while end
				print.setState(true);
			} // else if (0) E
		} // 전체 while E
	} // main end
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
		System.out.println("날짜\t\t매출");
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

	// 요금제 출력
	void showPrice() {
		ArrayList<priceDTO> list = conAd.showPrice();
		System.out.println("========요금제 목록=======");
		System.out.println("번호\t요금\t시간");
		for (priceDTO dto : list) {
			System.out.print(dto.getPriceNo() + "\t" + dto.getPrice() + "\t" + dto.getHours() + "\n");
		}
		System.out.println("=======================");
	}

	// 좌석 정보 확인
	void Information(int num) {
		pcListDTO dto = conAd.Information(num);
		System.out.println("검색한 자리의 회원정보 입니다.");
		System.out.println("pcNo :" + dto.getPcNo() + "\n" + "사용여부 :" + dto.iscPlay() + "\n" + "회원번호 :" + dto.getMemNo()
				+ "\n" + "시작한시간 :" + dto.getsTime() + "\n" + "종료시간 :" + dto.geteTtime());

	}

	// 요금제 추가
	void inputPrice(int money, int time) {
		boolean result = conAd.inputPrice(money, time);
		System.out.println("요금등록성공");
		if (result == false) {
			System.out.println("요금제 등록에 실패했습니다.");
		}
	}
	// 요금제 삭제
	void deletePrice(int price_num) {
		boolean result = conAd.deletePrice(price_num);
		System.out.println("요금제 삭제 성공 ");
		if (result == false) {
			System.out.println("요금제 삭제에 실패했습니다.");
		}
	}
}// class E