package ph.com.AllianceExam.demo.repository;

import java.util.List;
import ph.com.AllianceExam.demo.entity.Ticket;


public interface ITicketRepository {
	public Ticket retreiveTicketByID(final int id);
	public List<Ticket> retreiveAllTickets();
  public int create(final Ticket ticket);
  public int deleteByID(final int id);
  public int updateByID(final Ticket ticket);
}
