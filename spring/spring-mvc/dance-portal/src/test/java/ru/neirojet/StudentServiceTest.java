package ru.neirojet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.neirojet.controllers.IndexController;
import ru.neirojet.service.StudentService;

/**
 * Created by icetusk on 29.07.16.
 */
public class StudentServiceTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private IndexController indexController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentService).build();
    }

    @Test
    public void testList() throws Exception  {
        
    }


}
