package com.itheima.bean;

public class Result implements java.io.Serializable {
	private boolean flag;   //执行结果，true为执行成功 false为执行失败
	private String message;//返回处理结果信息
	private Object result;//返回数据

	public Result() {
	}

	public Result(boolean flag, String message, Object result) {
		this.flag = flag;
		this.message = message;
		this.result = result;
	}


	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
