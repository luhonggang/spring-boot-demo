package com.shanlin.result;

/**
 * 返回前端的异常参数类
 * @param <T>
 */
public class BaseResponse<T> {

	private String code;

	private String messages;

	private T data;

	public BaseResponse() {
	}

	public BaseResponse(String code, String messages) {
		super();
		this.code = code;
		this.messages = messages;
	}

	public BaseResponse(String code, String messages, T data) {
		super();
		this.code = code;
		this.messages = messages;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static BaseResponse fail(String code, String message) {
		return new BaseResponse(code, message);
	}

}