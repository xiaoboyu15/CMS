package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Reporter;
import mapper.ReporterMapper;

@Service
public class ReporterService {
	@Autowired
	private ReporterMapper reporterMapper;

	public List<Reporter> loginInReporter() {
		return reporterMapper.loginInReporter();
	}
}
