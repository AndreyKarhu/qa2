package services;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Andrey on 08.07.2017.
 */
public class RestConnectionService {

    private static final int OK = 200;

    public String httpGetRequest(String url) {
        HttpClient httpClient = HttpClientBuilder.create().build();

        String responseContent = null;
        HttpEntity responseEntity;

        try {

            HttpGet request = new HttpGet(url);
            request.setHeader("Accept", "application/json");

            HttpResponse response = httpClient.execute(request);

            responseEntity = response.getEntity();

            if (response.getStatusLine().getStatusCode() == OK) {
                responseContent = IOUtils.toString(responseEntity.getContent());
                EntityUtils.consume(responseEntity);
            } else {
                throw new IllegalStateException("Response for request on " + url + " wasn't OK");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseContent;
    }
}
