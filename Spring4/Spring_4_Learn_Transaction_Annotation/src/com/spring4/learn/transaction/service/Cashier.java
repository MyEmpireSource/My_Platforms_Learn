package com.spring4.learn.transaction.service;

import java.util.List;

public interface Cashier {
	
	public void checkout(String userName, List<String> isbnList);
	
}
