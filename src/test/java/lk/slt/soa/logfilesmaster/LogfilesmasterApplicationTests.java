package lk.slt.soa.logfilesmaster;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
////import static java.util.Collections.get;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
//import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
//import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
////import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class LogfilesmasterApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	public void loginWithValidUserThenAuthenticated() throws Exception{
//				SecurityMockMvcRequestBuilders.FormLoginRequestBuilder login = formLogin()
//				.user("user")
//				.password("password");
//
//		mockMvc.perform(login)
//				.andExpect(authenticated().withUsername("user"));
//
//	}
//
//	@Test
//	public void loginWithInvalidUserThenAuthenticated() throws Exception{
//		SecurityMockMvcRequestBuilders.FormLoginRequestBuilder login = formLogin()
//				.user("invalid")
//				.password("invalidpassword");
//
//		mockMvc.perform(login)
//				.andExpect(unauthenticated());
//
//	}

}


