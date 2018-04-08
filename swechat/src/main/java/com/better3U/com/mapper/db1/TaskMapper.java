package com.better3U.com.mapper.db1;

import com.better3U.com.model.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//import org.apache.ibatis.annotations.Delete;

/**
 * 2018年1月25日
 * @author JiangHong
 * TSS任务DAO
 */
@Repository
public interface TaskMapper {
	/**
	 * 查询任务列表
	 * @return
	 */
	@Select("select tssid,tssname,tssdate,to_char(tssdate,'yyyy-mm-dd hh24:mi:ss') as tssdatestr,servicechange,tsstype,tssdept,deptoffice,tssuserId,nvl(responsmain,'无') as responsmain,modifytime,to_char(modifytime,'yyyy-mm-dd hh24:mi:ss') as modifytimestr,seqId,nvl(rating,0) as rating,nvl(ratingcomt,'无') as ratingcomt,emerglevel from Tbl_Task_180125 where isdelete=0 order by emerglevel desc, tssdate desc")
    public List<Task> selectTask();
	
	/**
	 * 查询本部门任务列表
	 * @return
	 */
	@Select("select tssid,tssname,tssdate,to_char(tssdate,'yyyy-mm-dd hh24:mi:ss') as tssdatestr,servicechange,tsstype,tssdept,deptoffice,tssuserId,nvl(responsmain,'无') as responsmain,modifytime,to_char(modifytime,'yyyy-mm-dd hh24:mi:ss') as modifytimestr,seqId,nvl(rating,0) as rating,nvl(ratingcomt,'无') as ratingcomt,emerglevel from Tbl_Task_180125 where isdelete=0 and tssdept = #{tssDept} order by emerglevel desc, tssdate desc")
    public List<Task> selectTaskDept(String tssDept);
	
	
	/**
	 * 查询单个任务
	 * @param id 任务seqid
	 * @return
	 */
	@Select("select * from Tbl_Task_180125 where seqid = #{seqId}")
    public Task selectTaskById(String seqId);
	
	/**
	 * 新增任务
	 * @param task 任务对象
	 */
	@Insert("insert into Tbl_Task_180125(tssid,seqid) values (#{tssId},SEQ_TASKID.NEXTVAL)")
    public void addTask(Task task);
	
	/**
	 * 评价任务
	 * @param task 任务对象
	 */
	@Update("update Tbl_Task_180125 set rating=#{rating},ratingcomt=#{ratingComt} where seqid=#{seqId}")
    public void evaluateTask(Task task);	
	
	/**
	 * 修改任务优先级
	 * @param task 任务对象
	 */
	@Update("update Tbl_Task_180125 set emerglevel= to_number(emerglevel)+1 where seqid=#{seqId}")
    public void updateTaskLevel(Task task);
	
	/**
	 * 逻辑删除任务
	 * @param id 任务seqid
	 */
	/*@Delete("delete from Tbl_Task_180125 where seqid=#{id}")
    public void deleteTask(String id);*/
	@Update("update Tbl_Task_180125 set isdelete=1,updateuserid=#{updateUserID},modifyTime=sysdate where seqid=#{seqId}")
    public void deleteTask(Task task);
}
