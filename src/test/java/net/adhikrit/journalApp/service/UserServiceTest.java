package net.adhikrit.journalApp.service;

import net.adhikrit.journalApp.entity.User;
import net.adhikrit.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Used to specify to start the application context while running the test
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach // Used to run the method before each test
    void setUp(){

    }

    @BeforeAll // Used to run the method before all the tests
    static void init(){

    }

    @AfterEach // Used to run the method after each test
    void tearDown(){

    }

    @AfterAll // Used to run the method after all the tests
    static void destroy(){

    }

    @ParameterizedTest
//    @ValueSource(strings = {
//            "ram",
//            "shyam",
//            "ghanshyam"
//    })
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
//        assertEquals(4, 2+2);
//        assertNotNull( userRepository.findByUsername(name), "failed for: " + name);
//        assertTrue(5>3);
        assertTrue(userService.saveNewUser(user));
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "shyam",
            "ghanshyam"
    })
//    @ArgumentsSource(UserArgumentsProvider.class)
    public void testFindByUsername(String name){
//        assertEquals(4, 2+2);
        assertNotNull( userRepository.findByUsername(name), "failed for: " + name);
//        assertTrue(5>3);
//        assertTrue(userService.saveNewUser(user));
    }

    @Disabled
    @Test
    public void testFindUserEntries(){
        User user = userRepository.findByUsername("ram");
        assertTrue(user.getJournalEntries().isEmpty());
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected){

        assertEquals(expected, a + b);
    }
}
