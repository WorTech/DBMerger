package application.discogsDB.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import application.discogsDB.model.Artist;
import application.discogsDB.model.Members;

public interface ArtistRepository extends MongoRepository<Artist, String> {
	
	 public Artist findByName(String name);
	 
	 //This query checks if an Artist has any members.
	 @Query("{ 'members' : {$exists:true} }")
	 public List<Artist> findAllArtistsWithMembers();
	 
}
