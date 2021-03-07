package com.bookshop.admin.goods.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.admin.goods.dao.AdminGoodsDAO;
import com.bookshop.goods.vo.GoodsVO;
import com.bookshop.goods.vo.ImageFileVO;
import com.bookshop.order.vo.OrderVO;

@Service("adminGoodsService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminGoodsServiceImpl implements AdminGoodsService {
	@Autowired
	private AdminGoodsDAO adminGoodsDAO;

	/** 관리자 상품 추가하기 **/
	@Override
	public int addNewGoods(Map newGoodsMap) throws Exception {
		int goods_id = adminGoodsDAO.insertNewGoods(newGoodsMap);
		
		ArrayList<ImageFileVO> imageFileList = (ArrayList) newGoodsMap.get("imageFileList");
		
		for (ImageFileVO imageFileVO : imageFileList) {
			imageFileVO.setGoods_id(goods_id);
		}
		
		adminGoodsDAO.insertGoodsImageFile(imageFileList);
		
		return goods_id;
	}

	/** 관리자 상품 목록 가져오기 **/
	@Override
	public List<GoodsVO> listNewGoods(Map condMap) throws Exception {
		return adminGoodsDAO.selectNewGoodsList(condMap);
	}

	/** 관리자 상품 상세보기 **/
	@Override
	public Map goodsDetail(int goods_id) throws Exception {
		Map goodsMap = new HashMap();
		GoodsVO goodsVO = adminGoodsDAO.selectGoodsDetail(goods_id);
		List imageFileList = adminGoodsDAO.selectGoodsImageFileList(goods_id);
		goodsMap.put("goods", goodsVO);
		goodsMap.put("imageFileList", imageFileList);
		return goodsMap;
	}

	/** 관리자 상품 이미지 파일 가져오기 **/
	@Override
	public List goodsImageFile(int goods_id) throws Exception {
		List imageList = adminGoodsDAO.selectGoodsImageFileList(goods_id);
		return imageList;
	}

	/** 관리자 상품 정보 수정하기 **/
	@Override
	public void modifyGoodsInfo(Map goodsMap) throws Exception {
		adminGoodsDAO.updateGoodsInfo(goodsMap);

	}

	/** 관리자 상품 이미지 수정하기 **/
	@Override
	public void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception {
		adminGoodsDAO.updateGoodsImage(imageFileList);
	}

	/** 주문한 상품 목록 가져오기 **/
	@Override
	public List<OrderVO> listOrderGoods(Map condMap) throws Exception {
		return adminGoodsDAO.selectOrderGoodsList(condMap);
	}

	/** 주문한 상품 수정하기 **/
	@Override
	public void modifyOrderGoods(Map orderMap) throws Exception {
		adminGoodsDAO.updateOrderGoods(orderMap);
	}

	/** 관리자 상품 이미지 추가하기 **/
	@Override
	public void addNewGoodsImage(List imageFileList) throws Exception {
		adminGoodsDAO.insertGoodsImageFile(imageFileList);
	}

	/** 관리자 상품 이미지 삭제하기 **/
	@Override
	public void removeGoodsImage(int image_id) throws Exception {
		adminGoodsDAO.deleteGoodsImage(image_id);
	}
}
