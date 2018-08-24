package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Post;
import com.example.demo.proxy.DemoProxy;
import com.example.demo.service.DemoService;

@Service //TODO: vishal to check this annotation
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoProxy demoProxy;
	
	@Override
	public List<Post> getAllPosts() {
		
		return demoProxy.getAllPosts();
	}

}
