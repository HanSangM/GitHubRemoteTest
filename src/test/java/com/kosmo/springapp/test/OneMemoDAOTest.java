package com.kosmo.springapp.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.impl.OneMemoDAO;

/*
1. pom.xml에 단위 테스트 관련 의존성 추가
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-test</artifactId>
		<version>${org.springframework-version}</version>
	</dependency>
	및 JUnit버전(4.7에서 4.12이상으로) 변경 즉
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.13.2</version>
		<scope>test</scope>		
	</dependency>

2.프로젝트에 JUnit라이브러리 추가
	프로젝트 마우스 우클릭->Build Path->Configue Build path
	-> Add Library에서 JUnit선택

3.테스트 클래스 생성:
	New ->other에서 JUnit으로 검색 ->Junit Test Case로 클래스 생성

	name : 단위 테스트 클래스명(테스트 대상 클래스명뒤에 Test를 붙인다)
	       예]OneMemoDAO가 테스트 대상이면 OneMemoDAOTest

	class under test : 테스트 대상인 클래스로 설정

4. 테스트 클래스 실행시 :Run As->JUnit Test로 실행

※JUnit은 각각의 테스트가 서로 영향을 주지 않고 독립적으로 실행되는 것이 원칙
 그래서 보통 Test 메소드 마다 필요한 객체를 생성하여 단위 테스트를 한다 
*/

@RunWith(SpringJUnit4ClassRunner.class)//JUnit 테스트 환경을 위한 테스트용 스프링 컨테이너 생성
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml"})
public class OneMemoDAOTest {
	
	
	@Autowired
	private OneMemoDAO dao;
	
	/*모든 테스트 메소드가 실행되기 전에 딱 한번만 호출되는 메소드*/
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}
	/*모든 테스트 메소드가 끝나고(실행되고나서) 딱 한번만 호출되는 메소드*/
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}
	/* 각 테스트 대상 메소드가 실행되기 전에 호출되는 메소드*/
	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}
	/* 각 테스트 대상 메소드가 실행된 후에 호출되는 메소드*/
	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}
	/*@Test 어노테이션:아래 메소드는 테스트 대상이되는
	메소드임을 컴파일러에게 알려주는  어노테이션
	테스트 메소드명: test대상메소드명
	접근지정자 :public
	반환타입:void
	인자는 없다	
	*/
	@Test
	public void test() {
		//fail("Not yet implemented");
		System.out.println("@Test");
	}
	@Test
	public void testIsLogin() {
		/*단정문:예상치와 실제치가 같다고 단정을 짓는다
    	        같으면 성공 틀리면 실패
   		예]assertEquals:가장 많이 쓰고 데이타가 같은지 비교
		 */
		Map map = new HashMap();
		map.put("id", "KIM");
		map.put("pwd", "1234");
		assertEquals(true, dao.isLogin(map));
	}//////////////
	@Test
	public void testSelectList() {
		
		int totalCount= dao.getTotalRowCount(null);
		Map map = new HashMap();
		map.put("start", 1);
		map.put("end", totalCount);		
		List<OneMemoDTO> lists= dao.selectList(map);
		
		//assertEquals(false, lists.isEmpty());
		//assertFalse(lists.isEmpty());
		assertEquals(totalCount, lists.size());
	}////////////////////
	@Test
	public void testInsert() {
		Map map = new HashMap();
		map.put("title","단위 테스트입니다");
		map.put("content","입력 테스트중 입니다");
		map.put("id", "KIM");
		assertEquals(1, dao.insert(map));
	}
	//존재하지 않는 PK입력 - 에러가 발생해야 정상
	@Test(expected = Exception.class)
	@Ignore/*아래 메소드는 테스트 대상이지만 테스트 안하겠다라는 의미*/
	public void testInsertError() {
		Map map = new HashMap();
		map.put("title","단위 테스트입니다");
		map.put("content","입력 테스트중 입니다");
		map.put("id", "NOID");
		dao.insert(map);
	}
	//객체의 주소 비교 단정문:assertSame()
	@Test
	public void testSame() {
		OneMemoDTO kosmo1 = OneMemoDTO.builder().name("한소인").build();
		OneMemoDTO kosmo2 = OneMemoDTO.builder().name("코스모").build();
		
		System.out.println(kosmo1 +":"+kosmo2);
		//assertSame(kosmo1, kosmo2);//Failue
		assertNotSame(kosmo1, kosmo2);//Success
	}////////////
	//배열에 저장된 데이타(값) 비교, 같으면 성공,다르면 실패
	@Test
	public void testArray() {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,5};
		assertArrayEquals(arr1, arr2);
		
	}
}
