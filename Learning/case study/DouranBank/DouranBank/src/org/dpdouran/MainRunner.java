package org.dpdouran;

import java.util.List;

import org.apache.log4j.Logger;
import org.dpdouran.data.dao.ClientDaoFile;
import org.dpdouran.data.dao.EmployeeDaoFile;
import org.dpdouran.data.dao.OperationDaoFile;
import org.dpdouran.data.entity.Client;

public class MainRunner {
	final static Logger logger = Logger.getLogger(MainRunner.class);

	public static void main(String[] args) {
		ClientDaoFile clientDao = new ClientDaoFile();
		EmployeeDaoFile employeeDao = new EmployeeDaoFile();
		OperationDaoFile operationDao = new OperationDaoFile();

		List<Client> clients = clientDao.find();
		clients.stream().forEach(c -> System.out.println(c.firstName + " " + c.lastName + ", " + c.identityNo));
	}
}
