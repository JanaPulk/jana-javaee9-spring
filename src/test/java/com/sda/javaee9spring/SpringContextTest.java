package com.sda.javaee9spring;


import com.sda.javaee9spring.component.MyFirstSpringComponent;
import com.sda.javaee9spring.component.SecondComponent;
import com.sda.javaee9spring.controller.FirstController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpringContextTest {
    @Autowired
    private FirstController myFirstController;

    @Test
    void checkFirstControllerReference() {
        assertNotNull(myFirstController);
        String firstPageName = myFirstController.firstPage();
        assertEquals("home-page", firstPageName);
    }

    @Autowired
    private MyFirstSpringComponent mmyFirstSpringComponent;

    @Autowired
    private MyFirstSpringComponent myFirstSpringComponentSecondReference;

    @Test
    void checkMyFirstSpringComponentRef(){
        assertNotNull(mmyFirstSpringComponent);

    }

    @Test
    void manyObjectsOfTheSameTypeTest(){
        // == - checks if two references points to the same object
        //by default every bean inside Spring Context is singleton
        assertSame(mmyFirstSpringComponent, myFirstSpringComponentSecondReference);
    }

    @Autowired
    SecondComponent secondComponent;
    SecondComponent mySecondComponent;

    @Test
    void  checkMySecondSpringComponent(){
        assertNotSame(secondComponent, mySecondComponent);
    }

}
