package application.musiccruxDB.model.entity;

import org.springframework.data.annotation.Id;

public class Entity {
	//feel free to change to int or long if that fits your model better
	@Id
	private long id;
	
	private EntityType type;
	
	//artist name, band name, etc
	private String label;

	public Entity() {
		
	}
	
	public Entity(long id, EntityType type, String label) {
		this.id = id;
		this.type = type;
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EntityType getType() {
		return type;
	}

	public void setType(EntityType type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", type=" + type + ", label=" + label + "]";
	}
	
	
}