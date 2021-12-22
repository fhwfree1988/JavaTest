package org.dpdouran.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.dpdouran.data.utility.EmployeePost;

public class Employee extends Person implements Serializable {
	public List<Operation> operationList;
	public EmployeePost post;
	public Date employmentDate;
}