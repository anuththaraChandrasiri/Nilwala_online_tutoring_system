package Model;

public class Tutorial {

	private String tutorialId ;
	private String title ;
	private String teacherId ;
	private String subjectCode ;	
	private String dateAdded ;
	private String month ;
	private String material ;
	
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
		this.material =  material;
	}
	
	@Override
	public String toString() {
		
		return "Tutorial ID = " + tutorialId + "\n" + "Tutorial name = " + title + "\n" + "Teacher ID = " + teacherId + "\n"
				+ "Subject code = " + subjectCode + "\n" + "Date added = " + dateAdded + "\n" + "Month = " + month + "\n"
				+ "Material = " + material ;
	}
}
