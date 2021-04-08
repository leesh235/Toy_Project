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
		a.name = "�����";
		a.code = 0;
		a.artist = "����";
		arr.add(a);
		b.name = "�ﱹ��";
		b.code = 1;
		b.artist = "������";
		arr.add(b);
		c.name = "����ó��";
		c.code = 2;
		c.artist = "�������";
		arr.add(c);
		d.name = "��������";
		d.code = 3;
		d.artist = "����";
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
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
		
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
		
		
	}
	
	private static void printmenu() {
		System.out.println("--------------------------");
		System.out.println("�ȳ��ϼ���. OO�������Դϴ�.");
		System.out.println("1.������� Ȯ��");
		System.out.println("2.�����˻�");
		System.out.println("3.�űԵ��� �߰�");
		System.out.println("4.�������� ����");
		System.out.println("5.����");
		System.out.println("���Ͻô� �޴��� �������ּ���.");
		
	}
	
	private static void printbook() {
		System.out.println("--------------------------");
		for(int i = 0; i < arr.size(); i++) {
			System.out.println("å�̸�: " + arr.get(i).name + "�ڵ�: " + arr.get(i).code + "����: "+ arr.get(i).artist);
		}
		
	}

	private static void indexbook() {
		System.out.println("--------------------------");
		System.out.println("å�̸��� �Է��ϼ���.");
		String s = scan.next();
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).name.equals(s)) {
				if(!check[i]) {
					System.out.println(arr.get(i).name + "�� ������ �����մϴ�.");
					borrow(i);
				}
				else {
					System.out.println(arr.get(i).name + "�� ������ �Ұ����մϴ�.");
					unborrow(i);
				}
				break;
			}
		}
	}
	
	private static void borrow(int x) {
		System.out.println("�˻��Ͻ� å�� �����Ͻðڽ��ϱ�? (y / n)");
		String s = scan.next();
		if(s.equals("y")) {
			check[x] = true;
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}
		else if(s.equals("n")) {
			System.out.println("������ ��ҵǾ����ϴ�.");
		}
		else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
			borrow(x);
		}
	}
	
	private static void unborrow(int x) {
		System.out.println("�˻��Ͻ� å�� �ݳ��Ͻðڽ��ϱ�? (y / n)");
		String s = scan.next();
		if(s.equals("y")) {
			check[x] = false;
			System.out.println("�ݳ��� �Ϸ�Ǿ����ϴ�.");
		}
		else if(s.equals("n")) {
			System.out.println("�ݳ��� ��ҵǾ����ϴ�.");
		}
		else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
			borrow(x);
		}
	}

	private static void intsertbook() {
		System.out.println("--------------------------");
		books newbook = new books();
		System.out.println("�߰��� å�� ������ �Է��ϼ���");
		System.out.println("å�̸�:");
		newbook.name = scan.next();
		System.out.println("�ڵ�:");
		newbook.code = scan.nextInt();
		System.out.println("����:");
		newbook.artist = scan.next();
		arr.add(newbook);
	}

	private static void deletebook() {
		System.out.println("--------------------------");
		System.out.println("������ å�̸��� �Է��ϼ���.");
		String s = scan.next();
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).name.equals(s)) {
				arr.remove(i);
				break;
			}
		}
	}

}
