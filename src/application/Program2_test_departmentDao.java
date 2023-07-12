package application;
// AAC85
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2_test_departmentDao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		Department dep = departmentDao.findById(4);
		System.out.println("=== TEST 1: Department findById =====");
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: Department findAll =====");
		List<Department>list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Department insert =====");
		Department newDepartment = new Department(null, "DVD");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department update =====");
		Department dep1 = departmentDao.findById(5);
		dep1.setName("Instrument");
		departmentDao.update(dep1);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: seller delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

 		sc.close();
	}
}