package test01917;

import static org.junit.Assert.*;
import daoimpl01917.MySQLRaavareDAO;
import java.util.List;
import org.junit.Test;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareDAO;
import dto01917.RaavareDTO;

public class TestRaavareDAO {

	//	RaavareDTO getRaavare(int raavareId) throws DALException;
	//	List<RaavareDTO> getRaavareList() throws DALException;
	//	void createRaavare(RaavareDTO raavare) throws DALException;
	//	void updateRaavare(RaavareDTO raavare) throws DALException;

	RaavareDAO rd = new MySQLRaavareDAO();


	@Test
	public void testGetRaavare() throws DALException {

		RaavareDTO testVare = null;
		List<RaavareDTO> raavareList = rd.getRaavareList();
		int ID = raavareList.get(0).getRaavareId();
		testVare = rd.getRaavare(ID);

		RaavareDTO actual = testVare;
		RaavareDTO expected = raavareList.get(0);

		assertEquals(expected, actual);


	}

	@Test
	public void testGetRaavareList() throws DALException{
		boolean moreThanZero = false;
		rd.getRaavareList().size();
	}
	@Test
	public void TestCreateRaavare(){
		// teste ved at tage listen først, lave en raavare, derefter smide 	
	}
	@Test
	public void testUpdateRaaVare(){
		fail("Not yet implemented");
	}
}
