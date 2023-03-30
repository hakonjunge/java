package no.hiof.haakonju.oblig4.controller;

import io.javalin.http.Context;
import no.hiof.haakonju.oblig4.model.Episode;
import no.hiof.haakonju.oblig4.model.Produksjon;
import no.hiof.haakonju.oblig4.repository.TvSerieRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EpisodeController {
    private TvSerieRepository tvSerieRepository;

    public EpisodeController(TvSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getEpisoderISesong(Context context) {
        String tvSerieTittel = context.pathParam("tvserie-id");
        String sesong = context.pathParam("sesong-nr");
        String sortering = context.queryParam("sortering");

        int sesongNr = sesong.isEmpty()? 1 : Integer.parseInt(sesong);

        ArrayList<Episode> episoder = tvSerieRepository.getEpisoderISesong(tvSerieTittel, sesongNr);

        if (sortering != null) {
            switch (sortering) {
                case "episodenr" -> Collections.sort(episoder);
                case "tittel" -> episoder.sort((e1, e2) -> e1.getTittel().compareTo(e2.getTittel()));
                case "spilletid" -> episoder.sort(Comparator.comparingInt(Produksjon::getSpilletid));
            }
        }

        context.json(episoder);
    }

    public void getEpisode(Context context) {
        String tvSerieTittel = context.pathParam("tvserie-id");
        String sesongNr = context.pathParam("sesong-nr");
        String episodeNr = context.pathParam("episode-nr");

        context.json(tvSerieRepository.getEpisode(tvSerieTittel, Integer.parseInt(sesongNr), Integer.parseInt(episodeNr)));

    }
    public void slettEpisode(Context context) {
        String tvSerieTittel = context.pathParam("tvserie-tittel");
        int sesongNr = Integer.parseInt(context.pathParam("sesong-nr"));
        int episodeNr = Integer.parseInt(context.pathParam("episode-nr"));

        boolean episodeSlettet = tvSerieRepository.slettEpisode(tvSerieTittel, sesongNr, episodeNr);

        if (episodeSlettet) {
            context.status(204); // No Content
        } else {
            context.status(404); // Not Found
        }
    }


}
