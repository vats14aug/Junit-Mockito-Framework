package com.example.demo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")

public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
   @Before
    public void setUp() throws Exception {
        User user1= new User("Alice", 23);
        User user2= new User("Bob", 38);
       
        this.userRepository.save(user1);
        this.userRepository.save(user2);
        assertNotNull(user1.getId());
        assertNotNull(user2.getId());
    }
    
    @Test
    public void testfindUserNameById(){
      assertEquals(userService.findUserNameById(1), "Alice");
      
    }
    
    @Test
    public void testAddUser(){
    	User user= new User("Test User1", 38);
    	userService.addUser(user);
        assertEquals(userService.findUserNameById(3), "Test User1");

    }
    
    @Test
    public void testDeleteUser(){
    	userService.deleteUser(3);
    	System.out.println("user deleted successfully!!");
    	assertNull(userService.findByID(3));


    }
}
