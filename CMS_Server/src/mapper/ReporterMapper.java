package mapper;

import java.util.List;

import entity.Reporter;

public interface ReporterMapper {
	public List<Reporter> loginInReporter();
	public boolean insertReporter(Reporter reporter);
	public boolean deleteReporter(String reporterName);
	public Reporter getReporterByName(String reporterName);
}
