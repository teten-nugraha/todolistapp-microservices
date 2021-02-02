package id.todolistapp.masterservice.service.impl;

import id.todolistapp.masterservice.domain.Master;
import id.todolistapp.masterservice.repo.MasterRepository;
import id.todolistapp.masterservice.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements MasterService {

    @Autowired
    private MasterRepository masterRepository;

    @Override
    public List<Master> findAllMasters() {
        return masterRepository.findAll();
    }
}
