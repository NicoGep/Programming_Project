//package screens;
//
//import java.awt.BorderLayout;
//
//import javax.swing.JFrame;
//import javax.swing.WindowConstants;
//
//import com.teamdev.jxbrowser.browser.*;
//import com.teamdev.jxbrowser.view.swing.*;
//
//import master.MasterScreen;
//
//public class KarteScreen extends MasterScreen {
//
//    public static void main(String[] args) {
//        Browser browser = BrowserFactory.create();
//        JFrame frame = new JFrame("JxBrowser Google Maps");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.add(browser.getView().getComponent(), BorderLayout.CENTER);
//        frame.setSize(700, 500);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        browser.loadURL("http://maps.google.com");
//    }
//}