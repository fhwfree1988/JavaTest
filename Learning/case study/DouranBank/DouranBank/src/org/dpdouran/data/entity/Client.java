package org.dpdouran.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Client extends Person {
	public Integer AccountNo;
	public Integer balance;
	public List<Operation> operationList;
	public Date openingDate;
}