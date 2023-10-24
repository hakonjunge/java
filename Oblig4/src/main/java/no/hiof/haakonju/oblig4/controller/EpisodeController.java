package no.hiof.haakonju.oblig4.controller;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import no.hiof.haakonju.oblig4.model.Episode;
import no.hiof.haakonju.oblig4.model.Produksjon;
import no.hiof.haakonju.oblig4.repository.TvSerieCSVRepository;
import no.hiof.haakonju.oblig4.repository.TvSerieRepository;

import java.io.File;
import java.time.LocalDate;
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

        int sesongNr = sesong.isEmpty() ? 1 : Integer.parseInt(sesong);

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

    public void updateEpisode(Context ctx) {
        String tvSerieTittel = ctx.pathParam("tvserie-id");
        int sesongNr = Integer.parseInt(ctx.pathParam("sesong-nr"));
        int episodeNr = Integer.parseInt(ctx.pathParam("episode-nr"));
        String episodeTittel = ctx.formParam("episodeTittel");
        String beskrivelse = ctx.formParam("beskrivelse");
        int spilletid = Integer.parseInt(ctx.formParam("spilletid"));
        LocalDate utgivelsesdato = LocalDate.parse(ctx.formParam("utgivelsesdato"));
        String bildeurl = ctx.formParam("bildeurl");

        if (tvSerieRepository.updateEpisode(tvSerieTittel, sesongNr, episodeNr, episodeTittel, beskrivelse, spilletid, utgivelsesdato, bildeurl)) {
            ctx.redirect("/tvserie/" + tvSerieTittel + "/sesong/" + sesongNr + "/episode/" + episodeNr);
        } else {
            ctx.status(400).result("Kunne ikke oppdatere episode");
        }
    }

    public void createEpisode(Context ctx) {
        String tvSerieTittel = ctx.pathParam("tvserie-id");
        int sesongNr = Integer.parseInt(ctx.formParam("sesongNr"));
        int episodeNummer = Integer.parseInt(ctx.formParam("episodeNummer"));
        String episodeTittel = ctx.formParam("episodeTittel");
        String beskrivelse = ctx.formParam("beskrivelse");
        int spilletid = Integer.parseInt(ctx.formParam("spilletid"));
        LocalDate utgivelsesdato = LocalDate.parse(ctx.formParam("utgivelsesdato"));
        String bildeurl = ctx.formParam("bildeurl");

        if (tvSerieRepository.leggTilEpisode(tvSerieTittel, new Episode(episodeTittel, beskrivelse, episodeNummer, sesongNr, spilletid, utgivelsesdato, bildeurl))) {
            ctx.redirect("/tvserie/" + tvSerieTittel + "/sesong/" + sesongNr);
        } else {
            ctx.status(400).result("Kunne ikke opprette episode");
        }
    }
    private Episode mapEpisodeFromForm(Context ctx) {
        String episodeTittel = ctx.formParam("episodeTittel");
        String beskrivelse = ctx.formParam("beskrivelse");
        int spilletid = Integer.parseInt(ctx.formParam("spilletid"));
        LocalDate utgivelsesdato = LocalDate.parse(ctx.formParam("utgivelsesdato"));
        String bildeurl = ctx.formParam("bildeurl");

        return new Episode(episodeTittel, beskrivelse, 0, 0, spilletid, utgivelsesdato, bildeurl);
    }
}


