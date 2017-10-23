package application.discogsDB.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.discogsDB.model.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String> {
	 public Artist findByName(String name);
}
