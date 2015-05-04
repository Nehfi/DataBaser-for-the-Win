package test01917;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.RaavareBatchDTO;

public class TestRaavareBatchDAO {

	private RaavareBatchDAO dao = new MySQLRaavareBatchDAO();

	
	@Test
	public void getRaavareBatch() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		new Connector();
		
		
		RaavareBatchDAO rbDAO= null;
		
		@SuppressWarnings("unchecked")
		List<RaavareBatchDTO> rbDAOList = (List<RaavareBatchDTO>) dao.getRaavareBatch(1);
		@SuppressWarnings("unchecked")
		int validId = ((List<RaavareBatchDTO>) dao.getRaavareBatch(1)).get(1).getRbId();
		
		RaavareBatchDTO actual = dao.getRaavareBatch(validId);
		RaavareBatchDTO expected = rbDAOList.get(0);
		
		assertEquals(expected, actual);
		

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
