package com.pager;

import java.util.List;

/**
 * Description:�ο���http://bbs.csdn.net/topics/360010907 User: Darlen liu Date:
 * 14-6-24 Time: ����10:26
 */
public class Pager_demo<T> {
	private List<T> list; // �����¼�����
	private int totalRecode = 0; // �ܼ�¼��
	private int pageCount = 10; // ÿҳ��ʾ��¼��
	private int pageRecode = 1; // ��ҳ��
	private int curPageNum = 1; // ��ǰҳ

	private boolean isFirstPage = false; // �Ƿ�Ϊ��һҳ
	private boolean isLastPage = false; // �Ƿ�Ϊ���һҳ
	private boolean hasPreviousPage = false; // �Ƿ���ǰһҳ
	private boolean hasNextPage = false; // �Ƿ�����һҳ

	private int navigatePages = 8; // ����ҳ����
	private int[] navigatePageNumbers; // ���е���ҳ��

	public Pager_demo(int totalRecode, int curPageNum) {
		init(totalRecode, curPageNum, pageCount);
	}

	public Pager_demo(int totalRecode, int curPageNum, int pageCount) {
		init(totalRecode, curPageNum, pageCount);
	}

	private void init(int totalRecode, int curPageNum, int pageCount) {
		// ���û�������
		this.totalRecode = totalRecode;
		this.pageCount = pageCount;
		this.pageRecode = (this.totalRecode - 1) / this.pageCount + 1;

		// ����������ܴ���ĵ�ǰ��������Զ�����
		if (curPageNum < 1) {
			this.curPageNum = 1;
		} else if (curPageNum > this.pageRecode) {
			this.curPageNum = this.pageRecode;
		} else {
			this.curPageNum = curPageNum;
		}

		// ���������趨֮����е���ҳ��ļ���
		calcNavigatePageNumbers();

		// �Լ�ҳ��߽���ж�
		judgePageBoudary();
	}

	/**
	 * ���㵼��ҳ
	 */
	private void calcNavigatePageNumbers() {
		// ����ҳ��С�ڻ���ڵ���ҳ����ʱ
		if (pageRecode <= navigatePages) {
			navigatePageNumbers = new int[pageRecode];
			for (int i = 0; i < pageRecode; i++) {
				navigatePageNumbers[i] = i + 1;
			}
		} else { // ����ҳ�����ڵ���ҳ����ʱ
			navigatePageNumbers = new int[navigatePages];
			int startNum = curPageNum - navigatePages / 2;
			int endNum = curPageNum + navigatePages / 2;

			if (startNum < 1) {
				startNum = 1;
				// (��ǰnavigatePagesҳ
				for (int i = 0; i < navigatePages; i++) {
					navigatePageNumbers[i] = startNum++;
				}
			} else if (endNum > pageRecode) {
				endNum = pageRecode;
				// ���navigatePagesҳ
				for (int i = navigatePages - 1; i >= 0; i--) {
					navigatePageNumbers[i] = endNum--;
				}
			} else {
				// �����м�ҳ
				for (int i = 0; i < navigatePages; i++) {
					navigatePageNumbers[i] = startNum++;
				}
			}
		}
	}

	/**
	 * �ж�ҳ��߽�
	 */
	private void judgePageBoudary() {
		isFirstPage = curPageNum == 1;
		isLastPage = curPageNum == pageRecode && curPageNum != 1;
		hasPreviousPage = curPageNum > 1;
		hasNextPage = curPageNum < pageRecode;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * �õ���ǰҳ������
	 * 
	 * @return {List}
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * �õ���¼����
	 * 
	 * @return {int}
	 */
	public int getTotalRecode() {
		return totalRecode;
	}

	/**
	 * �õ�ÿҳ��ʾ��������¼
	 * 
	 * @return {int}
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * �õ�ҳ������
	 * 
	 * @return {int}
	 */
	public int getPageRecode() {
		return pageRecode;
	}

	/**
	 * �õ���ǰҳ��
	 * 
	 * @return {int}
	 */
	public int getCurPageNum() {
		return curPageNum;
	}

	/**
	 * �õ����е���ҳ��
	 * 
	 * @return {int[]}
	 */
	public int[] getNavigatePageNumbers() {
		return navigatePageNumbers;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public boolean hasPreviousPage() {
		return hasPreviousPage;
	}

	public boolean hasNextPage() {
		return hasNextPage;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[").append("total=").append(totalRecode).append(",pages=")
				.append(pageRecode).append(",pageNumber=").append(curPageNum)
				.append(",pageCount=").append(pageCount).append(",isFirstPage=")
				.append(isFirstPage).append(",isLastPage=").append(isLastPage)
				.append(",hasPreviousPage=").append(hasPreviousPage)
				.append(",hasNextPage=").append(hasNextPage)
				.append(",navigatePageNumbers=");
		int len = navigatePageNumbers.length;
		if (len > 0)
			sb.append(navigatePageNumbers[0]);
		for (int i = 1; i < len; i++) {
			sb.append(" " + navigatePageNumbers[i]);
		}
		sb.append(",list.size=" + list.size());
		sb.append("]");
		return sb.toString();
	}
}
