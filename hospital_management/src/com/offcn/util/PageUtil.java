package com.offcn.util;

public class PageUtil {
	private int size;
	private int page;
	private int index;
	private int countRows;
	private int countPage;
	private int prevPage;
	private int nextPage;
	
	public PageUtil(int size,String page,int countRows) {
		this.size = size;
		this.countRows = countRows;
		init_page(page);
		init_index();
		init_countPage();
		init_prevPage();
		init_nextPage();
	}
	
	//初始化页码
	private void init_page(String page) {
		if(page == null || "".equals(page)) {
			this.page = 1;
		}else {
			this.page = Integer.parseInt(page);
		}
	}
	
	//初始化索引（偏移量）
	private void init_index() {
		this.index = (this.page-1)*this.size;
	}
	
	//初始化总页数
	private void init_countPage() {
		if(this.countRows % this.size == 0) {
			this.countPage = this.countRows / this.size;
		}else {
			this.countPage = this.countRows / this.size + 1;
		}
	}
	
	//初始化当前页的上一页的页码
	private void init_prevPage() {
		if(this.page == 1) {
			this.prevPage = 1;
		}else {
			this.prevPage = this.page - 1;
		}
	}
	
	//初始化当前页的下一页的页码
	private void init_nextPage() {
		if(this.page == this.countPage) {
			this.nextPage = this.countPage;
		}else {
			this.nextPage = this.page + 1;
		}
	}

	public int getSize() {
		return size;
	}

	public int getPage() {
		return page;
	}

	public int getIndex() {
		return index;
	}

	public int getCountRows() {
		return countRows;
	}

	public int getCountPage() {
		return countPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}
}
