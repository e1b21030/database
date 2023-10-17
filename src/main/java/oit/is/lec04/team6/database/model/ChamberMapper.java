package oit.is.lec04.team6.database.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChamberMapper {
    @Select("SELECT id,userName,chamberName from chamber where id = #{id}")
    Chamber selectById(int id);
}

