package com.juaracoding._01JavaWeb.controller;

import com.juaracoding._01JavaWeb.configuration.OtherConfig;
import com.juaracoding._01JavaWeb.model.Pembayaran;
import com.juaracoding._01JavaWeb.model.Student;
import com.juaracoding._01JavaWeb.service.PembayaranService;
import com.juaracoding._01JavaWeb.utils.MappingAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/payment")
public class PembayaranController {

	private PembayaranService pembayaranService;

	private MappingAttribute mappingAttribute = new MappingAttribute();
	private Map<String,Object> objectMapper = new HashMap<String,Object>();

	@Autowired
	public PembayaranController(PembayaranService pembayaranService) {

		this.pembayaranService = pembayaranService;
	}
	
	// handler method to handle list pembayaran and return mode and view
	@GetMapping("/v1/pembayaran")
	public String listPembayaran(Model model, WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y"))
		{
			mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
			if(request.getAttribute("USR_ID",1)==null){
				return "redirect:/api/check/logout";
			}
		}
		model.addAttribute("pembayaran", pembayaranService.getAllPembayaran());
		return "pembayaran";
	}
	
	@GetMapping("/v1/pembayaran/new")
	public String createPembayaranForm(Model model,WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		// create pembayaran object to hold student form data
		Pembayaran pembayaran = new Pembayaran();
		model.addAttribute("pembayaran", pembayaran);
		return "create_pembayaran";
		
	}
	
	@PostMapping("/v1/pembayaran")
	public String savePembayaran(@ModelAttribute("pembayaran") Pembayaran pembayaran,Model model,WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		pembayaranService.savePembayaran(pembayaran);
		return "redirect:/api/payment/v1/pembayaran";
	}
	
	@GetMapping("/v1/pembayaran/edit/{id}")
	public String editPembayaranForm(@PathVariable("id") Long Id, Model model, WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		model.addAttribute("pembayaran", pembayaranService.getPembayaranById(Id));
		return "edit_pembayaran";
	}

	@PostMapping("/v1/pembayaran/{id}")
	public String updatePembayaran(@PathVariable("id") Long id,
			@ModelAttribute("pembayaran") Pembayaran pembayaran,
			Model model, WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		// get pembayaran from database by id
		Pembayaran existingPembayaran = pembayaranService.getPembayaranById(id);
		existingPembayaran.setIdPembayaran(id);
		existingPembayaran.setPembayaran(pembayaran.getPembayaran());
		
		// save updated pembayaran object
		pembayaranService.updatePembayaran(existingPembayaran);
		return "redirect:/api/payment/v1/pembayaran";
	}
	
	// handler method to handle delete pembayaran request
	
	@GetMapping("/v1/pembayaran/{id}")
	public String deletePembayaran(@PathVariable Long id, Model model, WebRequest request) {
		if(OtherConfig.getFlagSessionValidation().equals("y")) {
			mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
			if (request.getAttribute("USR_ID", 1) == null) {
				return "redirect:/api/check/logout";
			}
		}
		pembayaranService.deletePembayaranById(id);
		return "redirect:/pembayaran";
	}
	
}
