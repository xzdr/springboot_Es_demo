package com.colourdata.service;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private TransportClient client;

    private static String INDEX = "budweiserfifa_java";
    private static String TWEET_TYPE = "WeiboTweet";

    public List test01(){
        SearchResponse response = client.prepareSearch(INDEX).setTypes(TWEET_TYPE)
                .setQuery(QueryBuilders.termQuery("commentContent", "圆梦"))
                .get();
        List<Map> list = new ArrayList<>();
        for (SearchHit searchHit : response.getHits().getHits()){
            Map data = searchHit.getSource();
            list.add(data);
        }
        System.out.println(list);
        return list;
    }
}
