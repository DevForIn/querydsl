package aju.querydsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import aju.querydsl.dto.UserDto;
import aju.querydsl.entity.Company;
import aju.querydsl.entity.User;
import aju.querydsl.service.MainServiceImpl;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	private MainServiceImpl mainService;
	private final Gson gson = new Gson();
	
	@Autowired
	public UserController(MainServiceImpl mainService) {
		this.mainService = mainService;
	}

	// User List Read
	@GetMapping("/users")
	public List<User> userList() {
		return mainService.findAll();

	}

	// User 해당 ID로 조회
	@GetMapping("/users/{id}")
	public String getUser(@PathVariable Long id) {
		log.debug("test");
		log.debug("test");
		log.info("test");
		log.info("test");
		log.info("-----------------getUser !!!!!! -----------------");
		User user = mainService.findById(id);
		String userJson = gson.toJson(user);
		// {"companyId":2,"companyName":"COGNET9"}
//		String queryTimeout = "[14:08:59.327] [http-nio-8080-exec-8] [INFO] | c.d.irestapi.controller.ChatController:REST-MESSAGEIOUT-sessionld:c7b9d0a66354 | query : timeout | nextinputTypeCd:01 | NextinputLength:0 | ivrCalldata : 325256843401      1111     | bargelnAcpYn : | consultGrupCd : | ansUtter(10-letter) :  | preTime : 0.086 | mciSvcLogList : null | speakerAnalysisYn : | pressRsultDstic : 0 |";
//		
//		String query1234 = "[14:08:59.327] [http-nio-8080-exec-8] [INFO] | c.d.irestapi.controller.ChatController:REST-MESSAGEIOUT-sessionld:c7b9d0a66354 | query : 1234 | nextinputTypeCd:01 | NextinputLength:0 | ivrCalldata : 325256843401      1111     | bargelnAcpYn : ";
//		String query123 = "[14:08:59.327] [http-nio-8080-exec-8] [INFO] | c.d.irestapi.controller.ChatController:REST-MESSAGEIOUT-sessionld:c7b9d0a66354 | query : 567 | nextinputTypeCd:01 | NextinputLength:0 | ivrCalldata : 325256843401      1111     | bargelnAcpYn : ";
//		String query12 = "[14:08:59.327] [http-nio-8080-exec-8] [INFO] | c.d.irestapi.controller.ChatController:REST-MESSAGEIOUT-sessionld:c7b9d0a66354 | query : 89 | nextinputTypeCd:01 | NextinputLength:0 | ivrCalldata : 325256843401      1111     | bargelnAcpYn : | ";
//		
//		String ivrNull = "[14:08:59.327] [http-nio-8080-exec-8] [INFO] | c.d.irestapi.controller.ChatController:REST-MESSAGEIOUT-sessionld:c7b9d0a66354 | query : 1234 | nextinputTypeCd:01 | NextinputLength:0 | ivrCalldata :  | bargelnAcpYn : ";
//		String ivr1 = "[14:08:59.327] [http-nio-8080-exec-8] [INFO] | c.d.irestapi.controller.ChatController:REST-MESSAGEIOUT-sessionld:c7b9d0a66354 | query : 1234 | nextinputTypeCd:01 | NextinputLength:0 | ivrCalldata : 1 | bargelnAcpYn : ";
		
		String queryPattern = "{\"userId\":1,\"userName\":\"test\",\"userEmail\":\"jji@aju.co.kr\",\"ivrCalldata\":\"325256843401      1111    \",\"query\":\"1234\"}";
		String testMaksing = "{\"phoneNumber\":\"01012345678\", phoneNumber=01012345678, ivrCalldata=1205981     1111    )";
		String testMaksing2 = "{\"ivrCalldata\":\"12412421    1231       \",ivrCalldata=1205981     1111     , phoneNumber=1205981)";
		String testMaksing3 = "{\"addtnlInfoVal=^0000000001^2523512352350^01 종합위탁 박세미^^20221128^^^4&2^^^735125^1251251259125^^235235325^01^Prime센터(비대면)^^^^00127^^^^)";
		String testMaksing4 = "{\"addtnlInfoVal=^0000000001^2523512352350^01 종합위탁 박세미^^20221128^^^4&2^^^735125^1251251259125^^235235325^01^Prime센터(비대면)^^^^00127^^^^, test=12123^123)";
		String testMaksing5 = "{\"addtnlInfoVal=^0000000001^2523512352350^01 종합위탁 박세미^^20221128^^^4&2^^^735125^1251251259125^^235235325^01^^^^^00127^^^^)";
		String testMaksing6 = "{\"addtnlInfoVal=^0000000001^2523512352350^01 종합위탁 박세미^^20221128^^^4&2^^^735125^1251251259125^^235235325^01^^^^^00127^^^^, test=12123^123)";
		
//		log.info("getUser to userJson ---->>>> "+userJson.toString());
//		log.info("queryTimeout ---->>>> "+queryTimeout);
//		log.info("query1234 ---->>>> "+query1234);
//		log.info("query1233 ---->>>> "+query123);
//		log.info("query12 ---->>>> "+query12); 
//		log.info(" ");
//		log.info("ivrNull ---->>>> "+ivrNull);
//		log.info("ivr1 ---->>>> "+ivr1);
		System.out.println("test queryPattern " + queryPattern);
		log.info("queryPattern ---->>>> "+queryPattern);
		log.info("-----------------another Pattern--------------------");
		System.out.println("test testMaksing " + testMaksing);
		log.info("testMaksing ---->>>> "+testMaksing);
		System.out.println("test testMaksing2 " + testMaksing2);
		log.info("testMaksing2 ---->>>> "+testMaksing2);
		System.out.println("test testMaksing3 " + testMaksing3);
		log.info("testMaksing3 ---->>>> "+testMaksing3);
		System.out.println("test testMaksing4 " + testMaksing4);
		log.info("testMaksing4 ---->>>> "+testMaksing4);
		System.out.println("test testMaksing5 " + testMaksing5);
		log.info("testMaksing5 ---->>>> "+testMaksing5);
		System.out.println("test testMaksing6 " + testMaksing6);
		log.info("testMaksing6 ---->>>> "+testMaksing6);
		log.info("----------------------------------------------------");
		return userJson;		
	}

	// User 생성	
	@PostMapping("/users")
	public ResponseEntity<?> insertUser(UserDto userDto) {
		mainService.saveUser(userDto);
		return ResponseEntity.ok().body(userDto);
	}

	// User 해당 ID의 테이블 수정
	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable Long id, UserDto userDto) {
		mainService.updateById(id, userDto);
	}

	// User 해당 ID 삭제 테이블
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		mainService.deleteById(id);
	}
}