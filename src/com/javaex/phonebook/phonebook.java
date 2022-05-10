//리스트 등록 삭제 검색 종료
package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class phonebook {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		List<Person> pList = new ArrayList<Person>();
		BufferedReader isr = new BufferedReader(isr);

		while (true) {
			String str = isr.readLine();
			if (str == null) {
				break;
			}

			String[] data = str.split(",");

			String name = data[0];
			String hp = data[1];
			String company = data[2];

			Person person = new Person(name, hp, company);

			pList.add(person);

		}
		// 초기값
		int now = 0;
		String inputLine;
		String[] inputArray;

		// 초기화면
		while (true) {
			System.out.println("");
			System.out.println("************************");
			System.out.println("*      전화번호 관리 프로그램      *");
			System.out.println("************************");

			System.out.println("");
			System.out.println(" 1.리스트 | 2.등록 | 3.삭제 | 4.검색 | 5.종료");
			System.out.println("----------------------------------");
			System.out.println("> 메뉴번호 : ");
			int n = sc.nextInt();

			if (n == 5) {
				System.out.println("종료되었습니다.");
				break;

				// 리스트 프로그램 시작
			} else if (n == 1) {
				System.out.println("< 리스트 >");
				System.out.println("");
				List<Person> personList = new ArrayList<Person>();

				// 읽기스트림
				Reader fr = new FileReader("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt");
				
				
				// text파일을 1줄씩 읽어서 리스트에 추가
				while (true) {
					String str = isr.readLine();

					if (str == null) {
						break;
					}

					String[] personInfo = str.split(" ");

					String name = personInfo[0];
					String hp = personInfo[1];
					String company = personInfo[2];

					Person person = new Person(name, hp, company);

					personList.add(person);
				}

				// 출력하기
				for (Person person : personList) {
					System.out.println("이름: " + person.getName());
					System.out.println("핸드폰: " + person.getHp());
					System.out.println("회사: " + person.getCompany());
					System.out.println("");
				}

				isr.close();

				// 등록 프로그램 시작
			} else if (n == 2) {
				System.out.println("새 연락처를 등록하세요.");
				String plus = sc.nextLine();

				for (int i = 0; i <= 1; i++) {
					inputLine = sc.nextLine();
					inputArray = inputLine.split(" ");
				}
				System.out.println("등록되었습니다.");

				// 삭제 프로그램 시작
			} else if (n == 3) {
				System.out.println("삭제할 연락처의 번호를 입력하세요");
				String minus = sc.nextLine();

				for (int i = 0; i <= 1; i++) {
					inputLine = sc.nextLine();
					inputArray = inputLine.split(" ");
				}
				System.out.println("삭제되었습니다.");
			}

			// 검색 프로그램 시작

		}
		sc.close();
	}
}
