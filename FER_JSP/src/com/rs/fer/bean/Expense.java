package com.rs.fer.bean;

public class Expense {
	public int expense_id;
	public String expense_type;
	public String price;
	public String date;
	public int no_of_items;
	public String total;
	public String bywhom;
	public int getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}
	public String getExpense_type() {
		return expense_type;
	}
	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNo_of_items() {
		return no_of_items;
	}
	public void setNo_of_items(int no_of_items) {
		this.no_of_items = no_of_items;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getBywhom() {
		return bywhom;
	}
	public void setBywhom(String bywhom) {
		this.bywhom = bywhom;
	}
	

}
