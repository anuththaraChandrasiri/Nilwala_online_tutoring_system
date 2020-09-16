package Model;

public class Anu_Subject {
	
	private String subjectCode ;
	private String subjectName ;
	private String level ;
	private String medium ;	
	
	public Anu_Subject() {
		super();
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	
	@Override
	public String toString() {
		return "Anu_Subject [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", level=" + level
				+ ", medium=" + medium + "]";
	}

}
