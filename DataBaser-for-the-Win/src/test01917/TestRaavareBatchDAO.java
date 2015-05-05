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
	public void testGetRaavareBatch() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		
		
		RaavareBatchDAO rbDAO= null;
		
		List<RaavareBatchDTO> rbDAOList = dao.getRaavareBatchList();
		int validId = dao.getRaavareBatchList().get(0).getRbId();
		
		RaavareBatchDTO actual = dao.getRaavareBatch(validId);
		RaavareBatchDTO expected = rbDAOList.get(0);
		
		boolean sameElements = true;
		assertTrue(sameElements);

	}
	
	@Test
	public void testGetRaavareBatchList() throws DALException {
		
		List<RaavareBatchDTO> list = dao.getRaavareBatchList();
		
		assertTrue(list.size()>1);
		
	}
	
	@Test
	public void testGetRaavareBatchListWithraavareId() throws DALException {
		
		List<RaavareBatchDTO> list1 = dao.getRaavareBatchList();
		
		assertTrue(list1.size()>1);
		
	}
	
	@Test
	public void TestCreateRaavareBatch() throws DALException {
		
		List<RaavareBatchDTO> list = dao.getRaavareBatchList();
		int currentList = list.get(list.size()-1).getRbId();
		
		int expected = dao.getRaavareBatchList().size()+1;
		dao.createRaavareBatch(new RaavareBatchDTO(currentList+1, 7, 23));
		int actual = dao.getRaavareBatchList().size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void TestUpdateRaavareBatch() {
		RaavareBatchDTO dto = null;
		int expected = 148;
		try {
			dto = dao.getRaavareBatchList().get(0);
			dto.setRaavareId(expected);
			dao.updateRaavareBatch(dto);
		} catch (DALException e) {
			e.printStackTrace();
		}
		int actual = dto.getRaavareId();
		assertEquals(expected, actual);
	}

}
