package com.Practical.Backend.Service;

import com.Practical.Backend.Entity.Venue;
import com.Practical.Backend.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {

    @Autowired
    VenueRepository venueRepository;

    public List<Venue> getVenues(){
        return venueRepository.findAll();
    }

    public Venue getVenue(Long id){

        return venueRepository.findById(id).get();

    }

    public Venue saveVenue(Venue venue){
        return venueRepository.save(venue);
    }

    public void deleteVenue(Long id){

        Venue venue = venueRepository.findById(id).get();

        venueRepository.delete(venue);

    }





}
