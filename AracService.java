package com.example.proje.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proje.Entity.Arac;
import com.example.proje.Repoistory.AracRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AracService {

    @Autowired
    private AracRepository aracRepository;

    // Araçları listeleme
    public List<Arac> getAllAraclar() {
        return aracRepository.findAll();
    }

    // Yeni araç kaydetme
    public Arac saveArac(Arac arac) {
        return aracRepository.save(arac);
    }

    // Araç güncelleme
    public Arac updateArac(Arac arac) {
        return aracRepository.save(arac);
    }

    // Araç silme
    public void deleteArac(Long id) {
        aracRepository.deleteById(id);
    }

    // Araç detaylarını getirme
    public Optional<Arac> getAracById(Long id) {
        return aracRepository.findById(id);
    }
}

