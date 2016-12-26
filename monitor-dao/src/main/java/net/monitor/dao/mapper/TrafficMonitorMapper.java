package net.monitor.dao.mapper;

import net.monitor.dao.dto.TrafficMonitorDTO;
import net.monitor.dao.dto.TrafficMonitorDTOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrafficMonitorMapper {
    long countByExample(TrafficMonitorDTOExample example);

    int insert(TrafficMonitorDTO record);

    int insertSelective(TrafficMonitorDTO record);

    List<TrafficMonitorDTO> selectByExample(TrafficMonitorDTOExample example);

    TrafficMonitorDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrafficMonitorDTO record, @Param("example") TrafficMonitorDTOExample example);

    int updateByExample(@Param("record") TrafficMonitorDTO record, @Param("example") TrafficMonitorDTOExample example);

    int updateByPrimaryKeySelective(TrafficMonitorDTO record);

    int updateByPrimaryKey(TrafficMonitorDTO record);
}