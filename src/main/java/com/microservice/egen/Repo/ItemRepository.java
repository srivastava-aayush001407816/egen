package com.microservice.egen.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microservice.egen.data.model.Item;

public interface ItemRepository extends CrudRepository<Item,Integer>{
	
//	@Query("select i.name, i.qty from Items i where i.order_id = ?1")
//    ArrayList<Item> getItemsDetails(int oid);
	
	List<Item> findByOrder_id(int orderid);

}
