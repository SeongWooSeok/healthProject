package models.calendar;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.*;

public class CalendarService {

	
		Map<String, Object> data = new HashMap();
		public Map<String, Object> get(CalendarRequest request){
			
			String [] dotw = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};//요일
			data.put("dotw", dotw);
			
			int year = request.getYear();
			int month = request.getMonth();
			
			if(year <= 0 || month <= 0) {
				LocalDate today = LocalDate.now();
				year = today.getYear();
				month = today.getMonthValue();
				
			}
			
			
			//시작일
			LocalDate M_start = LocalDate.of(year, month, 1);
			
			//마지막일
			LocalDate M_end = M_start.plusMonths(1).minusDays(1);
			
			int sDay = M_start.getDayOfMonth();
			int eDay = M_end.getDayOfMonth();
			int startPos = M_start.get(ChronoField.DAY_OF_WEEK) - 1;
			
			DecimalFormat df = new DecimalFormat("00");
			
			//이 달의 날짜 데이터
			List<String> days = new ArrayList<>();
			for(int i =1; i<= eDay + startPos ; i++) {
				String day = "";
				if(i>startPos) {
					day = df.format(i-startPos);
				}
				
				days.add(day);
			}
			
			data.put("days", days);
			//이달의 날짜 데이터 E
			
			/**지금 년, 월 S*/
			data.put("year", year);
			data.put("month", month);
			/**지금 년, 월 E*/
			
			
			/**이전 년, 월 S*/
			int prevYear = year;
			int prevMonth = month;
			if(month ==1) {
				prevYear = year -1;
				prevMonth = 12;
			}
			else {
				prevMonth --;
			}
			
			data.put("prevYear", prevYear);
			data.put("prevMonth", prevMonth);
			/**이전 년. 월 E*/
			
			/** 다음 년,월 S */
			int nextYear = year;
			int nextMonth = month;
			if (month == 12) {
				nextYear++;
				nextMonth =1; 
			} else {
				nextMonth++;
			}
			data.put("nextYear", nextYear);
			data.put("nextMonth", nextMonth);
			/** 이전 년,월 E */
			
			
			
			return data;
			
		}
}
