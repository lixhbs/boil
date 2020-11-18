package com.boil.dao;

import com.boil.model.Timedtask;
import com.boil.model.TimedtaskExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TimedtaskMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    long countByExample(TimedtaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int deleteByExample(TimedtaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int insert(Timedtask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int insertSelective(Timedtask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    List<Timedtask> selectByExample(TimedtaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    Timedtask selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int updateByExampleSelective(@Param("record") Timedtask record, @Param("example") TimedtaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int updateByExample(@Param("record") Timedtask record, @Param("example") TimedtaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int updateByPrimaryKeySelective(Timedtask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int updateByPrimaryKey(Timedtask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int batchInsert(@Param("list") List<Timedtask> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    int batchInsertSelective(@Param("list") List<Timedtask> list, @Param("selective") Timedtask.Column ... selective);
}