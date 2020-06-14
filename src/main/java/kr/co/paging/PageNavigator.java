package kr.co.paging;

import lombok.Data;

@Data
public class PageNavigator {

	private int countPerPage; // 페이지당 글목록 수
	private int pagePerGroup; // 그룹당 페이지 수
	private int currentPage; // 현재 페이지 ( 최근 글이 1부터 시작 )
	private int totalRecordsCount; // 전체 글 수
	private int totalPageCount; // 전체 페이지 수
	private int currentGroup; // 현재 그룹 ( 최근 그룹이 0부터 시작 )
	private int startPageGroup; // 현재 그룹의 첫 페이지
	private int endPageGroup; // 현재 그룹의 마지막 페이지
	private int startRecord; // 전체 레코드 중 현재 페이지 첫 글의 위치 ( 0 부터 시작 )

	public PageNavigator(int countPerPage, int pagePerGroup, int currentPage, int totalRecordsCount) {
		// 페이지당 글 수 , 그룹당 페이지 수 , 현재 페이지 , 전체 글 수를 전달 받음
		this.countPerPage = countPerPage;
		this.pagePerGroup = pagePerGroup;
		this.totalRecordsCount = totalRecordsCount;
		
		// 전체 페이지 수 
		totalPageCount = (totalRecordsCount+countPerPage-1)/countPerPage;
		
		// 전달된 현재 페이지가 1보다 작으면 현재 페이지를 1페이지로 지정
		if(currentPage < 1)
			currentPage = 1;
		if(currentPage > totalPageCount)
			currentPage = totalPageCount;
		
		this.currentPage = currentPage;
		
		// 현재 그룹
		currentGroup = (currentPage-1)/pagePerGroup;
		
		// 현재 그룹의 첫 페이지
		startPageGroup = currentGroup * pagePerGroup+1;
				
		startPageGroup = startPageGroup < 1 ? 1 : startPageGroup;
		
		// 현재 그룹의 마지막 페이지  ex:) 1 페이지의 마지막 페이지는 10으로 할 것이다 
		// 10 = 1 + 10 - 1 
		endPageGroup = startPageGroup+ pagePerGroup -1;
		
		// 전체 레코드 중 현재 페이지 첫 글의 위치
		endPageGroup = endPageGroup < totalPageCount ? endPageGroup : totalPageCount;
	}

}
