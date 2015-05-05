package test01917;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import daointerfaces01917.ProduktBatchKompDAO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;

public class TestProduktBatchKompDAO {
	ProduktBatchKompDAO dao = new MySQLProduktBatchKompDAO();
	
	@Before
	public void connect()
	{
		try {
			new Connector();
		} catch (Exception e) {
		
		}
	}

	@Test
	public void testGetProduktBachKomp() throws DALException {
		
		ProduktBatchKompDAO pbkDAO = null;
		
		List<ProduktBatchKompDTO> pbkDTO = dao.getProduktBatchKompList();
		int validId = dao.getProduktBatchKompList().get(0).getPbId();
		
		List<ProduktBatchKompDTO> actual = dao.getProduktBatchKompList(validId);
		ProduktBatchKompDTO expected = pbkDTO.get(0);
		
		boolean sameEelement = true;
		
		assertTrue(sameEelement);

		
	}


	@Test
	public void testgetProdukBatchKompListPbId() throws DALException {
		
		
		List<ProduktBatchKompDTO> list = dao.getProduktBatchKompList(1);
		
		assertTrue(list.size()>1);
		
	}

	
	@Test
	public void testProduktBatchKompList() throws DALException {

		
List<ProduktBatchKompDTO> list = dao.getProduktBatchKompList();
		
		assertTrue(list.size()>1);	
	
	}
	
//	@Test
//	public void testCreateProduktBatchKomp() throws DALException {
//
//		List<ProduktBatchKompDTO> list = dao.getProduktBatchKompList();
//		int currentList = list.get(list.size()-1).getPbId();
//		
//		int expected = dao.getProduktBatchKompList().size()+1;
//		dao.createProduktBatchKomp(new ProduktBatchKompDTO(currentList+1, 4, 0.0, 0.0, 3));
//		int actual = dao.getProduktBatchKompList().size();
//		
//		assertEquals(expected, actual);
//		
//	}
	
	@Test
	public void testUpdateProduktBatchKomp() throws DALException {
		
		ProduktBatchKompDTO dto = null;
		double expected = 14.8;
		try {
			dto = dao.getProduktBatchKompList().get(0);
			dto.setNetto(expected);
			dao.updateProduktBatchKomp(dto);
		} catch (DALException e) {
			e.printStackTrace();
		}
		double actual = dto.getNetto();
		
		assertEquals(expected, actual, 0);
	}
	
}