package com.spring4.learn.webproject.transaction.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring4.learn.webproject.transaction.dao.ListMapResultDao;
import com.spring4.learn.webproject.util.log.LoggerFactory;
import com.spring4.learn.webproject.util.log.ServiceDaoLog;

@Repository("listMapResultDao")
public class ListMapResultDaoImpl implements ListMapResultDao {

	private Logger logger = LoggerFactory.getLoggerByName(ListMapResultDao.class.getName());
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @Title: queryMethod
	 * @Description: 统一调用方法
	 * 
	 * @Params:
	 *   @param sqlStr
	 *   @param params
	 *   @param mapKeyArray
	 *   @return
	 *
	 * @Return: List<Map<String,String>>
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年3月29日 下午3:14:39
	 * @ChangeDate: 2018年3月29日 下午3:14:39
	 * @Author: ZCX
	 */
	private List<Map<String, String>> queryMethod(String sqlStr, Object[] params, final String[] mapKeyArray) {
		
		try {
			return this.jdbcTemplate.query(
					sqlStr, 
					params, 
					new RowMapper<Map<String, String>>() {
						public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
							Map<String, String> resultMap = new HashMap<String, String> ();
							
							for (String key : mapKeyArray) {
								resultMap.put(key, rs.getString(key));
							}
							
							return resultMap;
						}
					});
		
		} catch (Exception e) {
			logger.error(ServiceDaoLog.serviceDaoLog(e.getMessage()));
			return null;
		}
		
	}
	
	@Override
	public List<Map<String, String>> queryChildFxb(String fid) {
		// TODO Auto-generated method stub
		return this.queryMethod("SELECT * FROM sj_bzfxb WHERE fid = ?", new Object[] {fid}, new String[] {"fxbid", "fxbmc"});
	}

	@Override
	public List<Map<String, String>> queryFxdInfo(String fxbid) {
		// TODO Auto-generated method stub
		return this.queryMethod("SELECT * FROM sj_bzfxd WHERE fxbid = ?", new Object[] {fxbid}, new String[] {"fxdid", "fxmc", "fxbh"});
	}

	@Override
	public List<Map<String, String>> queryOAFgzdInfo(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.queryMethod("SELECT id, zdTypeName, zdbh, fwname, draftDateStr, qfDateTimeStr, sstimeStr FROM oa_fgzd ORDER BY qfDateTimeStr DESC LIMIT ?, ? ", new Object[] {pageIndex, pageSize}, new String[] {"id", "zdTypeName", "zdbh", "fwname", "draftDateStr", "qfDateTimeStr", "sstimeStr"});
	}

	@Override
	public int queryOAFgzdCount() {
		// TODO Auto-generated method stub
		try {
			return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM oa_fgzd", Integer.class).intValue();
		} catch (Exception e) {
			logger.error(ServiceDaoLog.serviceDaoLog(e.getMessage()));
			return -1;
		}
	}

	@Override
	public List<Map<String, String>> queryFlFgInfo(int wdid, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.queryMethod("SELECT fjid, wdid, wjm FROM xt_zswdwh WHERE wdid = ? ORDER BY fwsj DESC LIMIT ?, ?", new Object[] {wdid, pageIndex, pageSize}, new String[] {"fjid", "wdid", "wjm"});
	}

	@Override
	public List<Map<String, String>> querySjgzgfInfo(int wdid, String scr, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.queryMethod("SELECT fjid, wdid, wjm FROM xt_zswdwh WHERE wdid = ? ORDER BY fwsj DESC LIMIT ?, ?", new Object[] {wdid, pageIndex, pageSize}, new String[] {"fjid", "wdid", "wjm"});
	}

	@Override
	public int queryFlFgCountWithWdid(int wdid) {
		// TODO Auto-generated method stub
		try {
			return this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM xt_zswdwh  wdid = ? ", Integer.class, wdid).intValue();
		} catch (Exception e) {
			logger.error(ServiceDaoLog.serviceDaoLog(e.getMessage()));
			return -1;
		}
	}

}
