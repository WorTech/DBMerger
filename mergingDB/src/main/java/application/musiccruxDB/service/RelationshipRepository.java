package application.musiccruxDB.service;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import application.musiccruxDB.model.entity.Entity;
import application.musiccruxDB.model.relationship.Relationship;



public interface RelationshipRepository extends MongoRepository<Relationship, String> {
	//Define queries for relationship documents here.
	//NOTE: MongoRepository Queries are explicit for query names.
	public void deleteAll(); 
}