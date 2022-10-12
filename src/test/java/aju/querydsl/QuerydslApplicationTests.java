package aju.querydsl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aju.querydsl.entity.User;
import aju.querydsl.repository.UserRepository;
import aju.querydsl.service.MainServiceImpl;

@SpringBootTest
class QuerydslApplicationTests {

	@Autowired
	MainServiceImpl msi;
	
	@Test
	void 테스트Assert() {
		System.out.println("test");
		boolean test = true;
		int a = 5;
		// 같은 값인지 판별
		Assertions.assertEquals(a, 5, () -> "a != 5 확인 필요..");

		// 같은 값이 아닌지 판별
		Assertions.assertNotEquals(a, 1, () -> "a == 5  확인 필요..");
		// 동시에 여러 판별 가능 
		Assertions.assertAll(
				() -> assertEquals(test, true, () -> "test != ture. 확인필요"),
				() -> assertNotEquals(a, 3, () -> "a == a. 확인필요")				
				);
	}
	
	@Test
	void 회원검색() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요.");
		
		Long id = sc.nextLong();
		
		User result = msi.findById(id);
		
		System.out.println("------------------------");
        if(!result.equals(null)){
            System.out.println(result);
        }		
	}
}
