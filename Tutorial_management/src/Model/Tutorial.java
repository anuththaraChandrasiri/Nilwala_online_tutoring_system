package Model;

import java.util.Arrays;

public class Tutorial {

	private String tutorialId ;
	private String title ;
	private String teacherId ;
	private String subjectCode ;
	private String subjectName ;
	private String dateAdded ;
	private String material ;
	private String level ;
	private String medium ;
	private String teacherName ;
	private String studentId ;
	private String questions[] ;
	private String forumId ;
	private int questionNo ;
	private int count ;
	private int studentCount ;
	private int grade ;
		
	public Tutorial() {
		super();	
	}

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
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String[] getQuestions() {
		return questions;
	}

	public void setQuestions(String[] questions) {
		this.questions = questions;
	}
	
	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}
	
	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
		
	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Tutorial [tutorialId=" + tutorialId + ", title=" + title + ", teacherId=" + teacherId + ", subjectCode="
				+ subjectCode + ", subjectName=" + subjectName + ", dateAdded=" + dateAdded + ", material=" + material
				+ ", level=" + level + ", medium=" + medium + ", teacherName=" + teacherName + ", studentId="
				+ studentId + ", questions=" + Arrays.toString(questions) + ", forumId=" + forumId + ", questionNo="
				+ questionNo + ", count=" + count + ", studentCount=" + studentCount + ", grade=" + grade + "]";
	}
	
}
