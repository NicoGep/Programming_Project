package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import exceptions.InputException;

public class Groups {
	
	private int groupID;
	private String groupName;
	private String groupNiveau;
	
	protected Groups(ResultSet set) {
		
		try {
			
			set.first();
			
			this.groupID = set.getInt("groupid");
			this.groupName = set.getString("groupname");
			this.groupNiveau = set.getString("groupniveau");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void addNewGroup(String name, String niveau) throws InputException {
		
		if(Validator.getValidator().getGroup(name) != null)
			throw new InputException(4);
		
		String statement = 
				"INSERT INTO " + DatabaseConnection.groupsTable + 
				"(groupname, groupniveau) " +
				"VALUES ('" + name + "', '" + niveau + "');"
				;
		
		DatabaseConnection.makeUpdate(statement);
		
	}
	
	public static List<Groups> getAllGroups() {
		
		List<Groups> list = new LinkedList<Groups>();
		
		String statement = 
				"SELECT groupname FROM " + DatabaseConnection.groupsTable + ";"
				;
		
		ResultSet set = DatabaseConnection.makeQuerry(statement);
		
		try {
		
			while(set.next()) {
				list.add(Validator.getValidator().getGroup(set.getString("groupname")));
			}
		
		} catch(SQLException e) {
			return null;
		}
		
		return list;
		
	}
	
	
	//------------------------------------------ Getter ---------------------------------------------

	public int getGroupID() {
		return groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getGroupNiveau() {
		return groupNiveau;
	}

	
	//------------------------------------------ Setter ---------------------------------------------
	
	public void setGroupName(String name) {
		this.groupName = name;
		Validator.getValidator().updateGroup(this);
	}
	
	public void setGroupNiveau(String niveau) {
		this.groupNiveau = niveau;
		Validator.getValidator().updateGroup(this);
	}
	
	
	
	
	@Override
	public String toString() {
		return "GruppenID: " + this.getGroupID() + " - Name: " + this.getGroupName() + " - Niveau: " + this.getGroupNiveau();
	}
	

}
