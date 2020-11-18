package com.boil.common.result;

/**
 * @author Lix.
 * @date Sep 6, 2017 5:34:18 PM 
 */
public enum ResultCode
{

	/**
	 * 成功
	 */
	SUCCESS(0, "成功"),

	/**
	 * 失败
	 */
	FAIL(1001, "失败"),

	/**
	 * 异常
	 */
	EXCEPTION(9001, "异常"),

	/**
	 * 参数异常
	 */
	PARAMETER_EXCEPTION(9002, "参数异常"),

	/**
	 * 用户
	 */
	ACCOUNT(8001, "用户"),

	/**
	 * 未获取登录信息
	 */
	ACCOUNT_LOGIN_FALSE(8404, "未获取登录信息");


	private ResultCode(int value, String msg)
	{
		this.val = value;
		this.msg = msg;
	}

	public int val()
	{
		return val;
	}

	public String msg()
	{
		return msg;
	}

	private final int val;
	private final String msg;
}
