package com.code119.myapp.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class AbstractDAOImpl<E, K> implements AbstractDAO<E, K>{
	
	@Inject //¶Ç´Â Autowired
	private SqlSession sqlSession;

	@Override
	public E getOne(String queryId, K key) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(queryId, key);
	}

	@Override
	public List<E> getList(String queryId, K key) {
		return sqlSession.selectList(queryId, key);
	}

	@Override
	public int insert(String queryId, K key) {
		// TODO Auto-generated method stub
		return sqlSession.insert(queryId, key);
	}

	@Override
	public int delete(String queryId, K key) {
		// TODO Auto-generated method stub
		return sqlSession.delete(queryId, key);
	}
	
	@Override
	public int update(String queryId, K key) {
		// TODO Auto-generated method stub
		return sqlSession.update(queryId, key);
	}
}
