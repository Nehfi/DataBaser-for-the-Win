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

	


	@Test
	public void testGetRaavare() throws DALException {
		RaavareDAO rd = new MySQLRaavareDAO();
	
		System.out.println();
		for (int i = 0; i < rd.getRaavareList().size(); i++) {
			System.out.println( rd.getRaavareList().get(i));
			
		}
		int id = rd.getRaavareList().get(1).getRaavareId();
		System.out.println(id);
	//	fail("Not yet implemented");
	}

	@Test
	public void testGetRaavareList(){
		fail("Not yet implemented");
	}
	@Test
	public void TestCreateRaavare(){
		fail("Not yet implemented");
	}
	@Test
	public void testUpdateRaaVare(){
		fail("Not yet implemented");
	}
}
