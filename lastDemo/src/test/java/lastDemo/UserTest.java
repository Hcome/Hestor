package lastDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heshouyang.entity.User;
import com.heshouyang.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/applicationContext.xml"})
public class UserTest {
	
	@Autowired
	private UserService us;
	
	@Test
	public void m1() {
		
		User user = us.selectUserById(1);
		System.out.println(user);
	}
	
}
