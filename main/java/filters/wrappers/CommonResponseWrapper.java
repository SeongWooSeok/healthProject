package filters.wrappers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CommonResponseWrapper extends HttpServletResponseWrapper {

	public CommonResponseWrapper(HttpServletResponse response) {
		super(response);
	}
}