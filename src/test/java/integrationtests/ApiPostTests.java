package integrationtests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanfak.springbootvuedemo.core.domain.Blog;
import com.hanfak.springbootvuedemo.core.usecase.GetAllBlogPostsUsecase;
import com.hanfak.springbootvuedemo.core.usecase.GetBlogPostsUsecase;
import com.hanfak.springbootvuedemo.entrypoints.rest.BlogSearchEndPoint;
import org.assertj.core.api.WithAssertions;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static com.cedarsoftware.util.io.JsonWriter.formatJson;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class ApiPostTests extends YatspecTest implements WithAssertions {

    private MockMvc mockMvc;
    private String responseContent;
    private int responseStatusCode;

    private GetBlogPostsUsecase getBlogPostsUsecase = Mockito.mock(GetBlogPostsUsecase.class);
    private GetAllBlogPostsUsecase getAllBlogPostsUsecase = Mockito.mock(GetAllBlogPostsUsecase.class);

    @Before
    public void setUp() throws Exception {
        initialiseEndpoint();
    }

    @Test
    public void shouldReturnJson() throws Exception {
        givenPostsExists();

        whenAllBlogPostsAreRequested();

        thenReturn200();
        andTheDetailsAreReturned();
    }

    private void givenPostsExists() {
        when(getAllBlogPostsUsecase.fetchAllBlogPosts())
                .thenReturn(Arrays.asList(new Blog("first post", "Blah blah Blah blah Blah blah Blah blah ", 1),
                        new Blog("second post", "boo booo boo boooo ", 2)));
    }

    private void andTheDetailsAreReturned() throws JSONException {
        log("Response: Content", formatJson(responseContent));

        String expectedResponse =
                "[\n" +
                        "{\n" +
                        "\"title\":\"first post\",\n" +
                        "\"body\":\"Blah blah Blah blah Blah blah Blah blah \",\n" +
                        "\"id\":1\n" +
                        "},\n" +
                        "{\n" +
                        "\"title\":\"second post\",\n" +
                        "\"body\":\"boo booo boo boooo \",\n" +
                        "\"id\":2\n" +
                        "}\n" +
                        "]";
        JSONAssert.assertEquals(expectedResponse, responseContent, false);

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Blog>>(){}.getType();
        List<Blog> blogs = gson.fromJson(responseContent,listType);
        System.out.println("***************************************");
        System.out.println(blogs.get(1).getTitle());
        System.out.println("***************************************");
        assertThat(blogs).hasSize(2);
    }

    private void thenReturn200() {
        assertThat(responseStatusCode).isEqualTo(200);
    }

    private void whenAllBlogPostsAreRequested() throws Exception {
        log("Request Path", BlogSearchEndPoint.API_PATH);
        MvcResult mvcResult = mockMvc.perform(get(BlogSearchEndPoint.API_PATH)).andReturn();
        responseContent = mvcResult.getResponse().getContentAsString();
        responseStatusCode = mvcResult.getResponse().getStatus();
        log("Response: Status Code", responseStatusCode);
    }

    private void initialiseEndpoint() {
        mockMvc = MockMvcBuilders.standaloneSetup(new BlogSearchEndPoint(getAllBlogPostsUsecase, getBlogPostsUsecase)).build();
    }

}
