//리스트 등록 삭제 검색 종료
package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class phonebook {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		List<Person> pList = new ArrayList<Person>();
		InputStream in = new FileInputStream("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		while (true) {
			String str = br.readLine();
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
		//int now = 0;
		//String inputLine;
		//String[] inputArray;
		

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

			
			// 종료
			if (n == 5) {
				System.out.println("***********************");
				System.out.println("*     종료되었습니다.     *");
				System.out.println("***********************");
				break;

				
			// 리스트 프로그램 시작
			} else if (n == 1) {
				System.out.println("< 리스트 >");
				System.out.println("");
				//List<Person> personList = new ArrayList<Person>();

				
				// 출력하기
				int i = 1;
				for (Person person : pList) {
					System.out.println((i) + ". \t" + person.getName() + "\t" + person.getHp() + "\t" + person.getCompany());
					i++;
				}

				
				// 등록 프로그램 시작
			} else if (n == 2) {
				
				// 읽기스트림
				Writer fw = new FileWriter("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);

				System.out.println("<2. 등록>");
				System.out.println(">이름 : ");
				String name = sc.next();

				System.out.println(">휴대전화 : ");
				String hp = sc.next();

				System.out.println(">회사전화 : ");
				String company = sc.next();

				Person newperson = new Person(name , hp ,company);
				pList.add(newperson);
				
				for (Person person: pList) {
					//inputLine = sc.nextLine();
					//inputArray = inputLine.split(" ");
					
					String plus = person.getName() + "," +person.getHp() +","+person.getCompany();
					
					bw.write(plus);
					bw.newLine();
					
				}
				System.out.println("등록되었습니다.");
				bw.flush();
				

				// 삭제 프로그램 시작
			} else if (n == 3) {
				System.out.println("<3. 삭제>");
				System.out.println("> 번호 : ");
				int minus = sc.nextInt() - 1;
				pList.remove(minus);

				System.out.println("삭제되었습니다.");
				
				
				//검색 프로그램 시작
			} else if (n ==4) {
				System.out.println("<4.검색>");
				System.out.println(">이름 : ");
				String  serch = sc.next();
				
				for (Person person : pList) {
					if(person.getName().contains(serch))
					System.out.println(person.toString());
				}
				
			//없는메뉴
			} else {
				 System.out.println("[다시 입력해 주세요.]");

		}
		isr.close();
		sc.close();
			}
		}
	}
