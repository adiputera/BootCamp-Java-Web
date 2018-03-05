package bc.service;

import java.util.List;

import bc.dao.EmpDao;
import bc.entity.Employee;

public class EmpService {
	static EmpDao emd = new EmpDao();
	public static int save(Employee emp) {
		int status = emd.add(emp);
		return status;
	}
	
	public static int edit(Employee emp) {
		int status = emd.update(emp);
		return status;
	}
	
	public static int delete(int id) {
		int status = emd.delete(id);
		return status;
	}
	
	public static List<Employee> read() {
		return emd.getAllEmployees();
	}
	
	public static Employee readId(int id) {
		return emd.getEmployeeById(id);
	}
}
