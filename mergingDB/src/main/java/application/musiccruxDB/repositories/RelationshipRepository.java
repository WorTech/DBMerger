package application.musiccruxDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.musiccruxDB.models.relationship.Relationship;

public interface RelationshipRepository extends MongoRepository<Relationship, String> {
	// Define queries for relationship documents here.
	// NOTE: MongoRepository Queries are explicit for query names.
	public void deleteAll();
}