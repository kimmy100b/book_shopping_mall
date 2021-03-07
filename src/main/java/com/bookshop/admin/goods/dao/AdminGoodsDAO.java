package com.bookshop.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bookshop.goods.vo.GoodsVO;
import com.bookshop.goods.vo.ImageFileVO;
import com.bookshop.order.vo.OrderVO;

public interface AdminGoodsDAO {
	/** 관리자 상품 추가하기 **/
	public int insertNewGoods(Map newGoodsMap) throws DataAccessException;

	/** 관리자 상품 목록 가져오기 **/
	public List<GoodsVO> selectNewGoodsList(Map condMap) throws DataAccessException;

	/** 관리자 상품 상세정보 가져오기 **/
	public GoodsVO selectGoodsDetail(int goods_id) throws DataAccessException;

	/** 관리자 상품 이미지 파일 가져오기 **/
	public List selectGoodsImageFileList(int goods_id) throws DataAccessException;

	/** 관리자 상품 이미지 파일 추가하기 **/
	public void insertGoodsImageFile(List fileList) throws DataAccessException;

	/** 관리자 상품 정보 수정하기 **/
	public void updateGoodsInfo(Map goodsMap) throws DataAccessException;

	/** 관리자 상품 이미지 수정하기 **/
	public void updateGoodsImage(List<ImageFileVO> imageFileList) throws DataAccessException;

	/** 관리자 상품 이미지 삭제하기 **/
	public void deleteGoodsImage(int image_id) throws DataAccessException;

	/** 관리자 상품 이미지 삭제하기 **/
	public void deleteGoodsImage(List fileList) throws DataAccessException;

	/** 주문한 상품 목록 가져오기 **/
	public List<OrderVO> selectOrderGoodsList(Map condMap) throws DataAccessException;

	/** 주문한 상품 수정하기 **/
	public void updateOrderGoods(Map orderMap) throws DataAccessException;
}
