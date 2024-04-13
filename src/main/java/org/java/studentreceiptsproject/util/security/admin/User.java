/**
 * *********************************************
 * Date         Name                         
 * *********************************************
 * 11-Dec-2019   Sachin Patil aka JavaPatil  
 */

package org.java.studentreceiptsproject.util.security.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class User {

	
	private String userName;
	private int organizationId;
	private String organizationName;
	private String pass;
	private String status;
	private String emailId;
	private String mobileNo;
	private String roleName;
	
	
	



	public String toString()
	{
		return this.userName + " " + this.organizationId + " " + this.organizationName + " " + this.pass + " " + this.status + " " + this.emailId + " " + this.mobileNo + " " + this.roleName;
	}
}
