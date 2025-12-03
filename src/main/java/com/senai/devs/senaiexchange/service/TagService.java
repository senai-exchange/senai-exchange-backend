package com.senai.devs.senaiexchange.service;

import com.senai.devs.senaiexchange.dto.request.TagRequest;
import com.senai.devs.senaiexchange.dto.response.TagResponse;
import com.senai.devs.senaiexchange.entity.Tag;
import com.senai.devs.senaiexchange.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagResponse criarTag(TagRequest dto) {
        Tag tag = new Tag();
        tag.setNome(dto.getNome());

        tagRepository.save(tag);

        return new TagResponse(tag);
    }

    public TagResponse buscarPorId(long id) {
        Optional<Tag> tagOptional = tagRepository.findById(id);

        if (tagOptional.isEmpty()) {
            throw new RuntimeException("Tag não encontrada");
        }

        Tag tag = tagOptional.get();
        return new TagResponse(tag);
    }

    public TagResponse atualizar(long id, TagResponse dto) {
        Optional<Tag> tagOptional = tagRepository.findById(id);

        if (tagOptional.isEmpty()) {
            throw new RuntimeException("Tag não encontrada");
        }

        Tag tag = tagOptional.get();

        tag.setNome(dto.getNome());

        tagRepository.save(tag);

        return new TagResponse(tag);
    }

    public boolean deletar(long id) {
        if (!tagRepository.existsById(id)) {
            return false;
        }

        tagRepository.deleteById(id);
        return true;
    }
}