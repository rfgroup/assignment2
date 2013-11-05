package StoreManager;

import WidgetOrder.Entity.Widget;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class StoreManagerController implements Initializable {
    private final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
    private EntityManagerFactory emFactory;

    @FXML
    private ListView<Widget> listViewWidgets;
    @FXML
    private ObservableList<Widget> items = FXCollections.observableList(new ArrayList<Widget>());

    public StoreManagerController() {
        this.emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listViewWidgets.setItems(items);
        //listViewWidgets.setCellFactory(new Callback<ListView<Widget>, ListCell<Widget>>() {
        //    @Override
        //    public ListCell<Widget> call(ListView<Widget> widgetListView) {
        //        return new ListCell<Widget>();
        //    }
        //});
        items.add(new Widget(432, "name", "description"));
    }

    public void handleClick(ActionEvent actionEvent) {
        EntityManager em = emFactory.createEntityManager();
// Fetch widgets from the DB
        Collection<Widget> widgets = em.createNamedQuery("Widget.findAll", Widget.class).getResultList();
        for (Widget widget : widgets) {
            items.add(widget);
        }

    }

    public void quitApp(ActionEvent actionEvent) {
        Platform.exit();
    }
}
