package kr.co.test;

import java.util.Scanner;

import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.config.RootConfig;
import kr.co.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class Test {

	@Autowired
	private TestMapper testMapper;

//	@org.junit.Test
	public void test() {
		System.out.println("test success");		
	}

//	@org.junit.Test
	public void testSearch(){		
		Scanner san = new Scanner(System.in);
		String str = san.nextLine();
		boolean a = testMapper.selectName(str);
		System.out.println("a : "+a);		
	}
	
//	@org.junit.Test
//	public void test1() {
//		BCrypt bCryPt = null;
//		Scanner scan = new Scanner(System.in);
//		String str = scan.nextLine();
//		String id = scan.nextLine();
//		String pw2 = bCryPt.hashpw(str, BCrypt.gensalt());
//		System.out.println("pw2 : "+pw2);
//		testMapper.insertId(id, pw2);
//		System.out.println("success!");
//	}
}
