package com.hqyj.erp.exception;

/**
 * 业务相关exception
 * @author: HymanHu
 * @date: 2019年11月11日
 */
public class ErpException extends RuntimeException {
	private static final long serialVersionUID = 6056932528407692580L;
	private int status;
	private String reason;
    private TYPE type;

	public ErpException(String reason) {
		super();
		this.reason = reason;
	}

	public ErpException(int status, String reason) {
		super(reason);
		this.reason = reason;
		this.status = status;
	}
	
	public ErpException(String reason, Throwable cause) {
		super(reason, cause);
		this.reason = reason;
	}

	public ErpException(int status, String reason, Throwable cause) {
		super(reason, cause);
		this.status = status;
		this.reason = reason;
	}

	public ErpException(int status, String reason, TYPE type) {
		super(reason);
		this.status = status;
		this.reason = reason;
		this.type = type;
	}
	
	public ErpException(int status, String reason, TYPE type, Throwable cause) {
		super(reason, cause);
		this.status = status;
		this.reason = reason;
		this.type = type;
	}

    
	public String getReason() {
		return reason;
	}

	public int getStatus() {
		return status;
	}
	
	public TYPE getType() {
		return type;
	}

	public static enum TYPE {
		CLIENT_ERROR, //call had a 400 error
        SERVER_ERROR, //call had a 500 error
        ADAPTER_ERROR, //there was some kind of IO/Encoding/Adapting issue
        NO_CONTENT, //call came back with a 204 no content response
        UNKNOWN; //default error
	}
}
