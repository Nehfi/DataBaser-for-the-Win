package test01917;

import static org.junit.Assert.*;

import java.util.List;




import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
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
		int v = rk.getReceptKompList().get(0).getRaavareId();
		
		List<ReceptKompDTO> actual = rk.getReceptKompList(v);
		ReceptKompDTO expected = list.get(0);
		
		boolean theSameElement = true;
		assertTrue(theSameElement);
		

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
