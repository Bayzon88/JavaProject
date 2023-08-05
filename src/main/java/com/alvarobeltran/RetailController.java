package com.alvarobeltran;

import java.util.*;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Products;
import com.model.Users;
import com.requestmodels.NewOrdersModel;
import com.requestmodels.NewProductModel;
import com.services.OrdersService;
import com.services.UsersServices;
import com.services.ProductsServices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Parameter;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import com.services.RetailService;

@Controller
public class RetailController {

	

	
	@PostMapping(value="/createneworder" )
	public String createNewOrder(@ModelAttribute NewOrdersModel newOrdersModel ) { 
		System.out.println(newOrdersModel.getOrder_id());
		System.out.println(newOrdersModel.getOrder_date());
		System.out.println(newOrdersModel.getOrder_quantity());
		System.out.println("user id " + newOrdersModel.getUser_id());
		System.out.println(newOrdersModel.getProduct_id());
		int order_id = Integer.valueOf(newOrdersModel.getOrder_id());
		String order_date = newOrdersModel.getOrder_date();
		int product_id = Integer.valueOf(newOrdersModel.getProduct_id());
		int user_id = Integer.valueOf(newOrdersModel.getUser_id());
		int order_quantity = Integer.valueOf(newOrdersModel.getOrder_quantity());
		
		
		OrdersService orders = new OrdersService();
		orders.addNewEntry(order_id,order_date, product_id, user_id, order_quantity);
		
		return "index";
		
	}
	
	
	@PostMapping(value="/addnewproduct")
	public String addNewProduct(@ModelAttribute NewProductModel newProductModel) { 
		int product_id = Integer.valueOf(newProductModel.getProduct_id());
		String product_name = newProductModel.getProduct_name();
		double product_price = Double.valueOf(newProductModel.getProduct_price());
		
		Products product = new Products(product_id, product_name, product_price);
		ProductsServices.getInstance().addNewProduct(product);
		
		return "index";
	}
	/******************************* SERVE PAGES *******************************/
	//Open MakeOrder JSP page
	@PostMapping(value = "/makeorder")
	public ModelAndView makeOrderView(@RequestParam("user_name") String user_name, @RequestParam("user_password") String user_password, Model model)
	{
	

		UsersServices usersServices = new UsersServices(); 

		    
		ModelAndView view = new ModelAndView("MakeOrder"); 
		model.addAttribute("user_id",usersServices.getUserIdRetrieved(user_name));
		model.addAttribute("productList", ProductsServices.getInstance().getProductList());
	   return view;
	}
	
	@GetMapping(value = "/addnewproduct")
	public String addNewProductPage() {
		return "AddNewProduct";
	}
	
	@GetMapping(value="/") 
	public String home() {
		return "index";
	}
	

	
}

