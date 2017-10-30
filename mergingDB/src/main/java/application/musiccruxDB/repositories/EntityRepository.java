package application.musiccruxDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.musiccruxDB.models.entity.Entity;

public interface EntityRepository extends MongoRepository<Entity, String> {
	public Entity findByLabel(String label);

	public Entity findById(long id);

	public void deleteAll();
}