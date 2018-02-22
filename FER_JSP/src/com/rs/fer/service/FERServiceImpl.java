package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

import com.rs.fer.Util.DBUtil;
import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public class FERServiceImpl implements FERService {

	//static Logger logger = Logger.getLogger(FERServiceImpl.class.getName());
	
	@Override
	public boolean login(String usernamre, String password) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean loginFlag = false;
		try {
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement("select * from user where username=? and password=?");

			preparedStatement.setString(1, usernamre);
			preparedStatement.setString(2, password);

			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				loginFlag = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginFlag;

	}

	@Override
	public boolean registration(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean registrationFlag = false;
		
	//	logger.info("Registration start:: input: user: "+user);
	//	logger.debug("test debug");
		try {
			connection = DBUtil.getConnection();

			String query="insert into user(first_name, middle_name , last_name, username, password, email, phone_number) values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFirst_name());
			preparedStatement.setString(2, user.getMiddle_name());
			preparedStatement.setString(3, user.getLast_name());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getPhone_number());

			int noOfInsertedItem = preparedStatement.executeUpdate();
			System.out.println(noOfInsertedItem);
			registrationFlag = true;

		} catch (SQLException e) {
			e.printStackTrace();
	//		logger.error("SQLException:: "+e);
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		//logger.info("Registration end:: registrationFlag: "+registrationFlag);
		
		return registrationFlag;
	}

	@Override
	public boolean addExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean addExpenseFlag = false;
		
	//	logger.info("AddExpense start:: input: expense: "+expense);
	//	logger.debug("test debug");

		try {
			connection = DBUtil.getConnection();
			String query= "insert into expense(expense_type, date, price, no_of_items, total, bywhom) values(?,?,?,?,?,?)";
			p = connection.prepareStatement(query);
			p.setString(1, expense.getExpense_type());
			p.setString(2, expense.getDate());
			p.setString(3, expense.getPrice());
			p.setInt(4, expense.getNo_of_items());
			p.setString(5, expense.getTotal());
			p.setString(6, expense.getBywhom());

			int noOfUpdatedItems = p.executeUpdate();
			System.out.println(noOfUpdatedItems);
			addExpenseFlag = noOfUpdatedItems > 0;

		} catch (SQLException e) {
			e.printStackTrace();
	//		logger.error("SQLException:: "+e);
			
		} finally {
			DBUtil.closeConnection(connection);
		}
		
	//	logger.info("AddExpense end:: AddExpenseFlag: "+addExpenseFlag);

		return addExpenseFlag;
	}

	@Override
	public boolean deleteExpense(int id) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean deleteExpenseFlag = false;

		try {
			connection = DBUtil.getConnection();

			String query="delete from expense where expense_id=?";
			p = connection.prepareStatement(query);

			p.setInt(1, id);
			int deletedId = p.executeUpdate();

			System.out.println(deletedId);
			deleteExpenseFlag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return deleteExpenseFlag;
	}
	
	public boolean resetPassword (String newPassword, String username,String oldPassword) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean resetPasswordFlag = false;

		try {
			connection = DBUtil.getConnection();
			
			String query="update user set password=? where username=? and password=?";
			p = connection.prepareStatement(query);

			p.setString(1, newPassword);
			p.setString(2, username);
			p.setString(3, oldPassword);

			int resetPassword = p.executeUpdate();
			System.out.println(resetPassword);
			resetPasswordFlag = resetPassword > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return resetPasswordFlag;
	}

	@Override
	public boolean editExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean editExpenseFlag = false;

		try {
			connection = DBUtil.getConnection();
			String query= "update expense set expense_type=?, date=?, price=?, no_of_items=?, total=?, bywhom=? where expense_id=?";

			p = connection.prepareStatement(query);

			p.setString(1, expense.getExpense_type());
			p.setString(2, expense.getDate());
			p.setString(3, expense.getPrice());
			p.setInt(4, expense.getNo_of_items());
			p.setString(5, expense.getTotal());
			p.setString(6, expense.getBywhom());
			p.setInt(7, expense.getExpense_id());

			int updateditemss = p.executeUpdate();
			System.out.println(updateditemss);

			editExpenseFlag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return editExpenseFlag;
	}

	@Override
	public Expense getExpense(int expense_id) {
		Connection connection = null;
		PreparedStatement p = null;
		Expense expenseObject = null;
		ResultSet resultset = null;

		try {
			connection = DBUtil.getConnection();
			
			String query="select * from expense where expense_id=?";
			p = connection.prepareStatement(query);

			p.setInt(1, expense_id);
			resultset = p.executeQuery();

			while (resultset.next()) {
				expenseObject = new Expense();
				expenseObject.setExpense_id(resultset.getInt("expense_id"));
				expenseObject.setExpense_type(resultset.getString("expense_type"));
				expenseObject.setPrice(resultset.getString("price"));
				expenseObject.setDate(resultset.getString("date"));
				expenseObject.setNo_of_items(resultset.getInt("no_of_items"));
				expenseObject.setTotal(resultset.getString("total"));
				expenseObject.setBywhom(resultset.getString("byWhom"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return expenseObject;
	}
	
	
	
	
	public List<Expense> getExpenses() {
		Connection connection = null;
		PreparedStatement p = null;
		List<Expense> expenses = new ArrayList<Expense>();
		ResultSet resultset = null;
		Expense expense = null;
		try {
			connection = DBUtil.getConnection();
			p = connection.prepareStatement("select * from expense");
			resultset = p.executeQuery();

			while (resultset.next()) {

				expense = new Expense();
				expense.setExpense_type(resultset.getString("expense_type"));
				expense.setDate(resultset.getString("date"));
				expense.setPrice(resultset.getString("price"));
				expense.setNo_of_items(resultset.getInt("no_of_items"));
				expense.setTotal(resultset.getString("total"));
				expense.setBywhom(resultset.getString("bywhom"));
				expense.setExpense_id(resultset.getInt("expense_id"));

				System.out.println(expense.getExpense_type() + expense.getDate()
						+ expense.getPrice() + expense.getNo_of_items()
						+ expense.getTotal() + expense.getBywhom()
						+ expense.getExpense_id());

					expenses.add(expense);
			}
		  } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;
	}
	
	public List<Expense> getExpenseReport(String expense_type, String fromdate, String todate) {
		Connection connection = null;
		PreparedStatement p = null;
		List<Expense> expenses = new ArrayList<Expense>();
		ResultSet resultset = null;

		try {
			connection = DBUtil.getConnection();
			
			String query="select * from expense where expense_type=? and date between ? and ?";
			p = connection.prepareStatement(query);
			p.setString(1, expense_type);
			p.setString(2, fromdate);
			p.setString(3, todate);
			resultset = p.executeQuery();
		Expense expense = null;

			while (resultset.next()) {
				expense = new Expense();

				expense.setExpense_type(resultset.getString("expense_type"));
				expense.setDate(resultset.getString("date"));
				expense.setPrice(resultset.getString("price"));
				expense.setNo_of_items(resultset.getInt("no_of_items"));
				expense.setTotal(resultset.getString("total"));
				expense.setBywhom(resultset.getString("bywhom"));
				expense.setExpense_id(resultset.getInt("expense_id"));

				expenses.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;
	}
	
	@Override
	public PersonalInfo getPersonalInfo(String username) {
		Connection connection = null;
		PreparedStatement p = null;
		ResultSet resultset = null;
		PersonalInfo personalInfo = new PersonalInfo();

		try {
			connection = DBUtil.getConnection();
			
			String query="SELECT u.*, a.* FROM user u LEFT JOIN address a ON u.id=a.user_id WHERE u.username='"+username+"'";
			
			p = connection.prepareStatement(query);
			resultset = p.executeQuery();

			while (resultset.next()) {

				User user = new User();
				
				user.setId(resultset.getInt(1));
				user.setFirst_name(resultset.getString(2));
				user.setMiddle_name(resultset.getString(3));
				user.setLast_name(resultset.getString(4));
				user.setUsername(resultset.getString(5));
				user.setPassword(resultset.getString(6));
				user.setEmail(resultset.getString(7));
				user.setPhone_number(resultset.getString(8));

				Address address = new Address();

				address.setId(resultset.getInt(9));
				address.setAddress_line1(resultset.getString("address_line1"));
				address.setAddress_line2(resultset.getString("address_line2"));
				address.setCity(resultset.getString("city"));
				address.setState(resultset.getString("state"));
				address.setZip(resultset.getString("zip"));
				address.setCountry(resultset.getString("country"));
				address.setUser_id(resultset.getInt("user_id"));

				personalInfo.setAddress(address);
				personalInfo.setUser(user);
				if (username.equals(user.getUsername())) {
					return personalInfo;
				}
				
				/*PersonalInfo personalInfo = new PersonalInfo();
				personalInfo.setUser(user);
				personalInfo.setAddress(address);
				
				return personalInfo;*/

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return null;
	}
	
	@Override
	public boolean updatePersonalInfo(User user, Address address) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean updatePersonalFlag = false;
		boolean isUpdated = false;

		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			p = connection.prepareStatement("Update user set first_name=?, middle_name=?, last_name=?, email=?, phone_number=? where id=?");

			p.setString(1, user.getFirst_name());
			p.setString(2, user.getMiddle_name());
			p.setString(3, user.getLast_name());
			p.setString(4, user.getEmail());
			p.setString(5, user.getPhone_number());
			p.setInt(6, user.getId());

			int updatePersonal = p.executeUpdate();
			System.out.println(updatePersonal);

			if (updatePersonal > 0) {
				int noOfAddOrEditAddress = 0;
				if (address.getId() != 0) {
					p = connection.prepareStatement("update address set address_line1=?,address_line2=?,city=?,state=?,zip=?,country=? where id=?");
					p.setString(1, address.getAddress_line1());
					p.setString(2, address.getAddress_line2());
					p.setString(3, address.getCity());
					p.setString(4, address.getState());
					p.setString(5, address.getZip());
					p.setString(6, address.getCountry());
					p.setInt(7, address.getId());

				} else {
					p = connection.prepareStatement("insert into address (address_line1,address_line2,city,state,zip,country,userid) values(?,?,?,?,?,?,?)");

					p.setString(1, address.getAddress_line1());
					p.setString(2, address.getAddress_line2());
					p.setString(3, address.getCity());
					p.setString(4, address.getState());
					p.setString(5, address.getZip());
					p.setString(6, address.getCountry());
					p.setInt(7, address.getId());

				}
				noOfAddOrEditAddress = p.executeUpdate();
				System.out.println("updated item= " + noOfAddOrEditAddress);
				if (noOfAddOrEditAddress > 0) {
					isUpdated = true;
				}
				if (isUpdated) {
					connection.commit();
				} else {
					connection.rollback();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isUpdated;
	}
	
	public boolean isEmailAvailable(String email) {
		Connection connection = null;
		boolean isEmailAvailable = true;
		
		try {

			connection = DBUtil.getConnection();
			String sql = "select * from user where email=?";

			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, email);

			ResultSet resultset = pstatement.executeQuery();
			while (resultset.next()) {
				isEmailAvailable = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return isEmailAvailable;
	}
}

