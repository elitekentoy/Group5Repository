package ph.com.AllianceExam.demo.service;


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

	
	public int create(Ticket ticket)
	{
		return repository.create(ticket);
	}


	public String retreiveAllTickets() {
		return gson.toJson(repository.retreiveAllTickets());
	}
	
	public int updateByID(final Ticket ticket)
	{
		return repository.updateByID(ticket);
	}

	public int updateTicketAssignee(Ticket ticket) {
		return repository.updateTicketAssignee(ticket);
	}
	
	public int updateTicketStatus(Ticket ticket) {
		return repository.updateTicketStatus(ticket);
	}
	
}
