package test01917;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import daointerfaces01917.ProduktBatchKompDAO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;

public class TestProduktBatchKompDAO {
	ProduktBatchKompDAO impl = new MySQLProduktBatchKompDAO();

	@Test
	public void testGetProduktBachKomp() throws DALException {
		
		ProduktBatchKompDTO pbkDTO = null;
		
		List<ProduktBatchKompDTO> pbkDTOList = impl.getProduktBatchKompList();
		
		int validId = pbkDTOList.get(0).getPbId();
		int rbid =  pbkDTOList.get(0).getRbId();
		
		pbkDTO = impl.getProduktBatchKomp(validId, rbid);
		 ProduktBatchKompDTO actual = pbkDTO;
		 ProduktBatchKompDTO expected = pbkDTOList.get(0);
		 
		 boolean 
		 
		 if(validId == actual.getPbId() && rbid == actual.getRbId()){
			 
		 }
		
		assertEquals(expected, actual);
		
	}

}
//ProduktBatchDTO pbDTO = null;.
//List<ProduktBatchDTO> pbDTOList = impl.getProduktBatchList();
//int validId = impl.getProduktBatchList().get(0).getPbId();
//
//ProduktBatchDTO actual = impl.getProduktBatch(validId);
//ProduktBatchDTO expected = pbDTOList.get(0);
//
//assertEquals(expected, actual);