package Dao;
//Data Access Object : 데이터를 취급하는 클래스

import java.util.Scanner;

import Dto.StudentDto;

public class StudentDao {
	Scanner sc = new Scanner(System.in);
		
		// 학생 데이터 관리 배열
        private StudentDto student[];
        
        private int count;
        
		// 추가, 삭제, 검색, 수정 (CRUD)
        public StudentDao() {
        	count = 0;
        	
        	student = new StudentDto[10];       // 변수만 생성, 객체 생성 안됨.
        	// studentDto student1, student2, ...;
        	
        	// dto를 생성
        	// for (int i = 0; i < student.length; i++) {
        	// 	student[i] = new StudentDto();
        	// }
        }
		
		public void insert() {
			System.out.println("학생 정보 입력입니다");

			System.out.print("이름 >> ");
			String name = sc.next();

			System.out.print("나이 >> ");
			int age = sc.nextInt();

			System.out.print("신장 >> ");
			double height = sc.nextDouble();

			System.out.print("주소 >> ");
			String address = sc.next();

			System.out.print("국어 >> ");
			int kor = sc.nextInt();

			System.out.print("영어 >> ");
			int eng = sc.nextInt();

			System.out.print("수학 >> ");
			int math = sc.nextInt();
			
			student[count] = new StudentDto(name, age, height, address, kor, eng, math);
			count++;     // 배열의 다음으로 이동하기 위해서
		}
		
		public void delete() {
			System.out.println("삭제하고 싶은 학생의 이름 >> ");
			String name = sc.next();
			
			int index = search(name);
			
			if(index == -1) {
				System.out.println("학생 정보를 찾을 수 없습니다.");
			return;
				
		}
		
	    // 국어, 영어, 수학 점수 수정
			System.out.println("수정할 데이터를 찾았습니다.");
			
			System.out.println("국어 >> ");
			int kor = sc.nextInt();
			
			System.out.println("영어 >> ");
			int eng = sc.nextInt();
			
			System.out.println("수학 >> ");
			int math = sc.nextInt();
			
			student[index].setKor(kor);
			student[index].setKor(eng);
			student[index].setKor(math);
			
			System.out.println("성공적으로 수정되었습니다.");
		
			
		student[index].setName(" ");
		student[index].setAge(0);
		student[index].setHeight(0.0);
		student[index].setAddress(" ");
		student[index].setKor(0);
		student[index].setEng(0);
		student[index].setMath(0);

	    System.out.println(name + "학생의 데이터를 삭제하였습니다");
	    }


		public void select() {
			System.out.print("검색하고 싶은 학생의 이름 >> ");
			String name = sc.next();
			
			for(int i = 0; i < student.length; i++) {
				StudentDto dto = student[i];
				if(dto != null & dto.getName().equals(" ")== false) {
					if(name.equals(dto.getName())) {
					dto.print();
					}
				
				}
			}
		}
		public void update() {
			System.out.print("수정하고 싶은 학생의 이름 >> ");
			String name = sc.next();
			
			int index = search(name);
			
			if(index == -1)
				System.out.println("학생정보를 찾을 수 없습니다.");
			    return;
		}
		
		public int search(String name) {
			int index = -1;
			for(int i = 0; i < student.length; i++) {
				StudentDto dto = student[i];
				if(dto != null) {
					if(name.equals(dto.getName()));     // 찾았다.
					index = i;
					break;
				}
			} 
			return index;
		}
		
		public void allData() {
              for(int i = 0; i < student.length; i++) {
              StudentDto dto = student[i];
              if(dto != null) {
            	  System.out.println(dto.toString());
            	  
              }
            }
		}

}











