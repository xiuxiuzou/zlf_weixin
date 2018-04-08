package com.better3U.com.mapper.db2;

import com.better3U.com.model.LivingExpense;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivingExpenseMapper {
    /*
     * @todo  批量插入
     * @param livingExpensesList list
     * @return
     * @author tangyuan
     * @date 2018/3/14 16:33
     */
    @Insert("<script>" +
            "   insert into livingExpenseTable (category,spendPerMonth,leftMoney,depositMoney,addTime,seeTime)" +
            "    <foreach collection='list' item='item' index='index' separator='union all' > " +
            "    select #{item.category,jdbcType=NUMERIC},#{item.spendPerMonth,jdbcType=NUMERIC},#{item.leftMoney,jdbcType=NUMERIC},#{item.depositMoney,jdbcType=NUMERIC},#{item.addTime,jdbcType=DATE},#{item.seeTime,jdbcType=DATE} from dual" +
            "    </foreach>" +
            "   </script>")
    public void insert(List<LivingExpense> livingExpensesList);
}
