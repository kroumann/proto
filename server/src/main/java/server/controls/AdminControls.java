package server.controls;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.Arrays;
import javax.swing.event.ChangeListener;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import server.controls.ServerUIControls;
import server.gui.*;
import server.models.Category;



public class AdminControls {
    private AdminPanel adminPanel;
    private ServerUI serverUI;
    private ServerUIControls serverUIControls;

    public AdminControls(AdminPanel adminPanel,  ServerUI serverUI, ServerUIControls serverUIControls){
        this.adminPanel = adminPanel;
        this.serverUI = serverUI;
        this.serverUIControls = serverUIControls;
        this.adminPanel.addMarchandisesPaneListener(new MarchandisesPaneChangeListener());
    }
    class MarchandisesPaneChangeListener  implements ChangeListener {

        public void stateChanged(ChangeEvent e) {
            int index = adminPanel.getMarchandisesPaneIndex();
            switch (index) {
                case 0 : // Categories
                for (Category cat : getCategories()) {
                    adminPanel.addNewCategoryPanel(cat);
                }
                adminPanel.showItems();
                break;
                case 1: // Products

                break;
                default:
                break;
            }
            serverUI.viewRefresh();
        }
    }


    class PopUpMenu extends JPopupMenu {
        JMenuItem newItem;
        JMenuItem editItem;
        JMenuItem deleteItem;

        public PopUpMenu() {
            newItem = new JMenuItem("Nouveau");
            add(newItem);

            editItem = new JMenuItem("Modifier");
            add(editItem);

            deleteItem = new JMenuItem("Supprimer");
            add(deleteItem);
        }
    }

    class PopClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (e.isPopupTrigger())
                doPop(e);
        }

        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger())
                doPop(e);
        }

        private void doPop(MouseEvent e) {
                PopUpMenu menu = new PopUpMenu();
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    private List<Category> getCategories() {

        //DefaultHttpClient httpClient = new DefaultHttpClient();
        // String request = serverUIControls.getProperty("server.url") + "categories/all";
        String request = "http://localhost:8080/categories/all";
        List<Category> categories = null;

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

            HttpGet getRequest = new HttpGet(request);

            // Set the API media type in http accept header
            getRequest.addHeader("accept", "application/json");

            //Send the request; It will immediately return the response in HttpResponse object
            HttpResponse response = httpClient.execute(getRequest);


            // Verify valid error code first
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
            }

            // parsing json to objects
            ObjectMapper mapper = new ObjectMapper();
            categories = Arrays.asList(mapper.readValue(response.getEntity().getContent(), Category[].class));

        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        try
        {
            //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
            //Choice depends on type of method you will be invoking.
            HttpGet getRequest = new HttpGet(request);

            // Set the API media type in http accept header
            getRequest.addHeader("accept", "application/json");

            //Send the request; It will immediately return the response in HttpResponse object
            HttpResponse response = httpClient.execute(getRequest);


            // Verify valid error code first
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
            }

            ObjectMapper mapper = new ObjectMapper();

            categories = Arrays.asList(mapper.readValue(response.getEntity().getContent(), Category[].class));

            // shutdown the connection when done
            httpClient.getConnectionManager().shutdown();
        }
        catch(ClientProtocolException e)
        {
            e.printStackTrace();
        }
*/
        return categories;
    }

}