package Model;

public class Anu_Teacher {
	
	private String teacherID ;
	private String teacherName ;
	private String grade ;
	private String subjectCode ;
	private String subjectName ;
	private String level ;
	private String medium ;
	
	public Anu_Teacher() {
		super();
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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
		return "Anu_Teacher [teacherID=" + teacherID + ", teacherName=" + teacherName + ", grade=" + grade
				+ ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", level=" + level + ", medium="
				+ medium + "]";
	}
		
}
