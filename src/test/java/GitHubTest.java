import Rest.Controler.GetController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by bartosz.zielinski on 2017-02-20.
 */
public class GitHubTest {

    private MockMvc mockMvc;
    GetController getController = new GetController();

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController).build();
    }

    @Test
    public void testGitHub() throws Exception {
        mockMvc.perform(get("/repositories/{owner}/{repositoryname}","Zielina","whmcs_payu")).andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("Zielina/whmcs_payu"));
    }
}
