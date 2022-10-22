package ph.com.AllianceExam.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ph.com.AllianceExam.demo.entity.Ticket;

@Repository

public class TicketRepository implements ITicketRepository {

	@Autowired 
	
	private JdbcTemplate template;

	public Ticket retreiveTicketByID(final int id) {
		
		try {
		final String sql = "Select * from ticketmodule where ticketID=?";
		final Ticket ticket = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Ticket.class), id);
		
		return ticket;
		}catch(EmptyResultDataAccessException e) {
			return new Ticket(0, "", "" , "", "" , "");
		}
		
	}

	public List<Ticket> retreiveAllTickets() {
		final String sql = "select * from ticketmodule";
		final List<Ticket> ticket = template.query(sql,BeanPropertyRowMapper.newInstance(Ticket.class));
		
		return ticket;
	}
	
	public int create(final Ticket ticket) {
		final String sql = "INSERT INTO ticket (ticketID, assignee, status, subject, description, tracker) VALUES (?, ?, ?, ?, ?, ?)";
		final int result = template.update(sql, ticket.getTicketID(), ticket.getAssignee(), ticket.getStatus(), ticket.getSubejct(), ticket.getDescription(), ticket.getTracker());
		
		return result;
	}
	
	
	public int deleteByID(final int id)
	{
		final String sql = "DELETE FROM ticketmodule WHERE userid=?";
		final int result = template.update(sql, id);
 
		return result;
	}
	
	public int updateByID(final Ticket ticket)
	{

		final String sql = "UPDATE ticketmodule SET  assignee=?, status=?, subject=?, description=?, tracker=? WHERE ticketID=?";
		final int result = template.update(sql, ticket.getAssignee(), ticket.getStatus(), ticket.getSubject(), ticket.getDescription(), ticket.getTracker(), ticket.getTicketID());
		
		return result;
	}
	
}
