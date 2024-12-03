package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;  // Import Media class

public class Store {
    // Attribute: A list to hold Media items in the store
    private ArrayList<Media> itemsInStore;

    // Constructor
    public Store() {
        this.itemsInStore = new ArrayList<>();
    }

    // Method to add a Media item to the store
    public void addMedia(Media media) {
        if (media != null) {
            itemsInStore.add(media);
            System.out.println("Media added: " + media);
        } else {
            System.out.println("Cannot add a null Media item.");
        }
    }

    // Method to remove a Media item from the store by title
    public void removeMedia(String title) {
        boolean found = false;
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                itemsInStore.remove(media);
                System.out.println("Media removed: " + media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No Media found with title: " + title);
        }
    }

    // Method to display all Media items in the store
    public void displayStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("*************** STORE ***************");
            for (Media media : itemsInStore) {
                System.out.println(media);
            }
            System.out.println("*************************************");
        }
    }
}
