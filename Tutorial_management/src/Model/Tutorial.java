package Model;

public class Tutorial {

	private String tutorialId ;
	private String title ;
	private String teacherId ;
	private String subjectCode ;
	private String subjectName ;
	private String dateAdded ;
	private String month ;
	private String material ;
	private String level ;
	private String medium ;
	private String teacherName ;
	
	public String getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(String tutorialId) {
		this.tutorialId = tutorialId;
	}
			
	public String getTutorialTitle() {
		return title;
	}

	public void setTutorialTitle(String title) {
		this.title = title;
	}
	
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded =  dateAdded;
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month =  month;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Tutorial [tutorialId=" + tutorialId + ", title=" + title + ", teacherId=" + teacherId + ", subjectCode="
				+ subjectCode + ", subjectName=" + subjectName + ", dateAdded=" + dateAdded + ", month=" + month
				+ ", material=" + material + ", level=" + level + ", medium=" + medium + ", teacherName=" + teacherName
				+ "]";
	}	
}
