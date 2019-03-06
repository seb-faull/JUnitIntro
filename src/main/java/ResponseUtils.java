import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class ResponseUtils {

    public static String getHeaderJava8Way(CloseableHttpResponse response, String headerName) {

        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        // Take a list of headers and stream them, flowing one-by-one.
        // Filter for a given header.
        // Then invoke findFirst, which finds and returns the first header that matches the criteria
        // Or throw an exception
        Header matchedHeader = httpHeaders.stream()
                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                .findFirst().orElseThrow(() -> new RuntimeException("Didn't find the header"));

        return matchedHeader.getValue();

    }

}
