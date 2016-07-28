package ru.windwail;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExploreJUnitTest {

    @Mock
    MyServiceImpl service;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class.");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class.");
    }

    @Before
    public void setUp() {
        System.out.println("Set up everything.");
    }

    @Test
    public void myTest() {
        System.out.println("myTest "+service.getCost());

    }

    @Test
    public void anotherTest() {
        System.out.println("anotherTest");
    }

    @After
    public void tearDown() {
        System.out.println("Tear down everything.");
    }
}
