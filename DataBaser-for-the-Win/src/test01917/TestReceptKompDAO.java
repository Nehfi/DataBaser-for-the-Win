package test01917;

import static org.junit.Assert.*;

import java.util.List;



import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchKompDTO;
import dto01917.ReceptKompDTO;

public class TestReceptKompDAO {

	

	MySQLReceptKompDAO rk = new MySQLReceptKompDAO();


	@Before
	public void Connect() {
		try {
			new Connector();
		}catch (Exception e){
		}
	}

	@Test
	public void testgetReceptKomp() throws DALException{

		List<ReceptKompDTO> list = rk.getReceptKompList();
		ReceptKompDTO expected = list.get(0);
		int key1 = expected.getRaavareId();
		int key2 = expected.getReceptId();

		ReceptKompDTO  actual = rk.getReceptKomp(key1, key2);

		assertEquals(actual, expected);
	}

	@Test
	public void testGetReceptKompList() throws DALException{
		boolean listMoreThanZero = false;

		if(rk.getReceptKompList().size() > 0){
			listMoreThanZero = true;
		}
		assertTrue(listMoreThanZero);
	}

	@Test
	public void getReceptKompListWithReceptID() throws DALException{
		int receptID = rk.getReceptKompList().get(0).getReceptId();
		
		boolean listMoreThanZero = false;

		if(rk.getReceptKompList(receptID).size() > 0){
			listMoreThanZero = true;
		}
		assertTrue(listMoreThanZero);
	}
	
	@Test
	public void testCreateReceptKomp() throws DALException{
		int expected = rk.getReceptKompList().size() + 1;
		 new ReceptKompDTO(1, 2, 1, 2);
		rk.createReceptKomp( new ReceptKompDTO(1, 2, 1, 2));
		int actual = rk.getReceptKompList().size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testUpdateReceptKomp() throws DALException{

		
		
		ReceptKompDTO one = null;
		double expected = 0.2;
		
		try{
			one = rk.getReceptKompList().get(0);
			one.setTolerance(expected);
			rk.updateReceptKomp(one);
		}catch(DALException e){
			e.printStackTrace();
		}

		
		double actual = one.getTolerance();
	
		assertEquals(expected, actual, 0);
	}
}
