package pcRoom;

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		
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
			}else if(ch==5){
				// 시간충전_신지웅
			}			
		}
		
	}
}
