package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.Product;
import com.briup.crm.common.bean.ProductExample;
import com.briup.crm.common.bean.Storage;
import com.briup.crm.common.bean.StorageExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.ProductMapper;
import com.briup.crm.dao.StorageMapper;
import com.briup.crm.service.interfaces.IBasicDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BasicDataServiceImpl implements IBasicDataService {
	@Autowired
	private StorageMapper storageMapper;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public PageInfo<Product> findProduct(Product product, int curPage, int row) throws CrmCommonException {
		if (product == null) {
			throw CrmCommonException.getException(403);
		}
		PageHelper.startPage(curPage, row);
		ProductExample example = new ProductExample();
		example.createCriteria()
				.andProdNameLike("%" + product.getProdName() + "%")
				.andProdTypeLike("%" + product.getProdType() + "%")
				.andProdBatchLike("%" + product.getProdBatch() + "%");
		List<Product> list = productMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public PageInfo<Product> findProductAll(int curPage, int row) throws CrmCommonException {
		PageHelper.startPage(curPage, row);
		ProductExample example = new ProductExample();
		List<Product> list = productMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public PageInfo<Storage> findStorageAll(int curpage, int row) throws CrmCommonException {
		PageHelper.startPage(curpage, row);
		StorageExample example = new StorageExample();
		List<Storage> list = storageMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public PageInfo<Storage> findStorage(Storage storage, int curPage, int row) throws CrmCommonException {
		if (storage == null) {
			throw CrmCommonException.getException(403);
		}
		PageHelper.startPage(curPage, row);
		StorageExample example = new StorageExample();
		example.createCriteria().andStkNameLike("%" + storage.getStkName() + "%")
				.andStkWarehourseLike("%" + storage.getStkWarehourse() + "%");
		List<Storage> list = storageMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

}
