package net.monitor.dao.mapper;

import net.monitor.dao.dto.IOMonitorDTO;
import net.monitor.dao.dto.IOMonitorDTOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOMonitorMapper {
    long countByExample(IOMonitorDTOExample example);

    int insert(IOMonitorDTO record);

    int insertSelective(IOMonitorDTO record);

    List<IOMonitorDTO> selectByExample(IOMonitorDTOExample example);

    IOMonitorDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IOMonitorDTO record, @Param("example") IOMonitorDTOExample example);

    int updateByExample(@Param("record") IOMonitorDTO record, @Param("example") IOMonitorDTOExample example);

    int updateByPrimaryKeySelective(IOMonitorDTO record);

    int updateByPrimaryKey(IOMonitorDTO record);
}