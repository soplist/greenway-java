package com.greenway.pojo.inter;

import java.util.List;

import com.greenway.pojo.impl.Gro;
import com.greenway.pojo.impl.User;

public interface IGroDAO {
	public List findByProperty(String propertyName, Object value);
	public List listGroupsByUserId(User user);
	public List<Gro> listGroupsBySummarize();
}
