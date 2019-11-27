package kr.co.connect.group.mapper;

import org.apache.ibatis.annotations.Insert;

import kr.co.connect.group.beans.GroupDto;

public interface GroupMapperInterface {

	@Insert("insert into taskgroup(groupname, manager, writeday) values(#{groupname},#{manager},now()")
	void insertData(GroupDto groupDtop);	
}
