package no.hiof.haakonju.oblig4.controller;

import io.javalin.http.Context;
import no.hiof.haakonju.oblig4.model.Episode;
import no.hiof.haakonju.oblig4.model.TvSerie;
import no.hiof.haakonju.oblig4.repository.TvSerieCSVRepository;
import no.hiof.haakonju.oblig4.repository.TvSerieRepository;

import java.io.File;

public class TvSerieController {
    private String filePath = "src/main/resources/tekstfiler/tvshows_10.csv";
    private File csvFile = new File(filePath);
    private TvSerieRepository tvSerieRepository = new TvSerieCSVRepository(csvFile);

    public TvSerieController(TvSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getAlleTvSerier(Context ctx) {
        ctx.json(tvSerieRepository.getTVSerier());
    }

    public void getTVSerie(Context context) {
        String tvSerieId = context.pathParam("tvserie-id");

        context.json(tvSerieRepository.getTvSerie(tvSerieId));
    }

}