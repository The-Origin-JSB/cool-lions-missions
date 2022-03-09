package tis.springcommunityproject.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import tis.springcommunityproject.api.community.CommunityController;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommunityControllerTest {

	MockMvc mockMvc;

	@Autowired
	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@Test
	void createPost() throws Exception {
		ResultActions result = mockMvc.perform(
			post("/community/{boardId}/post", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
					"        \"title\": \"test title board\",\n" +
					"        \"content\": \"test content board\"\n" +
									"}")
		);
		result.andDo(print())
			.andExpect(status().isOk())
			.andExpect(handler().handlerType(CommunityController.class))
			.andExpect(handler().methodName("createPost"))
			.andExpect(jsonPath("$.success", is(true)))
			.andExpect(jsonPath("$.response.title", is("test title board")))
			.andExpect(jsonPath("$.response.content", is("test content board")))
			.andExpect(jsonPath("$.response.user").exists())
			.andExpect(jsonPath("$.response.createAt").exists())
		;
	}
}