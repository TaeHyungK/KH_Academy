package kr.spring.ch04.controller;

public class PageRank {
	private int rank;
	private String page;
	
	public PageRank() {
		
	}
	
	public PageRank(int rank, String page) {
		super();
		this.rank = rank;
		this.page = page;
	}

	public int getRank() {
		return rank;
	}

	public String getPage() {
		return page;
	}
	
	
}
