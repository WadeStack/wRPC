package org.wuuijkl.wrpc.transport;

import org.apache.commons.io.IOUtils;
import org.wuuijkl.wrpc.Peer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author wade
 * @Date 2022/3/19 22:12
 * @Description
 */
public class HTTPTransportClient implements TransportClient {
    private String url;

    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost() + ":" + peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setDoInput(true);
            httpConnection.setUseCaches(false);
            httpConnection.setRequestMethod("POST");
            httpConnection.connect();
            IOUtils.copy(data, httpConnection.getOutputStream());

            int resultCode = httpConnection.getResponseCode();
            if (resultCode == HttpURLConnection.HTTP_OK) {
                return httpConnection.getInputStream();
            } else {
                return httpConnection.getErrorStream();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
