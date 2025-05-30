package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DataEpisode;
import br.com.alura.screenmatch.model.DataSeries;
import br.com.alura.screenmatch.model.SeasonData;
import br.com.alura.screenmatch.service.ApiConsumption;
import br.com.alura.screenmatch.service.ConvertsData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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

		List<SeasonData> seasons = new ArrayList<>();

		for (int i = 1; i < data.totalSeasons(); i++){
			json = apiConsumption.getData("https://www.omdbapi.com/?t=true+detective&season=" + i + "&apikey=b90fe627");
			SeasonData seasonData = converts.getData(json, SeasonData.class);
			seasons.add(seasonData);

		}
		seasons.forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


}

