package application.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.discogsDB.model.Artist;
import application.discogsDB.service.ArtistRepository;
import application.musiccruxDB.model.entity.Entity;
import application.musiccruxDB.model.entity.EntityType;
import application.musiccruxDB.model.relationship.Relationship;
import application.musiccruxDB.model.relationship.RelationshipType;
import application.musiccruxDB.service.EntityRepository;
import application.musiccruxDB.service.RelationshipRepository;

@Component
@Order(value = 1)
public class GenerateRelationshipModels implements CommandLineRunner{

	//This file creates a Relationship collection and adds
	//relationship documents by querying the Artist Collection
	//for all Artists with members. From those members, we create
	//relationships using the Artist's members property.
	@Autowired
	private ArtistRepository discogsArtistRepository;
	@Autowired
	private RelationshipRepository db;
	
	private void constructRelationshipFromArtist() {
		for (Artist artist : discogsArtistRepository.findAllArtistsWithMembers()) {
				Relationship relationship = new Relationship();
				relationship.setType(RelationshipType.MEMBER);
				long[] Ids = artist.getMembers().getId();
				
				for (long id : Ids) {
					relationship.setSource(id);
					relationship.setTarget(artist.getId());
				}
				db.save(relationship);				
		}
		for (Relationship r : db.findAll()) {
			System.out.println(r);
		}
	}

	public void run(String... args) throws Exception {
		constructRelationshipFromArtist();
		
	}	
}