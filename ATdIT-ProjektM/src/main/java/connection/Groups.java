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
	
	
	public static Groups addNewGroup(String name, String niveau) throws InputException {
		
		if(Validator.getValidator().getGroup(name) != null)
			throw new InputException(4);
		
		String statement = 
				"INSERT INTO " + DatabaseConnection.groupsTable + 
				"(groupname, groupniveau) " +
				"VALUES ('" + name + "', '" + niveau + "');"
				;
		
		DatabaseConnection.makeUpdate(statement);
		
		return Validator.getValidator().getGroup(name);
	}
	
	public static Groups addNewGroup(String name) throws InputException {
		
		if(Validator.getValidator().getGroup(name) != null)
			throw new InputException(4);
		
		String statement = 
				"INSERT INTO " + DatabaseConnection.groupsTable + 
				"(groupname) " +
				"VALUES ('" + name + "');"
				;
		
		DatabaseConnection.makeUpdate(statement);
		
		return Validator.getValidator().getGroup(name);
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
	
	public void deleteGroup() {
		Validator.getValidator().deleteGroup(this);
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + groupID;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((groupNiveau == null) ? 0 : groupNiveau.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groups other = (Groups) obj;
		if (groupID != other.groupID)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (groupNiveau == null) {
			if (other.groupNiveau != null)
				return false;
		} else if (!groupNiveau.equals(other.groupNiveau))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "GruppenID: " + this.getGroupID() + " - Name: " + this.getGroupName() + " - Niveau: " + this.getGroupNiveau();
	}
	

}
