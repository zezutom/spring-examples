package org.zezutom.springseries0114.part04.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zezutom.springseries0114.part04.conf.AppConfig;
import org.zezutom.springseries0114.part04.model.Message;
import org.zezutom.springseries0114.part04.web.ComponentController;
import org.zezutom.springseries0114.part04.web.ServiceController;
import org.zezutom.springseries0114.part04.web.WebController;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class ControllerTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ComponentController componentController;

    @Autowired
    private ServiceController serviceController;

    @Autowired
    private WebController webController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void webMessage() {
        assertMessage("/web/message", webController.message());
    }

    @Test
    public void serviceMessage() {
        assertMessage("/service/message", serviceController.message());
    }

    @Test
    public void componentMessage() {
        assertMessage("/component/message", componentController.message());
    }

    private void assertMessage(String url, Message expectedMessage) {
        try {
            MvcResult result = mockMvc.perform(get(url))
                    .andExpect(status().isOk())
                    .andReturn();

            MockHttpServletResponse response = result.getResponse();

            assertNotNull(response);
            assertThat(response.getContentAsString(),
                    is("{\"title\":\"" + expectedMessage.getTitle() + "\",\"text\":\"" + expectedMessage.getText() + "\"}"));
        }
        catch (Exception ex) {
            fail(ex.getMessage());
        }

    }
}
