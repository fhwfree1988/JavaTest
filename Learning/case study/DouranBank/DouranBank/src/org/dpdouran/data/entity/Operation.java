package org.dpdouran.data.entity;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable {
	public int clientIdentityNo;
	public int employeeIdentityNo;
	public int value;
	public Date operationDate;
}