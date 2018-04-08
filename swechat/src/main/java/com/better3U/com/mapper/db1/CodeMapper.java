package com.better3U.com.mapper.db1;

import com.better3U.com.model.Code;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//import org.apache.ibatis.annotations.Delete;

/**
 * 2018年3月20日
 * @author ZouLinFang
 * DAO
 */
@Repository
public interface CodeMapper {
	/**
	 * 查询任务列表
	 * @return
	 */
	@Select("select * from \"3UPA\".TBL_CITY_CODE t")
    public List<Code> selectCode();
}
