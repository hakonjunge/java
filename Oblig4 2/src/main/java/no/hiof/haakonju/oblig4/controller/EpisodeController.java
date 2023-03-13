package no.hiof.haakonju.oblig4.controller;

import io.javalin.http.Context;
import no.hiof.haakonju.oblig4.data.Episode;
import no.hiof.haakonju.oblig4.repository.TvSerieDataRepository;
import no.hiof.haakonju.oblig4.repository.TvSerieRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class EpisodeController {
    private TvSerieRepository tvSerieRepository;

    public EpisodeController(TvSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getAlleEpisoder(Context context) {
        String tittel = context.pathParam("episode-nr");

        ArrayList<Episode> alleEpisoder = tvSerieRepository.getAlleEpisoder(tittel);
        sorterEpisoder(context);
        context.json(alleEpisoder);
    }

    public void getEpisode(Context context) {
        String tittel = context.pathParam("episode-nr");

        int episodeNummer = Integer.parseInt(context.pathParam("episode-nr"));

        Episode episode = tvSerieRepository.getEpisode("tittel", episodeNummer);
        sorterEpisoder(context);
        context.json(episode);
    }

    public void sorterEpisoder(Context context) {
        String tittel = context.queryParam("sortering");
        ArrayList<Episode> getAllEpsiodes = tvSerieRepository.getAlleEpisoder(tittel);

        Collections.sort(getAllEpsiodes, new Comparator<Episode>() {
            @Override
            public int compare(Episode episode1, Episode episode2) {
                return Integer.compare(episode1.getEpisodeNummer(), episode2.getEpisodeNummer());
            }
        });

        context.json(getAllEpsiodes);
    }

}
