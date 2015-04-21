package test01917;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import daoimpl01917.MySQLProduktBatchDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;

public class TestProduktBatchDAO {
	
	ProduktBatchDAO impl = new MySQLProduktBatchDAO();

	@Test
	public void getProduktBatch() throws DALException {
		
		ProduktBatchDTO pbDTO = null;
		List<ProduktBatchDTO> pbDTOList = impl.getProduktBatchList();
		int validId = impl.getProduktBatchList().get(0).getPbId();
		
		pbDTO = impl.getProduktBatch(validId);
		
		if (pbDTO != null && pbDTO == pbDTOList.get(0))
		{
			assertArrayEquals(expecteds, actuals);
		}
	}
	
	@Test
	public void getProduktBatchList() {
		fail("Not yet implemented");
	}
	
	@Test
	public void createProduktBatch() {
		fail("Not yet implemented");
	}
	
	@Test
	public void updateProduktBatch() {
		fail("Not yet implemented");
	}

}