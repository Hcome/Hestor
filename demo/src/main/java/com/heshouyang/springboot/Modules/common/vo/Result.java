package com.heshouyang.springboot.Modules.common.vo;

/**
 * @Description: Result
 * @author: HymanHu
 * @date: 2020年3月25日
 */
public class Result {

	private int status;
	private String message;
	private Object object;

	public Result() {
	}

	public Result(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Result(int status, String message, Object object) {
		this.status = status;
		this.message = message;
		this.object = object;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * @Description: Result Status
	 * @author: HymanHu
	 * @date: 2020年4月3日
	 */
	public enum ResultStatus {
		SUCCESS(200), FAILED(500);
		
		public int status;

		private ResultStatus(int status) {
			this.status = status;
		}
	}
	
}
