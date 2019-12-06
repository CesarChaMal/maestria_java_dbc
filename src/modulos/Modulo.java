package modulos;

public abstract class Modulo {
 
	private String name;
	 
	private String description;
	 
	public abstract String getName();
	public abstract void setName(String name);
	public abstract String getDescription();
	public abstract void setDescription(String description);
	public abstract void show();
}
 
