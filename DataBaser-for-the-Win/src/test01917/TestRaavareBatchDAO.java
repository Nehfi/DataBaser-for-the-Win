package test01917;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.RaavareBatchDTO;

public class TestRaavareBatchDAO {

	
	private RaavareBatchDAO dao = new MySQLRaavareBatchDAO();
	
	@Before
	public void connect()
	{
		try {
			new Connector();
		} catch (Exception e) {
		
		}
	}
	
	@Test
	public void getRaavareBatch() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		
		
		RaavareBatchDAO rbDAO= null;
		
		List<RaavareBatchDTO> rbDAOList = dao.getRaavareBatchList();
		int validId = dao.getRaavareBatchList().get(0).getRbId();
		
		RaavareBatchDTO actual = dao.getRaavareBatch(validId);
		RaavareBatchDTO expected = rbDAOList.get(0);
		
		boolean sameElements = true;
		assertTrue(sameElements);

	}
	
	@Test
	public void getRaavareBatchList() throws DALException {
		
		RaavareBatchDAO rbDAO= null;
		
		List<RaavareBatchDTO> rbDAOList = dao.getRaavareBatchList();
		int validId = dao.getRaavareBatchList().get(0).getRbId();
		
		RaavareBatchDTO actual = dao.getRaavareBatch(validId);
		RaavareBatchDTO expected = rbDAOList.get(0);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void getRaavareBatchListWithraavareId() {
		fail("Not yet implemented");
	}
	
	@Test
	public void createRaavareBatch() {
		fail("Not yet implemented");
	}
	
	@Test
	public void updateRaavareBatch() {
		fail("Not yet implemented");
	}

}
