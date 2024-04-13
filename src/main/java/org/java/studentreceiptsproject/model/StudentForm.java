package org.java.studentreceiptsproject.model;


import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentForm {
		@Id
//		private int sno;
		public int sno;
		private String sname;
		private int age;
		@Override
		public String toString() {
			return "StudentForm [sno=" + sno + ", sname=" + sname + ", age=" + age + "]";
		}
		
		
}
