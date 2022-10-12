package aju.querydsl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuerydslApplicationTests {

	@Test
	void 테스트() {
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
}
