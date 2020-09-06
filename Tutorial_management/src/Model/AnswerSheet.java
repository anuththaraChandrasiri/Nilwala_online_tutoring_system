package Model;

public class AnswerSheet {

	private String material ;
	private String sheet_name ;
	private String date_added;
	private String sheet_id ;	
	private String tute_id ;
	private String subject_code ;
	private String teacher_id ;
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSheet_name() {
		return sheet_name;
	}
	public void setSheet_name(String sheet_name) {
		this.sheet_name = sheet_name;
	}
	public String getDate_added() {
		return date_added;
	}
	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}
	public String getSheet_id() {
		return sheet_id;
	}
	public void setSheet_id(String sheet_id) {
		this.sheet_id = sheet_id;
	}
	public String getTute_id() {
		return tute_id;
	}
	public void setTute_id(String tute_id) {
		this.tute_id = tute_id;
	}
	public String getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	@Override
	public String toString() {
		return "AnswerSheet [material=" + material + ", sheet_name=" + sheet_name + ", date_added=" + date_added
				+ ", sheet_id=" + sheet_id + ", tute_id=" + tute_id + ", subject_code=" + subject_code + ", teacher_id="
				+ teacher_id + "]";
	}
	
	
	
}
