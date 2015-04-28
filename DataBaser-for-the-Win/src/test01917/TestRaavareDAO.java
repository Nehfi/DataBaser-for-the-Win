package test01917;

import static org.junit.Assert.*;
import daoimpl01917.MySQLRaavareDAO;
import java.util.List;
import org.junit.Test;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareDAO;
import dto01917.RaavareDTO;

public class TestRaavareDAO {

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
		boolean actual = false;
		int expectedSize = rd.getRaavareList().size();
		if(expectedSize > 0){
		}

		boolean expected = true;

		assertEquals(expected, actual);
	} 
	@Test
	public void TestCreateRaavare(){
		int expected=  0, actual = 0;
		try {
			expected = rd.getRaavareList().size() + 1;
			rd.createRaavare(new RaavareDTO(100, "Banan", "taberstedet"));
			actual =  rd.getRaavareList().size();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(expected, actual);

	}
	@Test
	public void testUpdateRaaVare(){
		RaavareDTO dto = null;
		String expected = "bullerbassen";
		try {
			dto = rd.getRaavareList().get(0);
			dto.setLeverandoer(expected);
			rd.updateRaavare(dto);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = dto.getLeverandoer();
		assertEquals(expected, actual);
		
	}
}
