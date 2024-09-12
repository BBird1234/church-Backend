package com.example.demo;

import java.util.List;

public interface ChurchService {
    List<Church> getAll() throws NoMemberExistInRepository;

    Church getById(Long id) throws NoMemberExistInRepository;

    Church addmember(Church church);

    Long deleteMember(Long id);

    Church updateMember(Long id, Church church) throws NoMemberExistInRepository;
}
