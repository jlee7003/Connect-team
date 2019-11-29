package kr.co.connect.group.mapper;

import org.apache.ibatis.annotations.Insert;

import kr.co.connect.group.beans.GroupDto;

public interface GroupMapperInterface {

	// 그룹 생성시 manager = email 
	@Insert("insert into taskgroup(groupname, manager, email, writeday) values(#{groupname}, #{manager}, #{email}, now()")
	void insertData(GroupDto groupDto);
}
