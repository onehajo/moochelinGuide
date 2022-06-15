package edu.kh.moochelinGuide.comment.vo;

	public class Pagination {
		// 페이지네이션(페이징 처리)에 필요한 모든 값들을 저장하고 있는 객체
		
		private int currentPage;		// 현재 페이지 번호
		private int listCount;			// 전체 게시글 수
		
		private int limit = 3;			// 한 페이지에 보여질 게시글의 수
		private int pageSize = 10;		// 목록 하단 페이지 번호의 노출 개수
			
		private int maxPage;			// 제일 큰 페이지 번호 == 마지막 페이지 번호
		private int startPage;			// 목록 하단에 노출된 페이지의 시작 번호
		private int	endPage;			// 목록 하단에 노출된 페이지의 끝 번호
		
		private int prevPage;			// 목록 하단에 노출된 번호의 이전 목록 끝 번호
		private int nextPage;			// 목록 하단에 노출된 번호의 다음 목록 시작 번호
			
		
		// 생성자
		public Pagination(int currentPage, int listCount) {
			this.currentPage = currentPage;
			this.listCount = listCount;
			
			calculatePagination(); // 계산 메서드 호출
		}


		public int getCurrentPage() {
			return currentPage;
		}


		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
			
			calculatePagination();
		}


		public int getListCount() {
			return listCount;
		}


		public void setListCount(int listCount) {
			this.listCount = listCount;
			
			calculatePagination();
		}


		public int getLimit() {
			return limit;
		}


		public void setLimit(int limit) {
			this.limit = limit;
			
			calculatePagination();
		}


		public int getPageSize() {
			return pageSize;
		}


		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
			
			calculatePagination();
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
			return "Pagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
					+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
					+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
		}
		
		
		
		
		private void calculatePagination() {
			
			
			
			maxPage = (int)Math.ceil(  (double)listCount / limit  );
			
			
			
		
			
			startPage = (currentPage - 1) / pageSize * pageSize + 1;
			
			
			
			

			endPage = startPage + pageSize - 1;
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			
			
			
			if(currentPage <= pageSize) { 
				prevPage = 1;
			}else {
				prevPage = startPage - 1;
			}
			
			
			if(endPage == maxPage) {
				nextPage = maxPage;
			}else {
				nextPage = endPage + 1;
			}
			
			
		}}
	