package common;

public interface MoblieValidator {
	/**휴대전화번호 형식 체크 */
	default boolean checkMobileNum(String mobile) {
		
		mobile = mobile.replaceAll("[^0-9]", "");
		
		String pattern = "01[0169]\\d{3,4}\\d{4}";
		
		boolean result = mobile.matches(pattern);
		
		return result;
	}
}
