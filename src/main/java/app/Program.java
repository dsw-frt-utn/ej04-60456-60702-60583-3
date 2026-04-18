package app;

import data.Persistencia;
import views.MainView; // Importamos el menú principal

public class Program {
    public static void main(String[] args) {
        Persistencia.inicializar();
        
        // Arrancamos la aplicación desde el Menú Principal
        MainView view = new MainView();
        view.setVisible(true);
    }
}
