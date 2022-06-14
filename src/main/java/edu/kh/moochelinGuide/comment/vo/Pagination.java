package edu.kh.moochelinGuide.comment.vo;

public class Pagination {
	
	private int currentPage; // 현재 페이지 번호
	private int commentCount; // 코멘트 수
	
	// 보여질 코멘트 수 일단 모두 3개씩 보이게 하고
	// 추후에 2페이지부터 5개씩 보이게 조건문 변경 시도
	// 아마 html도 새로 만들어야하지 않을까...
	private int limit = 3; // 한 페이지에 보여질 게시글 수 
	
	private int limit2 = 5;
	////////////////////////////////////////////////////////////////////
	
	private int pageSize = 10;
	
	private int maxPage; // 마지막 페이지 번호
	private int startPage; // 시작 번호
	private int endPage; // 끝 번호
	
	private int prevPage; // 이전 목록 끝 번호
	private int nextPage; // 다음 목록 시작 번호
	
	// 생성자
	public Pagination(int currentPage, int commentCount) {
		this.currentPage = currentPage;
		this.commentCount = commentCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getcommentCount() {
		return commentCount;
	}

	public void setcommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getLimit2() {
		return limit2;
	}

	public void setLimit2(int limit2) {
		this.limit2 = limit2;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", commentCount=" + commentCount + ", limit=" + limit
				+ ", limit2=" + limit2 + ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}
	
	private void calculatePagination() {
		
		//최대 페이지 수 == 마지막 페이지 번호
		maxPage = (int)Math.ceil( (double)commentCount / limit );
		
		// 시작 페이지 계산
		startPage = (currentPage - 1) / pageSize * pageSize +1;
	}
	
}
