package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChurchServiceImpl implements ChurchService {

    @Autowired
    private ChurchRepository churchRepository;

    @Override
    public List<Church> getAll() throws NoMemberExistInRepository {
        List<Church> all = churchRepository.findAll();
        if (all.isEmpty()) {
            throw new NoMemberExistInRepository();
        } else {
            return all;
        }
    }

    @Override
    public Church getById(Long id) throws NoMemberExistInRepository {
        Optional<Church> church = churchRepository.findById(id);
        if (church.isEmpty()) {
            throw new NoMemberExistInRepository();
        } else {
            return church.get();
        }
    }

    @Override
    public Church addmember(Church church) {
        return churchRepository.save(church);
    }

    @Override
    public Long deleteMember(Long id) {
        churchRepository.deleteById(id);
        return id;
    }

    @Override
    public Church updateMember(Long id, Church church) throws NoMemberExistInRepository {
        Optional<Church> existingChurch = churchRepository.findById(id);
        if (existingChurch.isEmpty()) {
            throw new NoMemberExistInRepository();
        } else {
            Church updatedChurch = existingChurch.get();
            updatedChurch.setCname(church.getCname());
            updatedChurch.setCgender(church.getCgender());
            updatedChurch.setCdob(church.getCdob());
            updatedChurch.setEmail(church.getEmail());
            updatedChurch.setImage(church.getImage());
            return churchRepository.save(updatedChurch);
        }
    }
}
