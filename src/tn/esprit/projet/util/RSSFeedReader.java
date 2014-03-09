/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.util;

import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.atom.Link;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEnclosureImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author tasnim
 */

public class RSSFeedReader {
    
    public List<String> getImages (String url){
         List<String> images= new ArrayList<String>();
        try {
           
            URL feedUrl = new URL(url);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            
            Iterator entryIter = feed.getEntries().iterator();
            while (entryIter.hasNext()) {
                SyndEntry entry = (SyndEntry) entryIter.next();
                List<SyndEnclosure> encls = entry.getEnclosures();
                if(!encls.isEmpty()){
                    for(SyndEnclosure e : encls){
                        String imgURL = e.getUrl().toString();
                        images.add(imgURL);
                    }
                }
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FeedException ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }
    
    public ObservableList<String> getTitle(String url) {
        
         ObservableList<String> titles = FXCollections.observableArrayList();
        try {
            URL feedUrl = new URL(url);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            Iterator entryIter = feed.getEntries().iterator();
            while (entryIter.hasNext()) {
                SyndEntry entry = (SyndEntry) entryIter.next();
                 String desc = entry.getTitleEx().getValue();
                  String s = desc.replaceAll("<[^>]*>", "")+"\n";
                  s = s.replaceAll("&nbsp", "")+"\n";
                  titles.add(s);                     
                }
        }catch(Exception ex){}
        return titles;
    
    }
    
      public List<String> getItems(String url) {
        List<String> events = new ArrayList<String>();
        try {
            URL feedUrl = new URL(url);            
            SyndFeedInput input = new SyndFeedInput();

            SyndFeed feed = input.build(new XmlReader(feedUrl));

            Iterator entryIter = feed.getEntries().iterator();
            while (entryIter.hasNext()) {
                SyndEntry entry = (SyndEntry) entryIter.next();           
                 String desc = entry.getDescription().getValue();
                  String s = desc.replaceAll("<[^>]*>", "")+"\n";
                  s = s.replaceAll("&nbsp", "")+"\n";                 
                  String event = s ;
                  events.add(event);
                   
                }
    
            }
            
  

         catch (Exception ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return events;
        
        
        
    }
    
     

}
