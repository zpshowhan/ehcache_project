package com.luo.service;

import java.util.List;

public interface EhCacheTestService {
	public String getTimestamp(String param);
	
	public void update(String param);
	
	public String add(String param);
	
	public List select(String param);
	
	public void delete(String param);
}
