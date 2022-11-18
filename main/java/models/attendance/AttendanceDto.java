package models.attendance;


import java.time.LocalDateTime;

public class AttendanceDto {
	private String memNo; // 회원번호
	private String memId; // 아이디
	private String memNm; // 회원명 
	private LocalDateTime attDt; //출석 일자
	private String attDay; // 연속출석일수
	
	public String getMemNo() {
		return memNo;
	}
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemNm() {
		return memNm;
	}
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}
	
	public LocalDateTime getAttDt() {
		return attDt;
	}
	public void setAttDt(LocalDateTime attDt) {
		this.attDt = attDt;
	}
	public String getAttDay() {
		return attDay;
	}
	public void setAttDay(String attDay) {
		this.attDay = attDay;
	}
	@Override
	public String toString() {
		return "AttendanceDto [memNo=" + memNo + ", memId=" + memId + ", memNm=" + memNm + ", attDt=" + attDt
				+ ", attDay=" + attDay + ", getMemNo()=" + getMemNo() + ", getMemId()=" + getMemId() + ", getMemNm()="
				+ getMemNm() + ", getAttDt()=" + getAttDt() + ", getAttDay()=" + getAttDay() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
