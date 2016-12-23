package net.monitor.dao.mapper;

import net.monitor.dao.dto.ProcessMonitorDTO;
import net.monitor.dao.dto.ProcessMonitorDTOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMonitorMapper {
    long countByExample(ProcessMonitorDTOExample example);

    int insert(ProcessMonitorDTO record);

    int insertSelective(ProcessMonitorDTO record);

    List<ProcessMonitorDTO> selectByExample(ProcessMonitorDTOExample example);

    ProcessMonitorDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProcessMonitorDTO record, @Param("example") ProcessMonitorDTOExample example);

    int updateByExample(@Param("record") ProcessMonitorDTO record, @Param("example") ProcessMonitorDTOExample example);

    int updateByPrimaryKeySelective(ProcessMonitorDTO record);

    int updateByPrimaryKey(ProcessMonitorDTO record);
}