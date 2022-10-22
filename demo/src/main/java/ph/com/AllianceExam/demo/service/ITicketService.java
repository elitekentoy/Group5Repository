package ph.com.AllianceExam.demo.service;

import java.io.BufferedReader;

import ph.com.AllianceExam.demo.entity.Ticket;

public interface ITicketService {
	public int create(final BufferedReader body);
	public String retreiveByID(final int id);
	public String retreiveAllTickets();
	public int deleteByID(final int id);
	public int updateByID(final Ticket ticket);
}
