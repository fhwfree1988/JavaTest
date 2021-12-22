package org.dpdouran.data.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.dpdouran.data.entity.Employee;
import org.dpdouran.util.TestObjectBuilder;

public class EmployeeDaoFile implements BaseDao {
	final static Logger logger = Logger.getLogger(ClientDaoFile.class);

	public List<Employee> find() {
		List<Employee> employees = null;
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream(TestObjectBuilder.EMPLOYEES_PATH));

			employees = (List<Employee>) ois.readObject();
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					logger.error(e);
				}
		}

		return employees;
	}
}
