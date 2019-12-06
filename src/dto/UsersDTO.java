package dto;

public class UsersDTO {
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private boolean enabled;
	
	public UsersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersDTO(UsersDTO user) {
		super();
		this.id = user.getId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.enabled = user.isEnabled();
	}

	public UsersDTO(int id, String user, String password, String firstName, String lastName, Boolean enabled) {
		super();
		this.id = id;
		this.userName = user;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String user) {
		this.userName = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
