package test01917;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import connector01917.Connector;
import daoimpl01917.MySQLReceptDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptDAO;
import dto01917.ReceptDTO;

public class TestReceptDAO {

	ReceptDAO re = new MySQLReceptDAO();
	
	@Before
	public void connect()
	{
		try {
			new Connector();
		} catch (Exception e) { 
			System.out.println("Catch");
		}
	}

	@Test
	public void testGetRecept() throws DALException{

		ReceptDTO testRec = null;
		List<ReceptDTO> recList = re.getReceptList();
		int ID = recList.get(0).getReceptId();
		testRec = re.getRecept(ID);
		
		ReceptDTO actual = testRec;
		ReceptDTO expected = recList.get(0);

		boolean areSame = true;

		if(actual.getReceptId() != expected.getReceptId()) 				areSame = false;
		if(!actual.getReceptNavn().equals(expected.getReceptNavn())) 	areSame = false;

		System.out.println("A: " + actual + ", E :" + expected);
		
		assertTrue(areSame);
	}

	@Test
	public void testCreateRecept(){
		//tager ReceptDTO recept

	}

	@Test
	public void testUpdateRecept(){
		//tager ReceptDTO recept

	}

}
