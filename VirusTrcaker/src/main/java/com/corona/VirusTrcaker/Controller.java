package com.corona.VirusTrcaker;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/virus")
@CrossOrigin("*")
public class Controller {
	@Autowired
	VirusTrackerService vs;
	
	@GetMapping(path="/getList")
	public ArrayList<Detail> getList() throws IOException, InterruptedException {
		return vs.hello();
	}

}
