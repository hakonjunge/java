package pakke;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
public class AvspillingsController {
    @FXML
    private Label statusTekst;
    @FXML
    private ListView<Spillbar> mediaListe;
    @FXML
    private Slider progressSlider;

    public void initialize() {
        progressSlider.setShowTickMarks(true);
        progressSlider.setShowTickLabels(true);
        progressSlider.setMin(0);
// Oppgave 3.7
// Legger til en listener, blir kalt ved valg i listen
        mediaListe.getSelectionModel().selectedItemProperty()
                .addListener(new MediaListener());
        private class MediaListener implements ChangeListener<Spillbar> {
        }
// Metoden er forenklet noe for å gjøres oversiktlig
        @Override
        public void changed (Spillbar gammel, Spillbar ny){ // Oppgave 3.8
        }
    }
}