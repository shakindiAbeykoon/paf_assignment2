package model;

import java.sql.*;

public class users {
	
	public String insertUsers(String ID, String Name, String Ph_No, String Email) {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return"Error while connecting to the databse for inserting";
				
			}
			
			String query = "insert into users values ( ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con1.prepareStatement(query);
			
			//binding values
			preparedStmt.setString(1,ID);
			preparedStmt.setString(2,Name);
			preparedStmt.setString(3,Ph_No);
			preparedStmt.setString(4,Email);
			
			//execute the statement
			preparedStmt.execute();
			con1.close();
			
			 String newItems = readUsers(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newItems + "\"}";
			
			//output = "Inserted Successfully";
			
			
		}
		catch(Exception e) {
			
			//output = "Error while inserting";
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the user.\"}"; 
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	public String readUsers() {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return "Error while connecting to the database for reading";
				
			}
			
			//HTML table
			output = "<table border=\"1\">\r\n"
					+ "		<tr>\r\n"
					+ "			<th>User ID</th><th>User Name</th><th>User Ph_No</th><th>User Email</th><th>Update</th><th>Remove</th>\r\n"
					+ "		</tr>";
			
			String query = "select * from users";
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				String userID = Integer.toString(rs.getInt("userID"));
				String userName = rs.getString("userName");
				String userPh_No = rs.getString("userPh_No");
				String userEmail = rs.getString("userEmail");
				
				//add a row into the html table
				output += "<tr>"+ "<td>" +userID+ "</td><td>" +userName+ "</td><td>" +userPh_No+ "</td><td>" +userEmail+ "</td>";
				
				 // buttons
				output += "<td><input name='btnUpdate' "
						+ "type='button' value='Update' "
						+ " class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' "
						+ "type='button' value='Remove' "
						+ "class='btnRemove btn btn-danger' "
						+ "data-userid='"
						 + userID + "'>" + "</td></tr>"; 
						
				
			}
			
			con1.close();
			
			//complete the html table
			output += "</table>";
			
			
			
		}
		catch(Exception e) {
			
			output = "Error while reading the users";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	public String updateUser(String ID, String Name, String Ph_No, String Email) {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return"Error while connecting to the databse for updating";
				
			}
			
			String query = "update users set userID=?, userName=?, userPh_No=?, userEmail=? where userID=?";
			
			PreparedStatement preparedStmt = con1.prepareStatement(query);
			
			//binding values
			preparedStmt.setString(1,ID);
			preparedStmt.setString(2,Name);
			preparedStmt.setString(3,Ph_No);
			preparedStmt.setString(4,Email);
			preparedStmt.setInt(5, Integer.parseInt(ID));
			
			//execute the statement
			preparedStmt.execute();
			con1.close();
			
			String newItems = readUsers(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newItems + "\"}";
			//output = "Updated Successfully";
			
		}
		catch(Exception e) {
			
			 String newItems = readUsers(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newItems + "\"}";
			
			//output = "Error while updating";
			 output = "{\"status\":\"error\", \"data\": \"Error while updating the user.\"}";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	public String deleteUser(String userID) {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return"Error while connecting to the databse for deleting";
				
			}
			
			String query = "delete from users where userID=?";
			
			PreparedStatement preparedStmt = con1.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1,Integer.parseInt(userID));
			
			//execute the statement
			preparedStmt.execute();
			con1.close();
			
			 String newItems = readUsers(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
			 newItems + "\"}";
			//output = "Deleted Successfully";
			
		}
		catch(Exception e) {
			
			 output = "{\"status\":\"error\", \"data\": \"Error while deleting the user.\"}";
			//output = "Error while deleting";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}

}
