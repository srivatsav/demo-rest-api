package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Post;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value="getAllPosts",method=RequestMethod.GET)
	public List<Post> getAllPosts() {
		return demoService.getAllPosts();
	}
}
