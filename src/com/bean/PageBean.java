package com.bean;
import java.util.*;

import com.dao.UserDaoImpl;
public class PageBean {					// ����ҳ����Ƶ� JavaBean
	public int currentPage;				// ��ǰҳ��
	public int totalPage;				// ��ҳ��
	public int totalRows;				// ������
	public int rowsPage = 15;			// ÿҳ��ʾ������
	public ArrayList data;					// ��װҳ����ʾ������
	public PageBean(){}
	public void countTotalPage(){		// ������ҳ��
		if(totalRows%rowsPage==0){
			this.totalPage = totalRows/rowsPage;
		}
		else{
			this.totalPage = totalRows/rowsPage + 1;
		}
	}
	public ArrayList getData(){				
		return data;
	}
	public PageBean(UserDaoImpl contact) throws Exception{
		this.totalRows = contact.getTotalRows();	// �õ�������
		this.data = contact.getData();				// ���ز�ѯ���
		this.countTotalPage(); 
	}
}
