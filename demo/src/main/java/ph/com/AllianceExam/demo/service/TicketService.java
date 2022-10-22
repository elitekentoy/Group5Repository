package ph.com.AllianceExam.demo.service;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;


import ph.com.AllianceExam.demo.entity.Ticket;
import ph.com.AllianceExam.demo.repository.ITicketRepository;

@Service
public class TicketService implements ITicketService {

	
	private ITicketRepository repository;
	private Gson gson;
	
	
	@Autowired
	
	public TicketService(final ITicketRepository repository) {
		this.repository = repository;
		this.gson = new Gson();
	}
  
  public int deleteByID(final int id){
	  return repository.deleteByID(id);
	}

	public String retreiveByID(int id) {
		return gson.toJson(repository.retreiveTicketByID(id));
	}

	
	public int create(final BufferedReader body)
	{
		final Ticket user = gson.fromJson(body, Ticket.class);
		
		return repository.create(user);
	}


	public String retreiveAllTickets() {
		return gson.toJson(repository.retreiveAllTickets());
	}
	
	public int updateByID(final Ticket ticket)
	{
		return repository.updateByID(ticket);
	}

	
}
