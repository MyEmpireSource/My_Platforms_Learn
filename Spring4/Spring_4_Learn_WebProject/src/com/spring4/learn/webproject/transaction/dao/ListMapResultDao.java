package com.spring4.learn.webproject.transaction.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @Package: com.spring4.learn.webproject.transaction.dao
 * @ClassName: ListMapResultDao.java
 *
 * @Description: List<Map<String, String>> 方式
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年3月29日 下午2:55:47
 * @UpdateDate: 2018年3月29日 下午2:55:47
 * @Version: V1.0
 */
public interface ListMapResultDao {
	
public List<Map<String, String>> queryChildFxb(String fid);
	
	public List<Map<String, String>> queryFxdInfo(String fxbid);
	
	public List<Map<String, String>> queryOAFgzdInfo(int pageIndex, int pageSize);
	
	public int queryOAFgzdCount();
	
	public List<Map<String, String>> queryFlFgInfo(int wdid, int pageIndex, int pageSize);
	
	public List<Map<String, String>> querySjgzgfInfo(int wdid, String scr, int pageIndex, int pageSize);
	
	public int queryFlFgCountWithWdid(int wdid);
}
