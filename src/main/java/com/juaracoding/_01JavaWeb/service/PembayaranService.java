package com.juaracoding._01JavaWeb.service;

import com.juaracoding._01JavaWeb.model.Pembayaran;
import com.juaracoding._01JavaWeb.model.Student;
import com.juaracoding._01JavaWeb.repo.PembayaranRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PembayaranService {

	private PembayaranRepo pembayaranRepository;

	public PembayaranService(PembayaranRepo pembayaranRepository) {
		this.pembayaranRepository = pembayaranRepository;
	}

	public List<Pembayaran> getAllPembayaran() {
		return pembayaranRepository.findAll();
	}

	public Pembayaran savePembayaran(Pembayaran pembayaran) {
		return pembayaranRepository.save(pembayaran);
	}

	public Optional<Pembayaran> getPembayaranById(Long id,String x) {
//		return studentRepository.findById(id).get();
		return pembayaranRepository.findById(id);
	}

	public Pembayaran getPembayaranById(Long id) {
		return pembayaranRepository.findById(id).get();
//		return studentRepository.findById(id);
	}

	public Pembayaran updatePembayaran(Pembayaran pembayaran) {
		return pembayaranRepository.save(pembayaran);
	}

	public void deletePembayaranById(Long id) {
		pembayaranRepository.deleteById(id);
	}

}
