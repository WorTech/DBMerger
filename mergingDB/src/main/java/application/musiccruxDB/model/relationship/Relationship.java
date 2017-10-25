package application.musiccruxDB.model.relationship;

import application.musiccruxDB.model.entity.Entity;

public class Relationship {
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