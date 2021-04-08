package libraryMethod;

import java.util.ArrayList;
import java.util.Scanner;

class books{
	String name;
	int code;
	String artist;
}
//
public class Main {
	
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<books> arr = new ArrayList<books>();
	public static boolean[] check;
	
	public static void main(String[] args) {
		
		books a  = new books();
		books b  = new books();
		books c  = new books();
		books d  = new books();
		a.name = "어린왕자";
		a.code = 0;
		a.artist = "여우";
		arr.add(a);
		b.name = "삼국지";
		b.code = 1;
		b.artist = "제갈량";
		arr.add(b);
		c.name = "정보처리";
		c.code = 2;
		c.artist = "산업공단";
		arr.add(c);
		d.name = "공업수학";
		d.code = 3;
		d.artist = "공대";
		arr.add(d);
		check = new boolean[arr.size()];
		
		while(true) {
			printmenu();
			
			int input = scan.nextInt();
			
			if(input > 0 && input < 6) {
				if(input == 1) {
					printbook();
				}
				else if(input == 2) {
					indexbook();
				}
				else if(input == 3) {
					intsertbook();	
				}
				else if(input == 4) {
					deletebook();
				}
				else if(input == 5) {
					break;
				}
			}
			else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		
		System.out.println("프로그램이 종료되었습니다.");
		
		
	}
	
	private static void printmenu() {
		System.out.println("--------------------------");
		System.out.println("안녕하세요. OO도서관입니다.");
		System.out.println("1.도서목록 확인");
		System.out.println("2.도서검색");
		System.out.println("3.신규도서 추가");
		System.out.println("4.기존도서 삭제");
		System.out.println("5.종료");
		System.out.println("원하시는 메뉴를 선택해주세요.");
		
	}
	
	private static void printbook() {
		System.out.println("--------------------------");
		for(int i = 0; i < arr.size(); i++) {
			System.out.println("책이름: " + arr.get(i).name + "코드: " + arr.get(i).code + "저자: "+ arr.get(i).artist);
		}
		
	}

	private static void indexbook() {
		System.out.println("--------------------------");
		System.out.println("책이름을 입력하세요.");
		String s = scan.next();
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).name.equals(s)) {
				if(!check[i]) {
					System.out.println(arr.get(i).name + "은 대출이 가능합니다.");
					borrow(i);
				}
				else {
					System.out.println(arr.get(i).name + "은 대출이 불가능합니다.");
					unborrow(i);
				}
				break;
			}
		}
	}
	
	private static void borrow(int x) {
		System.out.println("검색하신 책을 대출하시겠습니까? (y / n)");
		String s = scan.next();
		if(s.equals("y")) {
			check[x] = true;
			System.out.println("대출이 완료되었습니다.");
		}
		else if(s.equals("n")) {
			System.out.println("대출이 취소되었습니다.");
		}
		else {
			System.out.println("잘못입력하셨습니다.");
			borrow(x);
		}
	}
	
	private static void unborrow(int x) {
		System.out.println("검색하신 책을 반납하시겠습니까? (y / n)");
		String s = scan.next();
		if(s.equals("y")) {
			check[x] = false;
			System.out.println("반납이 완료되었습니다.");
		}
		else if(s.equals("n")) {
			System.out.println("반납이 취소되었습니다.");
		}
		else {
			System.out.println("잘못입력하셨습니다.");
			borrow(x);
		}
	}

	private static void intsertbook() {
		System.out.println("--------------------------");
		books newbook = new books();
		System.out.println("추가할 책의 정보를 입력하세요");
		System.out.println("책이름:");
		newbook.name = scan.next();
		System.out.println("코드:");
		newbook.code = scan.nextInt();
		System.out.println("저자:");
		newbook.artist = scan.next();
		arr.add(newbook);
	}

	private static void deletebook() {
		System.out.println("--------------------------");
		System.out.println("삭제할 책이름을 입력하세요.");
		String s = scan.next();
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).name.equals(s)) {
				arr.remove(i);
				break;
			}
		}
	}

}
