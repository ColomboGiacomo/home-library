package backend.entities;

public class Genre {

	private final int id;
	private final String name;
	private final String description;
	
	public Genre (int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() { return id; }
		
	public String getName() { return name; }
		
	public String getDescription() { return description; }
		
}
