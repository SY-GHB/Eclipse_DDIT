package service;

import java.util.List;
import java.util.Map;

import dao.ProdDao;

public class ProdService {
	private static ProdService instance = null;

	private ProdService() {
	}

	public static ProdService getInstance() {
		if (instance == null) {
			instance = new ProdService();
		}
		return instance;
	}
	
	ProdDao dao = ProdDao.getInstance();
	
	public List<Map<String, Object>> prodList(){
		return dao.prodList();
	}

	public List<Map<String, Object>> prodTypeSearch(String type) {
		return dao.prodTypeSearch(type);
		
	}

	public List<Map<String, Object>> prodNameSearch(String name) {
		return dao.prodNameSearch(name);
		
	}

	public void prodSale(List<Object> param) {
		dao.prodSale(param);
		
	}
}
