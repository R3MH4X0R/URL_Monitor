package com.gmail.ditritusa.util;

import com.gmail.ditritusa.model.UrlInfo;
import com.gmail.ditritusa.repository.UrlInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Component
public class UrlUtil {

    private final UrlInfoRepository urlInfoRepository;

    @Autowired
    public UrlUtil(UrlInfoRepository urlInfoRepository) {
        this.urlInfoRepository = urlInfoRepository;
    }


    public void getStatus(String url) throws IOException {

        UrlInfo urlInfo = new UrlInfo();

        try {
            URL siteURL = new URL(url);
            urlInfo.setUrl(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            final long startTime = System.currentTimeMillis();
            connection.connect();
            urlInfo.setContentLenght(connection.getContentLength());
            final long endTime = System.currentTimeMillis();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                urlInfo.setResponse(String.valueOf(connection.getResponseCode()));
                urlInfo.setTime(endTime - startTime);

            } else {
                urlInfo.setResponse(String.valueOf(connection.getResponseCode()));
                urlInfo.setTime(endTime - startTime);
            }
        } catch (Exception e) {
            System.out.println("Wrong domain - Exception: " + e.getMessage());

        }
        urlInfoRepository.save(urlInfo);
    }

    public void getStatus(Long id) {

        UrlInfo urlInfo = this.urlInfoRepository.getOne(id);
        try {
            URL siteURL = new URL(urlInfo.getUrl());
            urlInfo.setUrl(urlInfo.getUrl());
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            final long startTime = System.currentTimeMillis();
            connection.connect();
            urlInfo.setContentLenght(connection.getContentLength());
            final long endTime = System.currentTimeMillis();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                urlInfo.setResponse(String.valueOf(connection.getResponseCode()));
                urlInfo.setTime(endTime - startTime);

            } else {
                urlInfo.setResponse(String.valueOf(connection.getResponseCode()));
                urlInfo.setTime(endTime - startTime);
            }
        } catch (Exception e) {
            System.out.println("Wrong domain - Exception: " + e.getMessage());

        }
        urlInfoRepository.save(urlInfo);
    }

    public void refreshAll() {

        List<UrlInfo> urlList = this.urlInfoRepository.findAll();

        urlList.forEach(url -> getStatus(url.getId()));

    }

}
