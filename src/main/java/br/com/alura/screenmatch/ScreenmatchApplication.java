package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DataEpisode;
import br.com.alura.screenmatch.model.DataSeries;
import br.com.alura.screenmatch.service.ApiConsumption;
import br.com.alura.screenmatch.service.ConvertsData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {
		var apiConsumption = new ApiConsumption();
		var json = apiConsumption.getData("https://www.omdbapi.com/?t=true+detective&apikey=b90fe627");
		System.out.println(json);
		ConvertsData converts = new ConvertsData();
		DataSeries data = converts.getData(json, DataSeries.class);
		System.out.println(data);
		json = apiConsumption.getData("https://www.omdbapi.com/?t=true+detective&season=1&episode=2&apikey=b90fe627");
		DataEpisode dataEpisode = converts.getData(json, DataEpisode.class);
		System.out.println(dataEpisode);
	}

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


}

