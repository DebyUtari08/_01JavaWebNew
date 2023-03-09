package com.juaracoding._01JavaWeb.controller;

import com.juaracoding._01JavaWeb.configuration.OtherConfig;
import com.juaracoding._01JavaWeb.model.PesananLaundry;
import com.juaracoding._01JavaWeb.service.PesananLaundryService;
import com.juaracoding._01JavaWeb.utils.MappingAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/pesanan")
public class PesananLaundryController {

	private PesananLaundryService pesananLaundryService;

	private MappingAttribute mappingAttribute = new MappingAttribute();
	private Map<String,Object> objectMapper = new HashMap<String,Object>();

	@Autowired
	public PesananLaundryController(PesananLaundryService pesananLaundryService) {
		this.pesananLaundryService = this.pesananLaundryService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/v1/order")
	public String listPesananLaundry(Model model, WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y"))
		{
			mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
			if(request.getAttribute("USR_ID",1)==null){
				return "redirect:/api/check/logout";
			}
		}
		model.addAttribute("order", pesananLaundryService.getAllPesananLaundry());
		return "students";
	}
	
	@GetMapping("/v1/order/new")
	public String createStudentForm(Model model,WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		// create student object to hold student form data
		PesananLaundry pesananLaundry = new PesananLaundry();
		model.addAttribute("pesananLaundry", pesananLaundry);
		return "create_pesananLaundry";
		
	}
	
	@PostMapping("/v1/order")
	public String savePesananLaundry(@ModelAttribute("pesananLaundry") PesananLaundry pesananLaundry,Model model,WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		pesananLaundryService.savePesananLaundry(pesananLaundry);
		return "redirect:/api/pesanan/v1/order";
	}
	
	@GetMapping("/v1/order/edit/{id}")
	public String editPesanabLaundryForm(@PathVariable("id") Long Id, Model model, WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		model.addAttribute("student", pesananLaundryService.getPesananLaundryById(Id));
		return "edit_pesananLaundry";
	}

	@PostMapping("/v1/order/{id}")
	public String updatePesananLaundry(@PathVariable("id") Long id,
			@ModelAttribute("pesananLaundry") PesananLaundry pesananLaundry,
			Model model, WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		// get student from database by id
		PesananLaundry existingPesananLaundry = pesananLaundryService.getPesananLaundryById(id);
		existingPesananLaundry.setIdPesanan(id);
		existingPesananLaundry.setIdPaketLayanan(pesananLaundry.getIdPaketLayanan());
		existingPesananLaundry.setIdusers(pesananLaundry.getIdusers());
		existingPesananLaundry.setIdStatus(pesananLaundry.getIdStatus());
		existingPesananLaundry.setIdPembayaran(pesananLaundry.getIdPembayaran());
		// save updated student object
		pesananLaundryService.updatePesananLaundry(existingPesananLaundry);
		return "redirect:/api/school/v1/order";
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/v1/order/{id}")
	public String deletePesananLayanan(@PathVariable Long id, Model model, WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		pesananLaundryService.deletePesananLaundryById(id);
		return "redirect:/order";
	}
	
}
