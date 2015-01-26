package com.xinglongjian.bigdata.restful.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;




/**
 * Define a Order Resource
 * @author root
 *
 */
@Path("orders")
public class OrderResource {
	
	 BlockingQueue<Runnable> queue=new ArrayBlockingQueue<Runnable>(10); 
	 ThreadPoolExecutor executor=new ThreadPoolExecutor(3, 5, 3, TimeUnit.SECONDS, queue);
	 
//	 @GET
//	 @Path("asyn")
//	 public void getAll(@Suspended final AsyncResponse ar,@QueryParam("start") final int from,@QueryParam("length") final int length) {     
//		
//		 executor.submit(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					Thread.sleep(5000);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				 List<Order> orders=new ArrayList<Order>();
//				 orders.add(new Order("1111", "1111", 10, new Date()));
//				 orders.add(new Order("2222", "2222", 12, new Date()));
//				 orders.add(new Order("3333", "3333", 13, new Date()));
//				 orders.add(new Order("4444", "4444", 14, new Date()));
//				 orders.add(new Order("5555", "5555", 15, new Date()));
//				 ar.resume(orders.subList(from, from+length)); 
//			}
//		 });
//	 }
	 
	 @GET  
	 public List<Order> getAll(@QueryParam("start")int from,@QueryParam("length")int length) {     
		 List<Order> orders=new ArrayList<Order>();
		 orders.add(new Order("1111", "1111", 10, new Date()));
		 orders.add(new Order("2222", "2222", 12, new Date()));
		 orders.add(new Order("3333", "3333", 13, new Date()));
		 orders.add(new Order("4444", "4444", 14, new Date()));
		 orders.add(new Order("5555", "5555", 15, new Date()));
		 return orders.subList(from, from+length);
	 }
	 
	 @GET  
	 @Path("{oid}")  
	 public Order getOrder(@PathParam("oid")String id) {   
		 List<Order> orders=getAll(0,5);
		 for(Order o:orders)
		 {
			 if(o.getOrderNo().equals(id))
				 return o;
		 }
		 return null; 
	 }
}
