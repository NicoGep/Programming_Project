package connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.InputException;

public class Groups {
	
	private int groupID;
	private String groupName;
	private String groupNiveau;
	
	public Groups(ResultSet set) {
		
		try {
			
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
	
	
	

	public int getGroupID() {
		return groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getGroupNiveau() {
		return groupNiveau;
	}

	
	

}
