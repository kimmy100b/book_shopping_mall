package com.bookshop.order.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop.order.vo.OrderVO;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private SqlSession sqlSession;

	/** 상품 주문 목차 보기 **/
	public List<OrderVO> listMyOrderGoods(OrderVO orderVO) throws DataAccessException {
		List<OrderVO> orderGoodsList = new ArrayList<OrderVO>();
		orderGoodsList = (ArrayList) sqlSession.selectList("mapper.order.selectMyOrderList", orderVO);
		return orderGoodsList;
	}

	/** 주문 추가하기 **/
	public void insertNewOrder(List<OrderVO> myOrderList) throws DataAccessException {
		int order_id = selectOrderID();
		System.out.println(">>"+order_id);
		OrderVO orderVO = null;
		for (int i = 0; i < myOrderList.size(); i++) {
			orderVO = (OrderVO) myOrderList.get(i);
		}
		orderVO.setOrder_id(order_id);
		sqlSession.insert("mapper.order.insertNewOrder", orderVO);
	}

	public OrderVO findMyOrder(String order_id) throws DataAccessException {
		OrderVO orderVO = (OrderVO) sqlSession.selectOne("mapper.order.selectMyOrder", order_id);
		return orderVO;
	}

	public void removeGoodsFromCart(OrderVO orderVO) throws DataAccessException {
		sqlSession.delete("mapper.order.deleteGoodsFromCart", orderVO);
	}

	public void removeGoodsFromCart(List<OrderVO> myOrderList) throws DataAccessException {
		for (int i = 0; i < myOrderList.size(); i++) {
			OrderVO orderVO = (OrderVO) myOrderList.get(i);
			sqlSession.delete("mapper.order.deleteGoodsFromCart", orderVO);
		}
	}

	/** 시퀀스로 된 orderID 찾기 **/
	private int selectOrderID() throws DataAccessException {
		return sqlSession.selectOne("mapper.order.selectOrderID");

	}
}
