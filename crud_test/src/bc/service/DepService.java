package bc.service;

import java.util.List;

import bc.dao.DepDao;
import bc.entity.Department;
import bc.entity.Employee;

public class DepService {
	static DepDao ddao = new DepDao();
	public static int save(Department dep) {
		int status = ddao.add(dep);
		return status;
	}
	
	public static int edit(Department dep) {
		int status = ddao.update(dep);
		return status;
	}
	
	public static int delete(int id) {
		int status = ddao.delete(id);
		return status;
	}
	
	public static List<Department> read() {
		return ddao.getAllDepartemen();
	}
	
	public static Department readId(int id) {
		return ddao.getDepById(id);
	}
}
