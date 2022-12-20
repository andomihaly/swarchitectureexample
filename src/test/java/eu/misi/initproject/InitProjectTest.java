package eu.misi.initproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class InitProjectTest {

    private InitProject initProject;

    @BeforeEach
    void setUp() {
        initProject = new InitProject();
    }

    @Test
    void testPositiveTestResult(){
        assertTrue(initProject.positiveAnswer());
    }
    @Test
    void testNegativeTastResult(){
        assertEquals("InitProjectReady", initProject.basicString());
    }
    @Test
    void testException(){
        InitProjectException ex = assertThrows(InitProjectException.class, () ->initProject.generateException());
        assertEquals("Init Project Exception Message", ex.getFirstProperty());
    }
}