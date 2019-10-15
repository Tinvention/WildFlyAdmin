package net.tinvention.training.wildfly.mc.mchw;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.opencsv.CSVReader;

@Singleton
public class CsvReader {

	public List<String[]> deSerialize() throws IOException {
		try (
				final Reader csvStreamReader = new InputStreamReader(this.getClass().getResourceAsStream("/data.csv"));
				final CSVReader csvReader = new CSVReader(csvStreamReader);) {

			List<String[]> result = new ArrayList<>();
			result = csvReader.readAll();
			return result;
		}
	}

}
