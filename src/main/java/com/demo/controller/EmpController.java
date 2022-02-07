package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.demo.model.EmpDoc;

@RestController
public class EmpController {

	@Autowired
	CloudantClient client;
	
	@GetMapping("/hello")
	public String showMsg() {
		System.out.println("Hi");
		return "Hello API called";
	}
	
	private Database db ;
	
	@PostConstruct
	private void setUp() {
		this.db = this.client.database("demoapp_db", true);
	}
	
	@GetMapping("/getAllData")
	public List<EmpDoc> getAllData() throws IOException {
		System.out.println("Hi..Api getAllData Called");
	List<EmpDoc> doc=db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(EmpDoc.class);
	return doc;
	}
	
	@GetMapping("/getDataFromId/{id}")
	public EmpDoc getDataFromId(@PathVariable String id) {
	List<String> list=new ArrayList<String>();
	list=client.getAllDbs();
//	Database db = client.database("demoapp_db", false);
	EmpDoc doc=db.find(EmpDoc.class,id);
	System.out.println("Current running dbs are "+list.get(0));
		return doc;
	}
	
	@PostMapping("/saveData")
	public Response saveData(@RequestBody EmpDoc emp) {
	Response res=db.save(emp);
	System.out.println("Data saved Successfully!.");
	return res;
	}
	
	@DeleteMapping("/deleteDataFromId/{id}")
	public Response deleteDataFromId(@PathVariable String id) {
	EmpDoc doc=db.find(EmpDoc.class,id);
	 Response response = db.remove(doc);
	System.out.println("document deleted successfully");
		return response;
	}
	
	@PutMapping("/updateData/{id}")
	public Response updateData(@RequestBody EmpDoc emp,@PathVariable String id) {
	EmpDoc doc=db.find(EmpDoc.class,id);
	doc.setDoj(emp.getDoj());
	doc.setEmailid(emp.getEmailid());
	Response res=db.update(doc);
	System.out.println("data updated successfully");
		return res;
	}
	
}
