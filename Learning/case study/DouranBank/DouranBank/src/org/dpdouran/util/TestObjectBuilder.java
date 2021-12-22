package org.dpdouran.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.dpdouran.data.entity.Client;
import org.dpdouran.data.entity.Employee;
import org.dpdouran.data.entity.Operation;
import org.dpdouran.data.utility.EmployeePost;

public class TestObjectBuilder {
	final static Logger logger = Logger.getLogger(TestObjectBuilder.class);
	public static final String CLIENTS_PATH = "d:\\douran_bank_data\\clients.dat";
	public static final String EMPLOYEES_PATH = "d:\\douran_bank_data\\employees.dat";
	public static final String OPERATIONS_PATH = "d:\\douran_bank_data\\operations.dat";

	public static void main(String[] args) {
		// -------------------------------------------------------------------------
		logger.info("write clients...");
		List<Client> clients = new ArrayList<Client>();
		for (int i = 1; i <= 100; i++) {
			Client c = new Client();
			c.firstName = "firstName " + i;
			c.lastName = "lastName " + i;
			c.identityNo = i;
			c.AccountNo = 1000 + i;
			c.balance = 0;
			c.openingDate = getRandomDate();
			clients.add(c);
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CLIENTS_PATH))) {
			oos.writeObject(clients);
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		logger.info("write clients is done!");

		// -------------------------------------------------------------------------
		logger.info("write employees...");
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 500; i <= 510; i++) {
			Employee e = new Employee();
			e.firstName = "firstName " + i;
			e.lastName = "lastName " + i;
			e.identityNo = i;
			e.post = getRandomPost();
			e.employmentDate = getRandomDate2();
			employees.add(e);
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(EMPLOYEES_PATH))) {
			oos.writeObject(employees);
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		logger.info("write employees is done!");

		// -------------------------------------------------------------------------
		logger.info("write operations...");
		List<Operation> operations = new ArrayList<Operation>();
		Random r = new Random();
		for (Client client : clients) {
			int operationCount = r.nextInt(100);
			long sum = 0;

			for (int i = 0; i <= operationCount; i++) {
				Operation o = new Operation();

				int value = r.nextInt(800);
				boolean isDeposit = r.nextBoolean();
				if (!isDeposit && (sum - value) >= 0) {
					value = -value;
				}

				o.clientIdentityNo = client.identityNo;
				o.employeeIdentityNo = employees.get(r.nextInt(employees.size() - 1)).identityNo;
				o.value = value;
				o.operationDate = getRandomDate(client.openingDate);
				operations.add(o);
			}
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(OPERATIONS_PATH))) {
			oos.writeObject(operations);
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		logger.info("write operations is done!");
	}

	public static Date getRandomDate() {
		LocalDate date = LocalDate.now();
		Random r = new Random();
		date = date.plusDays(r.nextInt(100) - 50);
		return new Date(date.toEpochDay());
	}

	public static Date getRandomDate2() {
		LocalDate date = LocalDate.now();
		Random r = new Random();
		date = date.plusDays(-r.nextInt(100) - 50);
		return new Date(date.toEpochDay());
	}

	public static Date getRandomDate(Date d) {
		LocalDate date = LocalDate.ofEpochDay(d.getTime());
		Random r = new Random();
		date = date.plusDays(r.nextInt(50));
		return new Date(date.toEpochDay());
	}

	public static EmployeePost getRandomPost() {
		EmployeePost[] posts = EmployeePost.values();
		Random r = new Random();
		return posts[r.nextInt(posts.length - 1)];
	}

}
