package com.example.demo.proxy.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.beans.Post;
import com.example.demo.constants.DemoConstants;
import com.example.demo.proxy.DemoProxy;

@Component
@Configuration
public class DemoProxyImpl implements DemoProxy {

	@Autowired
	RestTemplate restTemplate;

	@Value("baseurl")
	private String baseUrl;

	@Override
	public List<Post> getAllPosts() {
		String endPointUri = baseUrl + DemoConstants.GET_ALL_POSTS;

		// TODO: go through casting 
		List<com.example.demo.service.beans.Post> servicePosts = (List<com.example.demo.service.beans.Post>) restTemplate
				.exchange(endPointUri, HttpMethod.GET, null, com.example.demo.service.beans.Post.class).getBody();
		
		List<Post> ownPost = new ArrayList<Post>();
		for(com.example.demo.service.beans.Post postItem : servicePosts) {
			Integer id = postItem.getId();
			String title = postItem.getTitle();
			Integer userId = postItem.getUserId();
			
			Post post = new Post();
			//TODO: difference between int && Integer (Wrapper classes)
			post.setPostId(Integer.toString(id));
			post.setTitle(title);
			post.setUserId(Integer.toString(userId));
			ownPost.add(post);
			
		}
		return ownPost;
	}

}
