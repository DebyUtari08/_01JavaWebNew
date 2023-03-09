package com.juaracoding._01JavaWeb.service;

import com.juaracoding._01JavaWeb.model.PesananLaundry;
import com.juaracoding._01JavaWeb.repo.PesananLaundryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesananLaundryService {

	private PesananLaundryRepo pesananLaundryRepository;

	public PesananLaundryService(PesananLaundryRepo pesananLaundryRepository) {
		this.pesananLaundryRepository = pesananLaundryRepository;
	}

	public List<PesananLaundry> getAllPesananLaundry() {
		return pesananLaundryRepository.findAll();
	}

	public PesananLaundry savePesananLaundry(PesananLaundry pesananLaundry) {
		return pesananLaundryRepository.save(pesananLaundry);
	}

	public Optional<PesananLaundry> getPesananLaundryById(Long id,String x) {
//		return studentRepository.findById(id).get();
		return pesananLaundryRepository.findById(id);
	}

	public PesananLaundry getPesananLaundryById(Long id) {
		return pesananLaundryRepository.findById(id).get();
//		return studentRepository.findById(id);
	}

	public PesananLaundry updatePesananLaundry(PesananLaundry pesananLaundry) {
		return pesananLaundryRepository.save(pesananLaundry);
	}

	public void deletePesananLaundryById(Long id) {
		pesananLaundryRepository.deleteById(id);
	}

}
