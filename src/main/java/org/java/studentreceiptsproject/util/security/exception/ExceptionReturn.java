package org.java.studentreceiptsproject.util.security.exception;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ExceptionReturn {
    private Boolean result;
    private String field;
    public String condition;
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
    
    
}
