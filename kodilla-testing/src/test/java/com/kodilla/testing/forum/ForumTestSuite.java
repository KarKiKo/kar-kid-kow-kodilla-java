package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.*;

public class ForumTestSuite {
    @Before
    public void before(){
        System.out.println("Test case: begin");
    }
    @After
    public void after(){
        System.out.println("Test case: after");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Test case: before class");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("Test case: after class");
    }
    @Test
    public void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Doe");
        //When
        String result = simpleUser.getUserName();
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals("theForumUser", result);
    }
    @Test
    public void testRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Doe");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals("John Doe", result);
    }
}
