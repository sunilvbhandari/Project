package com.corona.VirusTrcaker;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

@Service
public class VirusTrackerService {
	private ArrayList<Detail> list = new ArrayList<Detail>();

	@PostConstruct
	public ArrayList<Detail> hello() throws IOException, InterruptedException {
		list.removeAll(list);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
				"https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv"))
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		StringReader st = new StringReader(response.body());
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(st);
		for (CSVRecord record : records) {
			Detail det = new Detail(record.get("Province/State"), record.get("Country/Region"), record.get("Lat"),
					record.get("Long"),record.get(record.size()-1));
			list.add(det);
		}
		return list;
	}

}
