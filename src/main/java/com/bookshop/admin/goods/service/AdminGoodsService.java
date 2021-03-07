package com.bookshop.admin.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.goods.vo.GoodsVO;
import com.bookshop.goods.vo.ImageFileVO;
import com.bookshop.order.vo.OrderVO;

public interface AdminGoodsService {
	/** 관리자 상품 추가하기 **/
	public int addNewGoods(Map newGoodsMap) throws Exception;

	/** 관리자 상품 목록 가져오기 **/
	public List<GoodsVO> listNewGoods(Map condMap) throws Exception;

	/** 관리자 상품 상세보기 **/
	public Map goodsDetail(int goods_id) throws Exception;

	/** 관리자 상품 이미지 파일 가져오기 **/
	public List goodsImageFile(int goods_id) throws Exception;

	/** 관리자 상품 정보 수정하기 **/
	public void modifyGoodsInfo(Map goodsMap) throws Exception;
	
	/** 관리자 상품 이미지 수정하기 **/
	public void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception;

	/** 주문한 상품 목록 가져오기 **/
	public List<OrderVO> listOrderGoods(Map condMap) throws Exception;

	/** 주문한 상품 수정하기 **/
	public void modifyOrderGoods(Map orderMap) throws Exception;
	
	/** 관리자 상품 이미지 추가하기 **/
	public void addNewGoodsImage(List imageFileList) throws Exception;

	/** 관리자 상품 이미지 삭제하기 **/
	public void removeGoodsImage(int image_id) throws Exception;

}
