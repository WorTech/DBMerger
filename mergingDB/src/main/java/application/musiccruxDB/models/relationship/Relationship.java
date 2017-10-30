package application.musiccruxDB.models.relationship;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import application.musiccruxDB.models.entity.Entity;

public class Relationship {
	@Indexed
	private RelationshipType type;
	private Entity targetEntity, sourceEntity;
	
	public Relationship() {}


	public Entity getTargetEntity() {
		return targetEntity;
	}


	public void setTargetEntity(Entity targetEntity) {
		this.targetEntity = targetEntity;
	}


	public Entity getSourceEntity() {
		return sourceEntity;
	}


	public void setSourceEntity(Entity sourceEntity) {
		this.sourceEntity = sourceEntity;
	}


	public RelationshipType getType() {
		return type;
	}
	
	public void setType(RelationshipType type) {
		this.type=type;
	}

	
	
	
}