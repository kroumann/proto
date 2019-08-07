package server.controls;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.Arrays;
import javax.swing.event.ChangeListener;
import java.awt.*;


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

        this.adminPanel.addNewAbstractAction(new newACategoryAbstractAction());
        // show default data
        this.adminPanel.addCategories(getCategories());
        this.adminPanel.showItems();
        this.serverUI.viewRefresh();
    }
    class MarchandisesPaneChangeListener  implements ChangeListener {

        public void stateChanged(ChangeEvent e) {
            int index = adminPanel.getMarchandisesPaneIndex();
            switch (index) {
                case 0 : // Categories
                for (Category cat : getCategories()) {
                    adminPanel.addNewCategoryPanel(cat);
                }
                //adminPanel.showItems();
                break;
                case 1: // Products

                break;
                default:
                break;
            }
            serverUI.viewRefresh();
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
            getRequest.addHeader("accept", "application/json; charset=UTF-8");

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
        return categories;
    }

    class newACategoryAbstractAction extends AbstractAction {
        private JTextField nmField;
        private JTextField urlField;
        private JTextArea description;
        JPanel panel;

        newACategoryAbstractAction() {
            super("New Category");
            nmField = new JTextField(20);
            urlField = new JTextField(20);
            description = new JTextArea();
            description.setBounds(10, 10, 10, 10);

            panel = new JPanel(new GridLayout(3, 1));

            panel.add(nmField);
            panel.add(urlField);
            panel.add(description);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int res = JOptionPane.showConfirmDialog(null, panel, "New Category", JOptionPane.OK_CANCEL_OPTION);
            if (res == JOptionPane.OK_OPTION) {

            }
        }
    }

}