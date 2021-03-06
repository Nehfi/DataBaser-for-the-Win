package test01917;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;
import dto01917.RaavareDTO;

public class TestProduktBatchDAO {
	
	ProduktBatchDAO pbDao = new MySQLProduktBatchDAO();
	
	@Before
	public void connect()
	{
		try {
			new Connector();
		} catch (Exception e) {
		
		}
	}

	@Test
	public void testGetProduktBatch() throws DALException
	{
		ProduktBatchDTO testBatch = null;
		List<ProduktBatchDTO> pbList = pbDao.getProduktBatchList();
		int validId = pbList.get(0).getPbId();
		testBatch = pbDao.getProduktBatch(validId);
		
		ProduktBatchDTO actual = testBatch;
		ProduktBatchDTO expected = pbList.get(0);
		
		boolean theSame = true;
		
		if (actual.getPbId() 	!= expected.getPbId()) 	   	theSame = false;
		if (actual.getReceptId() != expected.getReceptId()) theSame = false;
		if (actual.getStatus() != expected.getStatus()) 	theSame = false;

		assertTrue(theSame);
		
	}
	
	@Test
	public void testGetProduktBatchList() throws DALException {
		
		List<ProduktBatchDTO> pbList = pbDao.getProduktBatchList();
		
		assertTrue(pbList.size()>1);
	}
	
	@Test
	public void testCreateProduktBatch() throws DALException {
		List<ProduktBatchDTO> pbList = pbDao.getProduktBatchList();
		int currentHighestId  = pbList.get(pbList.size()-1).getPbId();
	
		int expected = pbDao.getProduktBatchList().size()+1;
		pbDao.createProduktBatch(new ProduktBatchDTO(currentHighestId+1, 1, 1));
		int actual = pbDao.getProduktBatchList().size();
	
		assertEquals(expected, actual);
	}
	
	@Test
	public void testUpdateProduktBatch() {
		ProduktBatchDTO pbList = null;
		int expected = 1;
		try {
			pbList = pbDao.getProduktBatchList().get(0);
			pbList.setReceptId(expected);
			pbDao.updateProduktBatch(pbList);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int actual = pbList.getReceptId();
		assertEquals(expected, actual);
	}

}
