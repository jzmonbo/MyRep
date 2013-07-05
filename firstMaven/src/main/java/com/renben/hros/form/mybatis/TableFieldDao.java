package com.renben.hros.form.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.renben.hros.form.model.TableField;

@Component
public interface TableFieldDao {
	
	@Select("select * from tableField where tablename = #{tableName}") 
	public List<TableField> getTableField(String tableName);
}
