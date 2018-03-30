package net.monitor.dao.mapper;

import java.util.List;
import net.monitor.dao.dto.NetstatMonitorDTO;
import net.monitor.dao.dto.NetstatMonitorDTOExample;
import org.apache.ibatis.annotations.Param;

public interface NetstatMonitorMapper {

  long countByExample(NetstatMonitorDTOExample example);

  int insert(NetstatMonitorDTO record);

  int insertSelective(NetstatMonitorDTO record);

  List<NetstatMonitorDTO> selectByExample(NetstatMonitorDTOExample example);

  NetstatMonitorDTO selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") NetstatMonitorDTO record,
      @Param("example") NetstatMonitorDTOExample example);

  int updateByExample(@Param("record") NetstatMonitorDTO record,
      @Param("example") NetstatMonitorDTOExample example);

  int updateByPrimaryKeySelective(NetstatMonitorDTO record);

  int updateByPrimaryKey(NetstatMonitorDTO record);
}