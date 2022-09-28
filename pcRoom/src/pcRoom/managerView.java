package pcRoom;

import java.util.Scanner;

public class managerView {

	Controller con = new Controller();

	public static void main(String[] args) {
		managerView view = new managerView();

		Scanner scanner = new Scanner(System.in);
		// 매출관리 / 회원 정보 검색 / 좌석 선택 / 요금제 등록/삭제 /재고관리(보류)
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
				} // if sale1 E
				else if (sale == 2) {
					System.out.println("확인할 월을 입력해주세요");
					String date = scanner.next();
					view.M_dayrecord(date);
				} // if sale2 E
			}//while E
		} // if ch1 E

		if (ch == 2) {
			System.out.println("검색할 회원 아이디를 입력해주세요.");
		}
		if (ch == 3) {
		}
		if (ch == 4) {
		}

	}// main E

	// 일별매출
	void dayrecord(String date) {
		dayrecordDTO dto = con.daysales(date);
		System.out.println("날짜\t매출");
		System.out.println(dto.getdDate() + "\t" + dto.getDayIncome());
	}

	// 월별매출
	void M_dayrecord(String date) {
		dayrecordDTO dto = con.M_daysales(date);
		System.out.println("월별매출\n");
		System.out.println(dto.getdDate() + "\n" + dto.getDayIncome());
	}
}// class E
