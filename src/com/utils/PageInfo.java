package com.utils;

import java.util.List;

/**
 * ��ҳʵ����
 * @author Administrator
 *
 * @param <T>
 */
public class PageInfo<T> {

	//ÿҳ��ʾ����
	private int pageSize;
	//��ǰ�ڼ�ҳ
	private int pageNumber;
	//��ҳ��
	private long total;
	//��ʼ��
	private int pageStart;
	//��ǰҳ��ʾ������
	private List<T> list;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	
}
