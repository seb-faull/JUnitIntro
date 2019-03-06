import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Get200 extends BaseClass {

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
    public void baseUrlReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT);

        response = client.execute(get);

        int getStatusCode = response.getStatusLine().getStatusCode();

        assertEquals(getStatusCode, 200);

    }

    @Test
    public void rateLimitReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");

        response = client.execute(get);

        int getStatusCode = response.getStatusLine().getStatusCode();

        assertEquals(getStatusCode, 200);

    }

    @Test
    public void searchReposReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/search/repositories?q=java");

        response = client.execute(get);

        int getStatusCode = response.getStatusLine().getStatusCode();

        assertEquals(getStatusCode, 200);

    }
}
