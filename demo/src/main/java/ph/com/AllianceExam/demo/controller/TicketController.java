package ph.com.AllianceExam.demo.controller;


import java.io.IOException;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ph.com.AllianceExam.demo.entity.Ticket;
import ph.com.AllianceExam.demo.service.ITicketService;

@RestController
public class TicketController {
	
	private ITicketService service;
	
	@Autowired
	
	public TicketController(final ITicketService service) {
		this.service = service;
	}
	

	@RequestMapping("ticket/all")
	public String retrieveAllTickets() {
		return service.retreiveAllTickets();
	}
	

	@RequestMapping("ticket/{id}")
	public String retreiveTicketsByID(@PathVariable final int id) {
		return service.retreiveByID(id);
	}

	@DeleteMapping("/ticket/delete/{id}")
	public int delete(@PathVariable final int id) throws IOException
	{		
		return service.deleteByID(id);
	}
	
	@PostMapping("/ticket/update/{id}")
	public int udpateByID(@PathVariable final int id, @RequestParam("assignee") final String assignee, @RequestParam("status") final String status, @RequestParam("subject") final String subject, @RequestParam("description") final String description, @RequestParam("tracker") final String tracker) throws IOException
	{
		return service.updateByID(new Ticket(id, assignee, status, subject, description, tracker));
	}


	@PostMapping("/ticket/create")
	public int create(final HttpServletRequest request) throws IOException
	{
		final BufferedReader body = request.getReader();
		return service.create(body);
	}
	



}
