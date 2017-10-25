package application.musiccruxDB.model.relationship;
public class Relationship {
	private RelationshipType type;
	private long sourceEntityIndex;
	private long targetEntityIndex;
	
	public Relationship() {}
	
	public Relationship(RelationshipType type, long sourceEntityIndex, long targetEntityIndex) {
		this.type = type;
		this.sourceEntityIndex = sourceEntityIndex;
		this.targetEntityIndex = targetEntityIndex;
	}

	public RelationshipType getType() {
		return type;
	}

	public void setType(RelationshipType type) {
		this.type = type;
	}

	public long getSource() {
		return sourceEntityIndex;
	}

	public void setSource(long sourceEntityIndex) {
		this.sourceEntityIndex = sourceEntityIndex;
	}

	public long getTarget() {
		return targetEntityIndex;
	}

	public void setTarget(long targetEntityIndex) {
		this.targetEntityIndex = targetEntityIndex;
	}
	
	
	
}