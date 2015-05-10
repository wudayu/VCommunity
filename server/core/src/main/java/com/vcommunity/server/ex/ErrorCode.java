package com.vcommunity.server.ex;

public interface ErrorCode {

	/**
	 * 请求成功执行
	 */
	static final int SUCCEED = 0;

	/**
	 * 内部异常
	 */
	static final int SERVER_EX = 1;

	/**
	 * 空指异常
	 */
	static final int NPE_EX = 2;

	/**
	 * IO异常
	 */
	static final int IO_EX = 3;

	/**
	 * 数据库访问异常
	 */
	static final int DB_EX = 4;

	/**
	 * 缓存异常
	 */
	static final int CACHE_EX = 5;

	/**
	 * 不支持此操作
	 */
	static final int UN_SUPPORTED = 6;

	/**
	 * 没有权限
	 */
	static final int NO_PERMISSON = 7;

	/**
	 * 非法参数
	 */
	static final int ILLEGAL_ARG = 8;

	/**
	 * 非法参数
	 */
	static final int ILLEGAL_ARG_FORMAT = 9;

	/**
	 * 参数不完整
	 */
	static final int MISSING_ARG = 10;

	/**
	 * 实体对象异常
	 */
	static final int ENTITY_EX = 11;

	/**
	 * 实体对象未找到
	 */
	static final int ENTITY_NOT_FOUND = 12;

	/**
	 * 实体对象已存在
	 */
	static final int ENTITY_EXISTS = 13;

	/**
	 * 校验错误
	 */
	static final int VALIDATION_EX = 14;

	/**
	 * 为实现错误
	 */
	static final int NOT_IMPL = 15;

	/**
	 * BIZ业务码不存在
	 */
	static final int BIZ_NOT_FOUND = 16;
}
