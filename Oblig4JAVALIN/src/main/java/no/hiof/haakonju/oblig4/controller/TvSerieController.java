package no.hiof.haakonju.oblig4.controller;

import io.javalin.http.Context;
import no.hiof.haakonju.oblig4.data.Episode;
import no.hiof.haakonju.oblig4.data.TvSerie;
import no.hiof.haakonju.oblig4.repository.TvSerieRepository;

import java.util.ArrayList;
import java.util.List;

public class TvSerieController {
    private TvSerieRepository tvSerieRepository;

    public TvSerieController(TvSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getAlleTvserier(Context context) {
        String tittel = context.pathParam("tvserie-id");

        ArrayList<TvSerie> alleTvSerier = tvSerieRepository.getAlleTvserier(tittel);

        context.json(alleTvSerier);
    }

    public void getTvserie(Context context) {
        String tittel = context.pathParam("tvserie-id");

        int antallsesonger = Integer.parseInt(context.pathParam("tvserie-id"));

        TvSerie tvSerie = tvSerieRepository.getTvserie("tittel", antallsesonger);

        context.json(tvSerie);
    }

}



