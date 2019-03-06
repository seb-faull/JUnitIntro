import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Options204 extends BaseClass {

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeEach
    public void setUp() {
        client = HttpClientBuilder.create().build();
    }

    @AfterEach
    public void closeResources() throws IOException {
        client.close();
        // response.close();
    }

    @Test
    public void optionsReturnsCorrectMethodsList() throws IOException {

        String header = "Access-Control-Allow-Methods";
        String expectedReply = "GET, POST, PATCH, PUT, DELETE";

        HttpOptions request = new HttpOptions(BASE_ENDPOINT);
        response = client.execute(request);

        //String actualValue = ResponseUtils.getHeader(response, header);
        String actualValue = ResponseUtils.getHeaderJava8Way(response, header);

        assertEquals(actualValue, expectedReply);

    }
}