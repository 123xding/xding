package cn.itcast.exception;

public class CustomerException extends Exception{
  //子定义异常类
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
