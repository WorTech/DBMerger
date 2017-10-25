package application.musiccruxDB.service;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import application.musiccruxDB.model.entity.Entity;



public interface EntityRepository extends MongoRepository<Entity, String> {
	public Entity findByLabel(String label);
	public Entity findById(long id);
	public void deleteAll();
}