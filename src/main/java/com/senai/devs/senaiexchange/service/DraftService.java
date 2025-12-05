package com.senai.devs.senaiexchange.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.senai.devs.senaiexchange.dto.request.DraftRequest;
import com.senai.devs.senaiexchange.dto.response.DraftResponse;
import com.senai.devs.senaiexchange.dto.response.DraftResponseResume;
import com.senai.devs.senaiexchange.entity.Draft;
import com.senai.devs.senaiexchange.repository.DraftRepository;
import java.util.stream.Collectors;

import java.util.List;


@Service
public class DraftService {
    
    private final DraftRepository draftRepository;

    public DraftService(DraftRepository draftRepository) {
        this.draftRepository = draftRepository;
    }
    
    // CREATE
    public DraftResponse create(DraftRequest draftRequest) {
        Draft draft = new Draft(draftRequest);
        Draft savedDraft = draftRepository.save(draft);
        return new DraftResponse(savedDraft);
    }

    
    // DELETE BY ID
    public void deleteById(int id, int authorId) {
        Draft draft = draftRepository.findById(id)
                .filter(d -> d.getAuthorId() == authorId)
                .orElseThrow(() -> new RuntimeException("Draft not found or not owned by this user."));
        
        draftRepository.delete(draft);
    }
    
    
    // DELETE ALL BY AUTHOR
    @Transactional
    public void deleteAllByAuthor(int authorId) {
        List<Draft> drafts = draftRepository.findByAuthorId(authorId);
        
        if (drafts.isEmpty()) {
            throw new RuntimeException("This user has no drafts.");
        }
        
        draftRepository.deleteAll(drafts);
    }
    
  //DELETE ALL
    @Transactional
    public void deleteAll() {
        draftRepository.deleteAllInBatch();
    }
    
    // UPDATE
    public DraftResponse update(int id, int authorId, DraftRequest draftRequest) {
        Draft draft = draftRepository.findById(id)
                .filter(d -> d.getAuthorId() == authorId)
                .orElseThrow(() -> new RuntimeException("Draft not found or not owned by this user."));
        
        draft.setTitle(draftRequest.getTitle());
        draft.setContent_text(draftRequest.getContent_text());
        draft.setIs_autosave(draftRequest.getIs_autosave());
        
        Draft updatedDraft = draftRepository.save(draft);
        return new DraftResponse(updatedDraft);
    }
    
    // FIND BY ID
    public DraftResponse findById(int id, int authorId) {
        Draft draft = draftRepository.findById(id)
                .filter(d -> d.getAuthorId() == authorId)
                .orElseThrow(() -> new RuntimeException("Draft not found or not owned by this user."));
        
        return new DraftResponse(draft);
    }
    
    // LIST ALL
    public List<DraftResponse> findAll() {
        return draftRepository.findAll().stream()
                .map(DraftResponse::new)
                .collect(Collectors.toList());
    }
    
    // LIST ALL BY AUTHOR (RESUMIDO)
    public List<DraftResponseResume> findAllByAuthorId(int authorId) {
        List<Draft> drafts = draftRepository.findByAuthorId(authorId);

        return drafts.stream()
                .map(d -> new DraftResponseResume(d))
                .collect(Collectors.toList());
    }

    public List<DraftResponse> findByAuthorIdAndTag_Name(int authorId, String name){
    	
    	List<Draft> drafts = draftRepository.findByAuthorIdAndTag_Name(authorId, name);
    	return drafts.stream()
                .map(d -> new DraftResponse())
                .collect(Collectors.toList());    
    	
    }
    
    
    
}