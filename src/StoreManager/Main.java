package StoreManager;

import WidgetOrder.CreateFixtures;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/5/13
 * Time: 7:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        new CreateFixtures().run();

        new StoreManager().start();
    }
}
