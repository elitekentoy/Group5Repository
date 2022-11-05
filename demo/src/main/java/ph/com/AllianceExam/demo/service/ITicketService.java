package ph.com.AllianceExam.demo.service;


import ph.com.AllianceExam.demo.entity.Ticket;

public interface ITicketService {
	public int create(Ticket ticket);
	public String retreiveByID(final int id);
	public String retreiveAllTickets();
	public int deleteByID(final int id);
	public int updateByID(final Ticket ticket);
	public int updateTicketAssignee(Ticket ticket);
	public int updateTicketStatus(Ticket ticket);
}
